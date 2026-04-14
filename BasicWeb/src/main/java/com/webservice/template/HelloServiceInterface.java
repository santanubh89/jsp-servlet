package com.webservice.template;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.RPC, use=Use.LITERAL)
@HandlerChain(file="service-handler.xml")
public interface HelloServiceInterface {

	@WebMethod
	String printMessage(String name);

}