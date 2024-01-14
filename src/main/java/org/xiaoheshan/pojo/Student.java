package org.xiaoheshan.pojo;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
    private String name;
    private Integer age;
    private String description;

    public Student() {
    }

    public Student(String name, Integer age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
