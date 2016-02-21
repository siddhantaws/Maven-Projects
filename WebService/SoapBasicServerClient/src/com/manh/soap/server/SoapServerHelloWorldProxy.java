package com.manh.soap.server;

public class SoapServerHelloWorldProxy implements com.manh.soap.server.SoapServerHelloWorld {
  private String _endpoint = null;
  private com.manh.soap.server.SoapServerHelloWorld soapServerHelloWorld = null;
  
  public SoapServerHelloWorldProxy() {
    _initSoapServerHelloWorldProxy();
  }
  
  public SoapServerHelloWorldProxy(String endpoint) {
    _endpoint = endpoint;
    _initSoapServerHelloWorldProxy();
  }
  
  private void _initSoapServerHelloWorldProxy() {
    try {
      soapServerHelloWorld = (new com.manh.soap.server.SoapServerHelloWorldServiceLocator()).getSoapServerHelloWorld();
      if (soapServerHelloWorld != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)soapServerHelloWorld)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)soapServerHelloWorld)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (soapServerHelloWorld != null)
      ((javax.xml.rpc.Stub)soapServerHelloWorld)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.manh.soap.server.SoapServerHelloWorld getSoapServerHelloWorld() {
    if (soapServerHelloWorld == null)
      _initSoapServerHelloWorldProxy();
    return soapServerHelloWorld;
  }
  
  public java.lang.String getWebService() throws java.rmi.RemoteException{
    if (soapServerHelloWorld == null)
      _initSoapServerHelloWorldProxy();
    return soapServerHelloWorld.getWebService();
  }
  
  
}