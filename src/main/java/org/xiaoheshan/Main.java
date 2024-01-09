package org.xiaoheshan;


import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

public class Main {
    public static void main(String[] args) {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setProvider(new JacksonJsonProvider());
        factoryBean.setAddress("http://localhost:8080");
        factoryBean.setResourceClasses(OrderServiceImpl.class);

        Server server = factoryBean.create();

        System.out.println("Server ready...");
    }
}