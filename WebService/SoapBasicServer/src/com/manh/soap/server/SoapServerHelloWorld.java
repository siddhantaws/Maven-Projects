package com.manh.soap.server;

import javax.jws.WebService;

@WebService
public class SoapServerHelloWorld 
{
	public String getWebService() 
	{
		return "Hello World ";
	}
}
