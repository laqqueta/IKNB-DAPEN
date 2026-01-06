/**
 * CAMServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class CAMServiceLocator extends org.apache.axis.client.Service implements org.tempuri.CAMService {

    public CAMServiceLocator() {
    }


    public CAMServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CAMServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_ICAMService
//    private java.lang.String BasicHttpBinding_ICAMService_address = "http://camservice.ojk.go.id/CAMService.svc"; // Production
//    private java.lang.String BasicHttpBinding_ICAMService_address = "http://10.210.240.18:8888/CAMService.svc";	// Devel
    private java.lang.String BasicHttpBinding_ICAMService_address;// = DummySetup.serverConfig.CAMService;

    public java.lang.String getBasicHttpBinding_ICAMServiceAddress() {
        return BasicHttpBinding_ICAMService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_ICAMServiceWSDDServiceName = "BasicHttpBinding_ICAMService";

    public java.lang.String getBasicHttpBinding_ICAMServiceWSDDServiceName() {
        return BasicHttpBinding_ICAMServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_ICAMServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_ICAMServiceWSDDServiceName = name;
    }

    public org.tempuri.ICAMService getBasicHttpBinding_ICAMService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_ICAMService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_ICAMService(endpoint);
    }

    public org.tempuri.ICAMService getBasicHttpBinding_ICAMService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.BasicHttpBinding_ICAMServiceStub _stub = new org.tempuri.BasicHttpBinding_ICAMServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_ICAMServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_ICAMServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_ICAMService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.ICAMService.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.BasicHttpBinding_ICAMServiceStub _stub = new org.tempuri.BasicHttpBinding_ICAMServiceStub(new java.net.URL(BasicHttpBinding_ICAMService_address), this);
                _stub.setPortName(getBasicHttpBinding_ICAMServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BasicHttpBinding_ICAMService".equals(inputPortName)) {
            return getBasicHttpBinding_ICAMService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "CAMService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_ICAMService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_ICAMService".equals(portName)) {
            setBasicHttpBinding_ICAMServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
