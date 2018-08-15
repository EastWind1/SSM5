<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<html>
<head>
<title>登录</title>
</head>
<body>
<h2>Hello World!</h2>

<form action="user/login" method="post">  
    username:<input type="text" name="username">  
    <br/>  
    password:<input type="password" name="password">
 	<br/>
    <input type="submit" value="登录"> 
    <script>
    function onClick(){
    	window.location.href="zhuce.jsp";
    }
    </script>
    <input type="button" value="注册" onclick="onClick()">
    </form>

</body>
</html>
