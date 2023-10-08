package org.org.headfirst.designpatterns.structural.proxy;

public class Driver {
    public static void main(String[] args) throws Exception {
        ProxyInternet proxyInternet = new ProxyInternet();
//        proxyInternet.connect("abc");
        proxyInternet.connect("xyz.com");
    }
}
