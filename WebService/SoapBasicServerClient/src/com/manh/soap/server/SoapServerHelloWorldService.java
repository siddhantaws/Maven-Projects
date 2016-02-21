/**
 * SoapServerHelloWorldService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.manh.soap.server;

public interface SoapServerHelloWorldService extends javax.xml.rpc.Service {
    public java.lang.String getSoapServerHelloWorldAddress();

    public com.manh.soap.server.SoapServerHelloWorld getSoapServerHelloWorld() throws javax.xml.rpc.ServiceException;

    public com.manh.soap.server.SoapServerHelloWorld getSoapServerHelloWorld(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
