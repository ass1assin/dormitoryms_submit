<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>登录界面</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/css/login.css">
</head>
<body>
<div>
  <div id="login">
    <form id="login_form" action="<%= request.getContextPath()%>/account?method=login" method="post">
      <h3 >用户登录</h3>
      <div >
        <div>

          <input required placeholder="请输入用户名" type="text"name="username"/>
        </div>
        <span style="color: red;font-size: 13px;margin: 0 80px 0 150px;">${usernameError}</span>
        <div >

          <input required placeholder="请输入密码" type="password" name="password"/>
        </div>
        <span style="color: red;font-size: 13px;margin: 0 80px 0 150px;">${passwordError}</span>
        <div >

          <label>
            <input type="radio" name="type" value="studentAdd"> 学生
          </label>
          <label >
          <input type="radio" name="type" checked value="systemAdmin"> 系统管理员
        </label>
        </div>


        <input required placeholder="请输入验证码" type="password" name="checkcode"/>
        <span style="color: red;font-size: 13px;margin: 0 80px 0 150px;">${checkcodeError}</span>
        <span style="margin-left: 130px"><img src="/checkcodeServlet"></span>


        <div >
          <button type="submit" name="submit">登录</button>
          <button type="reset" name="submit">重置</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>
