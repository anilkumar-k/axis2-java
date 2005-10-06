package org.apache.axis2.om.impl.dom;

import org.apache.axis2.om.OMContainer;
import org.apache.axis2.om.OMException;
import org.apache.axis2.om.OMNode;
import org.apache.axis2.om.impl.OMOutputImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

import java.util.Hashtable;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * @author Ruchith Fernando (ruchith.fernando@gmail.com)
 */
public class DocumentImpl extends ParentNode implements Document {

	
    protected Hashtable identifiers;
    
	/**
	 * @param ownerDocument
	 */
	public DocumentImpl(DocumentImpl ownerDocument) {
		super(ownerDocument);
	}

	protected DocumentImpl() {
		
	}
	
	///
	///OMNode methods
	////
	public void setType(int nodeType) throws OMException {
		throw new UnsupportedOperationException("In OM Document object doesn't have a type");
	}
	public int getType() throws OMException {
		throw new UnsupportedOperationException("In OM Document object doesn't have a type");
	}
	
	public void serialize(OMOutputImpl omOutput) throws XMLStreamException {
		// TODO Auto-generated method stub
	}	

	///
	///Override ChildNode specific methods
	///
	public OMNode getNextOMSibling() throws OMException {
		throw new UnsupportedOperationException("This is the document node");
	}
	public Node getNextSibling() {
		throw new UnsupportedOperationException("This is the document node");
	}
	public OMContainer getParent() throws OMException {
		throw new UnsupportedOperationException("This is the document node");
	}
	public OMNode getPreviousOMSibling() {
		throw new UnsupportedOperationException("This is the document node");
	}
	public Node getPreviousSibling() {
		throw new UnsupportedOperationException("This is the document node");
	}
	public void setNextOMSibling(OMNode node) {
		throw new UnsupportedOperationException("This is the document node");
	}
	public void setParent(OMContainer element) {
		throw new UnsupportedOperationException("This is the document node");
	}
	public void setPreviousOMSibling(OMNode node) {
		throw new UnsupportedOperationException("This is the document node");
	}
	
	
	
	///
	///org.w3c.dom.Node methods
	///
	public String getNodeName() {
		return "#document";
	}
	public short getNodeType() {
		return Node.DOCUMENT_NODE;
	}
	
	///org.w3c.dom.Document methods
	///
	
	public Attr createAttribute(String arg0) throws DOMException {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}
	
	public Attr createAttributeNS(String arg0, String arg1) throws DOMException {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}
	
	public CDATASection createCDATASection(String arg0) throws DOMException {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}
	
	public Comment createComment(String arg0) {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}
	
	public DocumentFragment createDocumentFragment() {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}
	
	public Element createElement(String tagName) throws DOMException {
		return new ElementImpl(this, tagName);
	}
	
	public Element createElementNS(String tagName, String ns)
			throws DOMException {
		NamespaceImpl namespace = new NamespaceImpl(ns);
		return new ElementImpl(this, tagName, namespace);
	}
	
	public EntityReference createEntityReference(String arg0)
			throws DOMException {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}
	public ProcessingInstruction createProcessingInstruction(String arg0,
			String arg1) throws DOMException {
		throw new UnsupportedOperationException("PIs are not supported by OM yet :-?");
	}
	public Text createTextNode(String value) {
		return new TextImpl(this, value);
	}
	public DocumentType getDoctype() {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}
	public Element getDocumentElement() {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}
	public Element getElementById(String arg0) {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}
	public NodeList getElementsByTagName(String arg0) {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}
	public NodeList getElementsByTagNameNS(String arg0, String arg1) {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}
	public DOMImplementation getImplementation() {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}
	public Node importNode(Node arg0, boolean arg1) throws DOMException {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}

	public void serialize(XMLStreamWriter xmlWriter) throws XMLStreamException {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}

	public void serializeAndConsume(OMOutputImpl omOutput) throws XMLStreamException {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}

	public void serializeAndConsume(XMLStreamWriter xmlWriter) throws XMLStreamException {
		//TODO
		throw new UnsupportedOperationException("TODO");
	}

}
