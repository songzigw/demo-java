package com.song.remoting;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RmiServer {

    public static void main(String[] args) throws Exception {
        int port = 8888;
        String url = String.format("rim://%s:%d/%s", "localhost", port,
                "com.song.remoting.HelloService");
        LocateRegistry.createRegistry(port);
        Naming.rebind(url, new HelloServiceImpl());
    }
}
