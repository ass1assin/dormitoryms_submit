package com.southwind.service;

import com.southwind.dto.StudentAddDto;
import com.southwind.entity.StudentAdd;

public interface StudentAddService {
    public void save(StudentAdd studentAdd) ;

    public StudentAddDto login(String username, String password);

}
