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
    <script>

        window.onload=function (){
            document.getElementById("delSelected").onclick=function (){
               if(confirm("您确定要删除吗?")){
                   document.getElementById("form").submit();
               }

            }
            document.getElementById("firstCb").onclick=function (){
                const cbs = document.getElementsByName("uid");
                for(let i=0; i < cbs.length; i++){
                    cbs[i].checked= this.checked;
                }
            }
        }
    </script>
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
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/Case/addUser.jsp">添加联系人</a>
    <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
</div>
<div >
    <form id="form" action="${pageContext.request.contextPath}/deleteUsersServlet" method="post">
        <table align="center" border="2">
            <tr bgcolor="#8fbc8f">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>籍贯</th>
                <th>qq</th>
                <th>mail</th>
                <th>操作</th>
            </tr>
            <c1:forEach varStatus="s" var="user" items="${userByPage.list}">
                <tr>
                    <th><input type="checkbox" name="uid" value="${user.id}"></th>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.sex}</td>
                    <td>${user.birth}</td>
                    <td>${user.qq}</td>
                    <td>${user.mail}</td>
                    <td>&nbsp;<a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/deleteUserServlet?id=${user.id}">删除</a></td>
                        <%--href="javascript:deleteUser(${user.id});--%>
                </tr>
            </c1:forEach>
        </table>
    </form>
    <div>

        <nav aria-label="Page navigation">
            <ul class="pagination">
                       <a href="${pageContext.request.contextPath}/pageServlet?currentPage=${userByPage.currentPage-1}&rows=3" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                <c1:forEach begin="1" end="${userByPage.pages}" var="i">
                    <a href="${pageContext.request.contextPath}/pageServlet?currentPage=${i}&rows=3">${i}</a>
                </c1:forEach>
                    <a href="${pageContext.request.contextPath}/pageServlet?currentPage=${userByPage.currentPage+1}&rows=3" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                <span style="font-size: 15px;margin-left: 5px;">
                    共${userByPage.total}条数据,共${userByPage.pages}页
                </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
