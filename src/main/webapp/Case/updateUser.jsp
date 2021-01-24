<%--
  Created by IntelliJ IDEA.
  User: qikaimeng
  Date: 2021/1/24
  Time: 下午9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改联系人</title>
</head>
<body>
<div class="content" >
    <center><h3>修改联系人</h3></center>
    <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" value="${user.name}" name= "name"  readonly="readonly" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label for="name">性别：</label>
            <c:if test="${user.sex} == '男'">
                <input type="radio" name="sex" value="男" checked="checked"/>男
                <input type="radio" name="sex" value="女" />女
            </c:if>
            <c:if test="${user.sex} == '女'">
                <input type="radio" name="sex" value="男" />男
                <input type="radio" name="sex" value="女" checked="checked"/>女
                <input type="hidden" name="id" value="${user.id}"/>
            </c:if>

        </div>

        <div class="form-group">
            <label for="name">年龄：</label>
            <input type="text" class="form-control" id="age" value ="${user.age}" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="name">籍贯：</label>
            <select name="birth" class="form-control" id="address">
                <c:if test="${user.birth} == '山西' ">
                    <option value="山西" selected >山西</option>
                </c:if>
                <c:if test="${user.birth} == '陕西' ">
                    <option value="陕西" selected >陕西</option>
                </c:if>
                <c:if test="${user.birth} == '新疆' ">
                    <option value="新疆" selected >新疆</option>
                </c:if>
                <c:if test="${user.birth} == '湖南' ">
                     <option value="湖南" selected >湖南</option>
                </c:if>
                <c:if test="${user.birth} == '河北' ">
                    <option value="河北" selected >河北</option>
                </c:if>
                <c:if test="${user.birth} == '广东' ">
                   <option value="广东" selected >广东</option>
                 </c:if>
                <c:if test="${user.birth} == '安徽' ">
                    <option value="安徽" selected >安徽</option>
                </c:if>
            </select>
        </div>
        <div class="form-group">
            <label for="name">qq：</label>
            <input type="text" class="form-control" id="qq" value= "${user.qq}" name="qq" placeholder="请输入qq号码">
        </div>
        <div class="form-group">
            <label for="name">mail：</label>
            <input type="text" class="form-control" id="mail" value= "${user.mail}" name="mail" placeholder="请输入mail">
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
