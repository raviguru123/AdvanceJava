package org.org.headfirst.designpatterns.structural.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {
    private RealInternet realInternet = new RealInternet();
    static List<String> bannedsites;

    static {
        bannedsites = new ArrayList<>();
        bannedsites.add("abc");
        bannedsites.add("xyz");
        bannedsites.add("binzo");
    }

    public void connect(String server) throws Exception {
        if (bannedsites.contains(server.toLowerCase())) {
            throw new Exception("you are not allowed to access restricted sites");
        }
        this.realInternet.connect(server);
    }
}
