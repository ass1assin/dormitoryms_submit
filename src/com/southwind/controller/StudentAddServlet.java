package com.southwind.controller;

import com.southwind.entity.Student;
import com.southwind.entity.StudentAdd;
import com.southwind.entity.StudentAddmi;
import com.southwind.service.StudentAddService;
import com.southwind.service.StudentService;
import com.southwind.service.impl.StudentAddServiceImpl;
import com.southwind.service.impl.StudentServiceImpl;
import com.southwind.dto.StudentAddDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentadd")
public class StudentAddServlet extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl();
    private StudentAddService studentaddService = new StudentAddServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");

//        StudentAddDto studentAddDto=this.studentaddService.save();

        switch (method){
            case "save":
                String number = req.getParameter("number");
                String name = req.getParameter("name");
                String gender = req.getParameter("gender");
                String state = req.getParameter("state");
                String create_date = req.getParameter("create_date");
                this.studentaddService.save(new StudentAdd(number,name,gender,state,create_date));
//                if (stu)
//                req.setAttribute(submitSuccess,);
                resp.sendRedirect("studentadd.jsp");
                break;

        }

}}
