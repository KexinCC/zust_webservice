package org.xiaoheshan;


import org.xiaoheshan.Service.Impl.*;

public class ServerApplication {

    // create a BootStrap instance
    private final static BootStrap bootStrap = BootStrap.getInstance();

    public static void main(String[] args) {

        // configure the RESTful and SOAP service
        bootStrap
                .configRs(ChatServiceImpl.class, "chatservice")
                .configWs(ChatSoapImpl.class, "chatsoap")
                .configRs(CorrectMovieNameServiceImpl.class, "correctmoviename")
                .configRs(QueryMovieImpl.class, "querymovies")
                .configWs(QueryMovieSoapImpl.class, "querymoviesoap")
                .start();


    }
}