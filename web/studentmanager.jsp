<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>宿舍管理系统</title>
    <link rel="stylesheet" href="css/css/moveout.css">
</head>
<body style="height: 850px;background: #bfdaf5">

<div id="content">
    <aside style="background: white">
        <jsp:include page="commonside.jsp" />
    </aside>
    <main style="background: white;padding: 15px 0px 15px 0px"><section>
<div style="margin-left: 90px">
    <div>
        <div>
            <!-- 顶部搜索部分 -->
            <div>
                <div>
                    <form action="/student?method=list" method="post">
                        <div style="margin-left: 20px">
                            <button type="submit">
										<span style="margin-right: 5px" aria-hidden="true">
										</span>查看学生信息表
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <!-- 列表展示-->
            <div>
                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>宿舍</th>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>状态</th>
                        <th>入住时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="student">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.number}</td>
                            <td>${student.name}</td>
                            <td>${student.gender}</td>
                            <td>${student.state}</td>
                            <td>${student.createDate}</td>
                            <td>
                                <div>
<%--                                    <button type="button"--%>
<%--                                            data-id="${student.id}"--%>
<%--                                            data-number="${student.number}"--%>
<%--                                            data-name="${student.name}"--%>
<%--                                            data-gender="${student.gender}"--%>
<%--                                            data-state="${student.state}"--%>
<%--                                            data-create-date="${student.createDate}"--%>
<%--                                            data-toggle="modal"--%>
<%--                                            data-target="#updateUserModal">--%>
<%--                                        <i>修改</i>--%>
<%--                                    </button>--%>

<%--                                    <button type="button"--%>
<%--                                            data-id="${student.id}"--%>
<%--                                            data-toggle="modal"--%>
<%--                                            onclick="" data-target="#delUserModal">--%>
<%--                                        <i class="fa fa-user-times">删除</i>--%>
<%--                                    </button>--%>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <!-- add框示例（Modal） -->



            </div>
        </div>
    </div>
</div>
    </section></main>
</div>
