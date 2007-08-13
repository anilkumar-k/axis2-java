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
package org.apache.axis2.rmi.metadata;

import junit.framework.TestCase;
import org.apache.axis2.rmi.Configurator;
import org.apache.axis2.rmi.exception.MetaDataPopulateException;
import org.apache.axis2.rmi.exception.SchemaGenerationException;
import org.apache.axis2.rmi.metadata.service.FaultService;
import org.apache.axis2.description.WSDL11ToAxisServiceBuilder;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLWriter;
import java.io.FileWriter;
import java.io.IOException;


public class FaultServiceTest extends TestCase {

    public void testGenerateSchema() {
        Configurator configurator = new Configurator();
        Service service = new Service(FaultService.class, configurator);
        try {
            service.populateMetaData();
            service.generateWSDL();
            Definition definition = service.getWsdlDefinition();

            WSDL11ToAxisServiceBuilder bulder = new WSDL11ToAxisServiceBuilder(definition, null, null);
            bulder.populateService();

        } catch (MetaDataPopulateException e) {
            fail();
        } catch (SchemaGenerationException e) {
            fail();
        } catch (IOException e) {
            fail();
        }
    }
}
