package org.xiaoheshan.Service;


import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import org.xiaoheshan.pojo.Person;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface PersonService {

    @WebMethod(action = "sayHello")
    public String sayHello(String name);

    @WebMethod
    public Person getPerson(String id);
}
