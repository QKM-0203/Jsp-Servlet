
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>登录</title>
    <script type="text/javascript">
        //切换验证码
        function refreshCode(){
            var  code = document.getElementById("code");
            code.src = "${pageContext.request.contextPath}/CheckCode?time="+new Date().getTime();
        }
    </script>
</head>
</html>
<div>
<h1 style="text-align: center">登录界面</h1>
    <form action = "${pageContext.request.contextPath}/LoginServlet" method = "post" >

        <div style="text-align: center">用户名<br><input type = "text"  name = "User"/> </div>


        <div style="text-align: center">密码<br><input type ="password" name = "Password"><br></div>

        <div style="text-align: center"><br>请输入验证码：<input type ="text"  name = "checkBoard" style="width: 50px ;height: 25px">
          <a href="javascript:refreshCode();">
              <img src="${pageContext.request.contextPath}/CheckCode" title="看不清点击刷新" id="code"/>
          </a>
        </div>
        <br>
        <div style="text-align: center; "><input  style="text-align: center" type = "submit" value = "登录" name = "upload">
        </div>
    </form>
</div>

</body>
</html>