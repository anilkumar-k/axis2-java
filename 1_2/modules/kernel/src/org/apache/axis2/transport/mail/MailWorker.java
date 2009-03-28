/*
* Copyright 2004,2005 The Apache Software Foundation.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/


package org.apache.axis2.transport.mail;

import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.engine.AxisEngine;
import org.apache.axis2.util.MessageContextBuilder;

public class MailWorker implements Runnable {
    private ConfigurationContext configContext = null;
    private MessageContext messageContext;

    /**
     * Constructor for MailWorker
     *
     */
    public MailWorker(ConfigurationContext reg, MessageContext messageContext) {
        this.configContext = reg;
        this.messageContext = messageContext;
    }

    /**
     * The main workhorse method.
     */
    public void run() {
        AxisEngine engine = new AxisEngine(configContext);
        // create and initialize a message context
        try {
            if (messageContext.getEnvelope().getBody().hasFault()) {
                engine.receiveFault(messageContext);
            } else {
                engine.receive(messageContext);
            }

        } catch (Exception e) {
            try {
                if (messageContext != null&&!messageContext.isServerSide()) {
                    MessageContext faultContext =
                            MessageContextBuilder.createFaultMessageContext(messageContext, e);
                    engine.sendFault(faultContext);
                }
            } catch (Exception e1) {
                // Ignore errors that would possibly happen this catch
            }
        }

    }


}