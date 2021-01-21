<%@ page import="cn.qkm.EL.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: qikaimeng
  Date: 2021/1/17
  Time: 下午7:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>EL</title>
  </head>
  <body>
  <%
    User user = new User();
    user.setAge(18);
    user.setName("戚凯萌");
    User user1 = new User();
    user1.setAge(19);
    user1.setName("sc");
    User user2 = new User();
    user2.setAge(20);
    user2.setName("yq");
    ArrayList<User> users = new ArrayList<>();
    users.add(user);
    users.add(user1);
    users.add(user2);
    request.setAttribute("user",users);


  %>

  <form action = "/WebServlet15_war_exploded/ServletCharacterText" method = "post" >
      用户名：<input type = "text"  name = "User"/> <br>
      <input type = "submit" value = "提交" name = "upload">

  <%--jstl标签写java代码--%>
  <%--if语句--%>
   <c:if test="${9 == 8}">
     正确</c:if>
  <%--switch-case--%>
  <c:choose>
    <c:when test="${7 == 0}">正确</c:when>  <%--case--%>
    <c:otherwise>错误</c:otherwise>  <%--deafult--%>
  </c:choose>

  <%--for循环和table--%>
  <table border="1" width="500" align="center">
    <tr>
      <th>编号</th>
      <th>姓名</th>
      <th>年龄</th>
    </tr>
    <c:forEach items="${user}" var="user" varStatus="u">
      <c:if test="${user.age % 2 == 0}">
        <tr bgcolor="#ffebcd">
          <td>${u.index}</td>
          <td>${user.name}</td>
          <td>${user.age}</td>
        </tr>
      </c:if>

      <c:if test="${user.age % 2 != 0}">
        <tr bgcolor="aqua">
          <td>${u.index}</td>
          <td>${user.name}</td>
          <td>${user.age}</td>
        </tr>
      </c:if>
    </c:forEach>
  </table>

  <c:forEach begin = "1" end="10" var="i" step = "1">
     ${i}
  </c:forEach>
  </body>
</html>
