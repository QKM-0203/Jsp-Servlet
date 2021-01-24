<%--
  Created by IntelliJ IDEA.
  User: qikaimeng
  Date: 2021/1/23
  Time: 下午6:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加联系人</title>
</head>
<body>
<div class="content" >
    <center><h3>添加联系人</h3></center>
<form action="${pageContext.request.contextPath}/addUserServlet" method="post">
    <div class="form-group">
        <label for="name">姓名：</label>
        <input type="text" class="form-control" id="name" name= "name" placeholder="请输入姓名">
    </div>

    <div class="form-group">
        <label for="name">性别：</label>
        <input type="radio" name="sex" value="男" checked="checked"/>男
        <input type="radio" name="sex" value="女" />女
    </div>

    <div class="form-group">
        <label for="name">年龄：</label>
        <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
    </div>

    <div class="form-group">
        <label for="name">籍贯：</label>
        <select name="birth" class="form-control" id="address">
            <option value="山西">山西</option>
            <option value="陕西">陕西</option>
            <option value="新疆">新疆</option>
            <option value="湖南">湖南</option>
            <option value="河北">河北</option>
            <option value="广东">广东</option>
            <option value="安徽">安徽</option>
        </select>
    </div>
    <div class="form-group">
    <label for="name">qq：</label>
    <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入qq号码">
    </div>
    <div class="form-group">
    <label for="name">mail：</label>
    <input type="text" class="form-control" id="mail" name="mail" placeholder="请输入mail">
    </div>

    <div class="form-group ">
        <input class="btn btn-primary" type="submit" value="提交"/>
        <input class="btn btn-default" type="reset" value="重置"/>
        <input class="btn btn-default" type="button" value="返回"/>
    </div>
   </form>
</div>
</body>
</html>
