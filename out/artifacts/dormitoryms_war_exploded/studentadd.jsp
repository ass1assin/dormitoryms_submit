<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/css/moveout.css">
</head>
<body  style="height: 850px;background: #bfdaf5">
<div id="content">
    <aside style="background: white">
        <jsp:include page="commonside.jsp" />
    </aside>
    <main><section>
<nav style="background: white;padding: 15px 0px 15px 10px">
    <div style="margin-left: 60px">
        <ul>
            <li>
                <a style="font-size: 26px;">宿舍管理系统-学生</a>
            </li>
        </ul>
        <span style="color: #CCCCCC;font-size: 26px;position: relative;top: 5px;"></span>
        <ul>
            <li>
                <a>欢迎您,${studentAdd.name}</a>
            </li>
            <li>
                <a href="/account?method=logout">安全退出</a>
            </li>
        </ul>
        <form method="post" action="<%= request.getContextPath()%>/studentadd?method=save" style="margin-top: 0px" id="form_data" style="margin: 20px;">
            <div>

                        <div>
                            <h4>添加学生信息</h4>
                        </div>
                        <div >
                            <form>

                                <div>
                                    <label for="user_id">学号</label>
                                    <div class="col-sm-9">
                                        <input type="text" required id="number" name="number" value="" placeholder="请输入学号">
                                    </div>
                                </div>

                                <div>
                                    <label for="user_id">姓名</label>
                                    <div class="col-sm-9">
                                        <input type="text" id="name" name="name" value="" placeholder="请输入姓名">
                                    </div>
                                </div>

                                <div>
                                    <label for="user_id">性别</label>
                                    <div class="col-sm-9">
                                        <input type="radio" checked value="男" name="gender">男
                                        &nbsp;&nbsp;&nbsp;<input type="radio" value="女" name="gender">女
                                    </div>
                                </div>

                                <div>
                                    <label for="user_id">状态</label>
                                    <div class="col-sm-9">
                                        <input type="text" required id="state" name="state" value="" placeholder="状态">
                                    </div>
                                </div>

                                <div>
                                    <label for="user_id">创建日期</label>
                                    <div class="col-sm-9">
                                        <input type="text" required id="create_date" name="create_date" value="" placeholder="状态">
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div>
                            <button type="submit" class="btn btn-primary">提交</button>
                        </div>
                ${submitSuccess}

            </div>
        </form>
    </div>
</nav>
    </section></main>
</div>

</body>
</html>
