package com.song.remoting;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RmiServer {

    public static void main(String[] args) throws Exception {
        int port = 8888;
        LocateRegistry.createRegistry(port);
        String url = "rmi://localhost:" + port
                + "/com.song.remoting.HelloService";
        Naming.rebind(url, new HelloServiceImpl());
    }
}
