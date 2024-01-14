package org.xiaoheshan.Service.Impl;

import jakarta.jws.WebService;
import org.xiaoheshan.pojo.Person;
import org.xiaoheshan.Service.PersonService;

@WebService(endpointInterface = "org.xiaoheshan.Service.PersonService",
        serviceName = "PersonService")
public class PersonServiceImpl implements PersonService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public Person getPerson(String id) {
        return new Person(1, "person1", "person1 description");
    }
}
