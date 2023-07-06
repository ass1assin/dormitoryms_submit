<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/css/moveout.css">
</head>
<body>
<div id="content">
    <aside style="background: white">
        <jsp:include page="commonside.jsp" />
    </aside>
    <main style="background: white;padding: 15px 0px 15px 0px"><section>
<nav>
  <div>
    <ul>
      <li>
        <a style="font-size: 26px;">DORMS宿舍管理系统-系统管理员</a>
      </li>
    </ul>
    <span style="color: #CCCCCC;font-size: 26px;position: relative;top: 5px;"></span>
    <ul>
      <li>
        <a>欢迎您,${systemAdmin.name}</a>
      </li>
      <li>
        <a href="/account?method=logout">安全退出</a>
        上传文件

      </li>
        <form method="post" enctype="multipart/form-data" action="uploadServlet">
            姓名：<input type="text" name="uname"> <br>
            文件：<input type="file" name="myfile"> <br>
            <!-- button默认的类型是提交类型 type="submit" -->
            <button>提交</button>
        </form>
    </ul>
  </div>
</nav>
    </section></main>
</div>
</body>
</html>
