package org.xiaoheshan;


import org.xiaoheshan.Service.Impl.ChatServiceImpl;
import org.xiaoheshan.Service.Impl.OrderServiceImpl;
import org.xiaoheshan.Service.Impl.PersonServiceImpl;

public class Main {

    private final static BootStrap bootStrap = BootStrap.getInstance();

    public static void main(String[] args) {

        bootStrap
                .configRs(OrderServiceImpl.class, "orderservice")
                .configWs(PersonServiceImpl.class, "personservice")
                .configRs(ChatServiceImpl.class, "chatservice")
                .start();


    }
}