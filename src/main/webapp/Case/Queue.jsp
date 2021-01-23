<%--
  Created by IntelliJ IDEA.
  User: qikaimeng
  Date: 2021/1/23
  Time: 上午11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>展示</title></title>
    <style>
        table,td,th
        {
            border:1px solid black;
        }
        table
        {
            width:1160px;
        }
        th
        {
            height:50px;
        }
        tr{
            height:35px;
        }
    </style>
</head>

<body>
<div style="text-align: center">用户信息列表</div>
<div style="float:left;">
    <form class="form-inline">
            <label for="exampleInputName2">姓名</label>
            <input type="text" class="form-control" id="exampleInputName2" >
            <label for="exampleInputName3">籍贯</label>
            <input type="text" class="form-control" id="exampleInputName3" >

            <label for="exampleInputEmail2">邮箱</label>
            <input type="email" class="form-control" id="exampleInputEmail2" >
        <button type="submit" class="btn btn-default">查询信息</button>
    </form>
</div>
<div style="float:right; margin: 5px" >
    <button class="btn btn-primary" href="">添加联系人</button>
    <button class="btn btn-primary" href="">删除选中</button>
</div>
<div >
  <table align="center" border="2">
      <tr bgcolor="#8fbc8f">
          <th><input type="checkbox"></th>
          <th>编号</th>
          <th>姓名</th>
          <th>年龄</th>
          <th>性别</th>
          <th>籍贯</th>
          <th>qq</th>
          <th>mail</th>
      </tr>
      <c1:forEach varStatus="s" var="user" items="${user}">
          <tr>
              <th><input type="checkbox"></th>
              <td>${user.id}</td>
             <td>${user.name}</td>
             <td>${user.age}</td>
             <td>${user.sex}</td>
             <td>${user.birth}</td>
             <td>${user.qq}</td>
             <td>${user.mail}</td>
          </tr>
      </c1:forEach>
  </table>
    <div>

        <nav aria-label="Page navigation">
            <ul class="pagination">
                       <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                <a href="#">1</a>
               <a href="#">2</a>
               <a href="#">3</a>
                <a href="#">4</a>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                <span style="font-size: 15px;margin-left: 5px;">
                    共20条数据,共4页
                </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
