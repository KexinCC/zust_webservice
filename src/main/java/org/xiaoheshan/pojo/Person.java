package org.xiaoheshan.pojo;


import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    private Integer id;
    private String name;
    private String description;

    public Person() {
    }

    public Person(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
        ", description='" + description + '\'' +
                '}';
    }
}
