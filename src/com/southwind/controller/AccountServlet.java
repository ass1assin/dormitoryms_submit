package com.southwind.controller;

import com.southwind.dto.StudentAddDto;
import com.southwind.dto.SystemAdminDto;
import com.southwind.service.StudentAddService;
import com.southwind.service.SystemAdminService;
import com.southwind.service.impl.StudentAddServiceImpl;
import com.southwind.service.impl.SystemAdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/")
public class AccountServlet extends HttpServlet {

    private SystemAdminService systemAdminService = new SystemAdminServiceImpl();
    private StudentAddService studentAddService = new StudentAddServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        //3.先获取生成的验证码
        HttpSession session = req.getSession();
        String checkcode_session = (String) session.getAttribute("checkcode_session");
        session.removeAttribute("checkcode_session");
        switch (method){
            case "login":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String checkcode = req.getParameter("checkcode");
                String type = req.getParameter("type");
                switch (type){
                    case "systemAdmin":
                        SystemAdminDto systemAdminDto = this.systemAdminService.login(username, password);
                        switch (systemAdminDto.getCode()){
                            case -1:
                                req.setAttribute("usernameError", "用户名不存在");
//                                请求转发，把"用户名不存在"的信息资源转发到login.jsp处理
                                req.getRequestDispatcher("login.jsp").forward(req, resp);
                                break;
                            case -2:
                                req.setAttribute("passwordError", "密码错误");
//                                请求被转发到 "login.jsp" 页面，在目标页面执行完成后，响应将发送回客户端。
                                req.getRequestDispatcher("login.jsp").forward(req, resp);
                                break;

                            case 0:
                                //跳转到登录成功界面
                                //checkcode_session.equalsIgnoreCase(checkcode)忽略字符串中的大小写差异且比较括号内容是否相等
                                //checkcode_session是图片里的验证码

                                if(checkcode_session!= null && checkcode_session.equalsIgnoreCase(checkcode)){
//                                    不必将输入的值存入session,直接比对就好
//                                session.setAttribute("systemAdmin", systemAdminDto.getSystemAdmin());
                                resp.sendRedirect("systemadmin.jsp");
                                break;}
                                else{
                                req.setAttribute("checkcodeError", "验证码错误");
                                req.getRequestDispatcher("login.jsp").forward(req, resp);
                                break;
                            }
                        }
                        break;
                    case "studentAdd":
                        StudentAddDto studentAddDto = this.studentAddService.login(username, password);
                        switch (studentAddDto.getCode()){
                            case -1:
                                req.setAttribute("usernameError", "用户名不存在");
                                req.getRequestDispatcher("login.jsp").forward(req, resp);
                                break;
                            case -2:
                                req.setAttribute("passwordError", "密码错误");
                                req.getRequestDispatcher("login.jsp").forward(req, resp);
                                break;
                            case 0:
                                //跳转到登录成功界面
//                                session.setAttribute("studentAdd", studentAddDto.getStudentAddmi());
                                resp.sendRedirect("studentadd.jsp");
                                break;
                        }
                        break;
                }
                break;
            case "logout":
                req.getSession().invalidate();
                resp.sendRedirect("login.jsp");
                break;
        }

    }
}
