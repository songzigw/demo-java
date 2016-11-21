package com.song.remoting;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl extends UnicastRemoteObject
        implements HelloService {

    private static final long serialVersionUID = -234923946983895134L;

    public HelloServiceImpl() throws RemoteException {
        
    }
    
    @Override
    public String syayHello(String name) throws RemoteException {
        return String.format("Hello %s", name);
    }

}
