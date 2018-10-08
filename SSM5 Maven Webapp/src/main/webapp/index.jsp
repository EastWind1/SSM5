<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>登录</title>
    <script type="text/javascript">
        var websocket = null;
        //判断当前浏览器是否支持WebSocket
        if ('WebSocket' in window) {
            websocket = new WebSocket("ws://localhost:8080/SSM5/websocket");
        }
        else {
            alert('当前浏览器 Not support websocket')
        }

        //连接发生错误的回调方法
        websocket.onerror = function () {
            setMessageInnerHTML("WebSocket连接发生错误");
        };

        //连接成功建立的回调方法
        websocket.onopen = function () {
            setMessageInnerHTML("WebSocket连接成功");
        }

        //接收到消息的回调方法
        websocket.onmessage = function (event) {
            setMessageInnerHTML(event.data);
        }

        //连接关闭的回调方法
        websocket.onclose = function () {
            setMessageInnerHTML("WebSocket连接关闭");
        }

        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function () {
            closeWebSocket();
        }

        //将消息显示在网页上
        function setMessageInnerHTML(innerHTML) {
            document.getElementById('message').innerHTML += innerHTML + '<br/>';
        }

        //关闭WebSocket连接
        function closeWebSocket() {
            websocket.close();
        }

        //发送消息
        function send() {
            var message = document.getElementById('text').value;
            websocket.send(message);
        }
    </script>
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

Welcome<br/><input id="text" type="text"/>
    <button onclick="send()">发送消息</button>
     <hr/>
    <button onclick="closeWebSocket()">关闭WebSocket连接</button>
    <hr/>
    <div id="message"></div>
</body>
</html>
