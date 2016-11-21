package com.song.remoting;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiClient {

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        String url = "rmi://localhost:8888/com.song.remoting.HelloService";
        HelloService helloService = (HelloService) Naming.lookup(url);
        System.out.println(helloService.syayHello("Zhangsong"));
    }
}
