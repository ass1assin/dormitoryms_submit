package com.southwind.service.impl;

import com.southwind.dao.StudentDao;
import com.southwind.dao.impl.StudentDaoImpl;
import com.southwind.entity.Student;
import com.southwind.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();


    @Override
    public List<Student> list(String value) {
        return this.studentDao.list(value);
    }

//    @Override
//    public void update(Student student) {
//        Integer update = this.studentDao.update(student);
//    }
//
//    @Override
//    public void delete(Integer id) {
//        Integer delete = this.studentDao.delete(id);
//
//    }

    }

