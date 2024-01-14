package org.xiaoheshan;

import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxws.EndpointImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BootStrap
 * <p>
 *     BootStrap is a singleton class, which is used to configure and start the RESTful and SOAP service.
 * </p>
 */
public class BootStrap {
    private static volatile BootStrap instance;
    private static final List<JAXRSServerFactoryBean> rsList = new ArrayList<>();
    private static final Map<Object, String> wsList = new HashMap<>();


    private BootStrap() {
    }

    public static BootStrap getInstance() {
        if (instance == null) {
            synchronized (BootStrap.class) {
                if (instance == null) {
                    instance = new BootStrap();
                }
            }
        }
        return instance;
    }


    public BootStrap configRs(Class<?> serviceClazz, String serviceName) {
        JAXRSServerFactoryBean serviceNameBean = new JAXRSServerFactoryBean();
        serviceNameBean.setResourceClasses(serviceClazz);
        serviceNameBean.setAddress("http://localhost:8080/" + serviceName);
        rsList.add(serviceNameBean);
        return this;
    }

    public BootStrap configWs(Class<?> serviceClazz, String serviceName)  {
        Object o = null;
        try {
            o = serviceClazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        String address = "http://localhost:8080/" + serviceName;
        wsList.put(o, address);

        return this;
    }

    public BootStrap start() {
        rsList.forEach(JAXRSServerFactoryBean::create);
        wsList.forEach((o, address) -> EndpointImpl.publish(address, o, new LoggingFeature()));
        return this;
    }
}
