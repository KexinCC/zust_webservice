package org.xiaoheshan.Service.Impl;

import org.xiaoheshan.Service.StudentService;
import org.xiaoheshan.pojo.Student;

public class StudentServiceImpl implements StudentService {

    @Override
    public Student getStudent(String id) {
        return new Student("student1", 1, "student1 description");
    }
}
