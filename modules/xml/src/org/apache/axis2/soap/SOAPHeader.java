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
package org.apache.axis2.soap;

import org.apache.axis2.om.OMElement;
import org.apache.axis2.om.OMException;
import org.apache.axis2.om.OMNamespace;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Interface SOAPHeader
 */
public interface SOAPHeader extends OMElement {
    /**
     * Creates a new <CODE>SOAPHeaderBlock</CODE> object
     * initialized with the specified name and adds it to this
     * <CODE>SOAPHeader</CODE> object.
     *
     * @param localName
     * @param ns
     * @return the new <CODE>SOAPHeaderBlock</CODE> object that
     *         was inserted into this <CODE>SOAPHeader</CODE>
     *         object
     * @throws org.apache.axis2.om.OMException if a SOAP error occurs
     */
    public abstract SOAPHeaderBlock addHeaderBlock(
            String localName, OMNamespace ns) throws OMException;

    /**
     * Returns a list of all the <CODE>SOAPHeaderBlock</CODE>
     * objects in this <CODE>SOAPHeader</CODE> object that have the
     * the specified role. An role is a global attribute that
     * indicates the intermediate parties to whom the message should
     * be sent. An role receives the message and then sends it to
     * the next role. The default role is the ultimate intended
     * recipient for the message, so if no role attribute is
     * included in a <CODE>SOAPHeader</CODE> object, the message is
     * sent to its ultimate destination.
     *
     * @param role a <CODE>String</CODE> giving the
     *              URI of the role for which to search
     * @return an <CODE>Iterator</CODE> object over all the <CODE>
     *         SOAPHeaderBlock</CODE> objects that contain the
     *         specified role
     * @see #extractHeaderBlocks(java.lang.String) extractHeaderBlocks(java.lang.String)
     */
    public abstract Iterator examineHeaderBlocks(String role);

    /**
     * Returns a list of all the <CODE>SOAPHeaderBlock</CODE>
     * objects in this <CODE>SOAPHeader</CODE> object that have
     * the the specified role and detaches them from this <CODE>
     * SOAPHeader</CODE> object.
     * <P>This method allows an role to process only the parts of
     * the <CODE>SOAPHeader</CODE> object that apply to it and to
     * remove them before passing the message on to the next
     * role.
     *
     * @param role a <CODE>String</CODE> giving the
     *              URI of the role for which to search
     * @return an <CODE>Iterator</CODE> object over all the <CODE>
     *         SOAPHeaderBlock</CODE> objects that contain the
     *         specified role
     * @see #examineHeaderBlocks(java.lang.String) examineHeaderBlocks(java.lang.String)
     */
    public abstract Iterator extractHeaderBlocks(String role);

    /**
     * Returns an <code>Iterator</code> over all the
     * <code>SOAPHeaderBlock</code> objects in this <code>SOAPHeader</code>
     * object that have the specified role and that have a MustUnderstand
     * attribute whose value is equivalent to <code>true</code>.
     *
     * @param role a <code>String</code> giving the URI of the role for which
     *              to search
     * @return an <code>Iterator</code> object over all the
     *         <code>SOAPHeaderBlock</code> objects that contain the
     *         specified role and are marked as MustUnderstand
     */
    public abstract Iterator examineMustUnderstandHeaderBlocks(String role);

    /**
     * Returns an <code>Iterator</code> over all the
     * <code>SOAPHeaderBlock</code> objects in this <code>SOAPHeader</code>
     * object.
     *
     * @return an <code>Iterator</code> object over all the
     *         <code>SOAPHeaderBlock</code> objects contained by this
     *         <code>SOAPHeader</code>
     */
    public abstract Iterator examineAllHeaderBlocks();

    /**
     * Returns an <code>Iterator</code> over all the
     * <code>SOAPHeaderBlock</code> objects in this <code>SOAPHeader </code>
     * object and detaches them from this <code>SOAPHeader</code> object.
     *
     * @return an <code>Iterator</code> object over all the
     *         <code>SOAPHeaderBlock</code> objects contained by this
     *         <code>SOAPHeader</code>
     */
    public abstract Iterator extractAllHeaderBlocks();
    
    /**
     * Return all the Headers that has the Namespace URI to given NS URI 
     * @param nsURI
     * @return
     */
    public ArrayList getHeaderBlocksWithNSURI(String nsURI);
}
