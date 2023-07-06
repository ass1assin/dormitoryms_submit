package com.southwind.dao.impl;

import com.southwind.dao.StudentDao;
import com.southwind.entity.Student;
import com.southwind.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> list(String value) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select id,number,name,gender,state,create_date from student";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Student> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String number = resultSet.getString(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String state = resultSet.getString(4);
                String createDate = resultSet.getString(5);
                list.add(new Student(id, number, name, gender, state, createDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

//    @Override
//    public Integer update(Student student) {
//        Connection connection = JDBCUtil.getConnection();
//        String sql = "update student set number = ?,name = ?,gender = ?,dormitory_id = ? where id = ?";
//        PreparedStatement statement = null;
//        Integer result = null;
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setString(1, student.getNumber());
//            statement.setString(2, student.getName());
//            statement.setString(3, student.getGender());
//            statement.setInt(4, student.getDormitoryId());
//            statement.setInt(5, student.getId());
//            result = statement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            JDBCUtil.release(connection, statement, null);
//        }
//        return result;
//    }
//
//    @Override
//    public Integer delete(Integer id) {
//        Connection connection = JDBCUtil.getConnection();
//        String sql = "delete from student where id = ?";
//        PreparedStatement statement = null;
//        Integer result = null;
//        try {
//            statement = connection.prepareStatement(sql);
//            result = statement.executeUpdate();
//            statement.setInt(1,id);
//            statement.executeUpdate();
//            statement.close();
//            connection.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            JDBCUtil.release(connection, statement, null);
//        }
//        return result;
//    }
}

