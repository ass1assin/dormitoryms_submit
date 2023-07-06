package com.southwind.dto;

import com.southwind.entity.StudentAddmi;
//code需要用来判断密码等是否正确
//StudentAddmi可以不要，因为accountservlet中已设置了case，不必使用session存储输入的数据
public class StudentAddDto {
    private Integer code;
    private StudentAddmi studentAddmi;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public StudentAddmi getStudentAddmi() {
        return studentAddmi;
    }

    public void setStudentAddmi(StudentAddmi studentAddmi) {
        this.studentAddmi = studentAddmi;
    }
}
