package com.southwind.controller;

import com.southwind.entity.Student;
import com.southwind.service.StudentService;
import com.southwind.service.impl.StudentServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method){
            case "list":
                String value = req.getParameter("value");
                req.setAttribute("list", this.studentService.list(value));
                req.getRequestDispatcher("studentmanager.jsp").forward(req, resp);
//                if (case:"delete"){
//                String idStr = req.getParameter("id");
//                Integer id = Integer.parseInt(idStr);
//                this.studentService.delete(id);
//                resp.sendRedirect("/student?method=list");
//                break;
//                }
                break;
//            case "update":
//                String idStr = req.getParameter("id");
//                Integer id = Integer.parseInt(idStr);
//                System.out.println(id);
//                String number = req.getParameter("number");
//                String name = req.getParameter("name");
//                String gender = req.getParameter("gender");
//                String state = req.getParameter("state");
//                String create_date = req.getParameter("create_date");
//                this.studentService.update(new Student(id,number,name,gender,state,create_date));
//                resp.sendRedirect("/student?method=list");
//                break;
//            case "delete":
//                idStr = req.getParameter("id");
//                id = Integer.parseInt(idStr);
//                this.studentService.delete(id);
//                resp.sendRedirect("/student?method=list");
//                break;

        }
    }
}
