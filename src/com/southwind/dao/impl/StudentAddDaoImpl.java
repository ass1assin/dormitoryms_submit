package com.southwind.dao.impl;

import com.southwind.dao.StudentAddDao;
import com.southwind.entity.StudentAddmi;
import com.southwind.entity.StudentAdd;
import com.southwind.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class StudentAddDaoImpl implements StudentAddDao {

public Integer save(StudentAdd studentAdd) {
    if (studentAdd == null || studentAdd.getNumber() == null || studentAdd.getName() == null || studentAdd.getGender() == null) {
        // 检查是否存在必要的属性，如果缺少必要属性，则终止操作
        return 0;
    }
    Connection connection = JDBCUtil.getConnection();
    String sql = "insert into student(number,name,gender,state,create_date) values(?,?,?,?,?)";
    PreparedStatement statement = null;
    Integer result = null;
    try {
        statement = connection.prepareStatement(sql);
        statement.setString(1, studentAdd.getNumber());
        statement.setString(2, studentAdd.getName());
        statement.setString(3, studentAdd.getGender());
        statement.setString(4, studentAdd.getState());
        statement.setString(5, studentAdd.getCreateDate());
        result = statement.executeUpdate();
        statement.close();
        connection.close();
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    } finally {
        JDBCUtil.release(connection, statement, null);
    }
    return result;
}

    @Override
    public StudentAddmi findByUsername(String username) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from student_admin where username = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StudentAddmi studentAddmi = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                studentAddmi = new StudentAddmi(id,username, password, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return studentAddmi;
    }
}
