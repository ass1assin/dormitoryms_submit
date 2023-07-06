package com.southwind.service.impl;

import com.southwind.dao.StudentAddDao;
import com.southwind.dao.impl.StudentAddDaoImpl;
import com.southwind.dto.StudentAddDto;
import com.southwind.entity.StudentAdd;
import com.southwind.entity.StudentAddmi;
import com.southwind.service.StudentAddService;

public class StudentAddServiceImpl implements StudentAddService {

    private StudentAddDao studentAddDao = new StudentAddDaoImpl();

    @Override
    public void save(StudentAdd studentAdd) {
//        StudentAddDto studentAddDto = new StudentAddDto();
        Integer save = this.studentAddDao.save(studentAdd);
//        if(save == 1)
//            studentAddDto.setCode(1);
        if(save != 1)throw new RuntimeException("宿管信息添加失败");
    }

    @Override
    public StudentAddDto login(String username, String password) {
        //1、通过username查询数据库
        //2、查询结果为空，username错误
        //3、查询结果不为空，再判断password是否正确
        StudentAddmi studentAddmi = this.studentAddDao.findByUsername(username);
        StudentAddDto studentAddDto = new StudentAddDto();
        if(studentAddmi == null){
            studentAddDto.setCode(-1);
        } else {
            if(!studentAddmi.getPassword().equals(password)){
                studentAddDto.setCode(-2);
            } else {
                studentAddDto.setCode(0);
                studentAddDto.setStudentAddmi(studentAddmi);
            }
        }
        return studentAddDto;
    }
}
