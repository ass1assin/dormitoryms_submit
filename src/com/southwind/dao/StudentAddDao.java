package com.southwind.dao;

import com.southwind.entity.StudentAdd;
import com.southwind.entity.StudentAddmi;

public interface StudentAddDao {

        Integer save(StudentAdd studentAdd);

    public StudentAddmi findByUsername(String username);
}
