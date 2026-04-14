package com.app.framework;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

@SuppressWarnings("unchecked")
public class HelloServiceHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext soapContext) {
		authenticate(soapContext);
		Set<String> keys = soapContext.keySet();
		SOAPMessage message = soapContext.getMessage();
		Boolean outboundProperty = (Boolean) soapContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		
		if (outboundProperty.booleanValue()) {
			System.out.println("Response::::");
		} else {
			/*for (String key : keys) {
				System.out.println("Value of Key [" + key + "] is ::" + context.get(key));
			}*/
			System.out.println("Request::::");
		}
		try {
			if (message.getSOAPHeader() != null)
				message.getSOAPHeader().detachNode();
			Source source = message.getSOAPPart().getContent();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			getTransformer().transform(source, new StreamResult(baos));
			System.out.println(baos.toString());
		} catch (Exception e) {
		}

		return true;
	}

	@Override
	public void close(MessageContext arg0) {

	}

	@Override
	public boolean handleFault(SOAPMessageContext arg0) {
		System.out.println("Caught SOAP Fault!");
		return false;
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}
	
	private static Transformer getTransformer() throws TransformerConfigurationException, TransformerFactoryConfigurationError{
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		
		return transformer;
	}
	
	private static void authenticate(SOAPMessageContext context){
		Map<String, List<String>> headermap = (Map<String, List<String>>) context
				.get(MessageContext.HTTP_REQUEST_HEADERS);
		if (null != headermap && headermap.size() > 0) {
			if (null != headermap.get("Username") && headermap.get("Username").size() != 0
					&& !headermap.get("Username").get(0).equalsIgnoreCase("Santanu")) {
				throw new RuntimeException("You don't have the access to this service...");
			}
		}
	}

}
