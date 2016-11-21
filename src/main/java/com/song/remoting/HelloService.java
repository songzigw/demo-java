package com.song.remoting;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {

    String syayHello(String name) throws RemoteException;
}
