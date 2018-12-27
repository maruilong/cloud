<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>聊天室</title>
</head>
<body onload="disconnect()">
<div>
    <div>
        <button id="connect" onclick="connect();">连接</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">断开连接</button>
    </div>
    <div id="conversationDiv">
        <label>输入内容</label><input type="text" id="name"/>
        <button id="sendName" onclick="sendName();">发送</button>
        <p id="response"></p>
    </div>
</div>
<script src="/websocket/jquery.js"></script>
<!-- stomp协议的客户端脚本 -->
<script src="/websocket/stomp.js"></script>
<!-- SockJS的客户端脚本 -->
<script src="/websocket/sockjs.js"></script>
<script type="text/javascript">
    var stompClient = null;

    function setConnected(connected) {
        document.getElementById('connect').disabled = connected;
        document.getElementById('disconnect').disabled = !connected;
        document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
        $('#response').html();
    }

    function connect() {
        // websocket的连接地址，此值等于WebSocketMessageBrokerConfigurer中registry.addEndpoint("/websocket-simple").withSockJS()配置的地址
        var socket = new SockJS('/websocket-rabbitmq');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/notice', function (respnose) { //2
                showResponse(JSON.parse(respnose.body).message);
            });
        }
        stompClient.connect({}, function (frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe("/user" + 1 + "/topic/private", function (respnose) {
                    showResponse(JSON.parse(respnose.body).message);
                });

            }
        );
    }


    function disconnect() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        setConnected(false);
        console.log("Disconnected");
    }

    function sendName() {
        var name = $('#name').val();
        // 客户端消息发送的目的：服务端使用BroadcastCtl中@MessageMapping("/receive")注解的方法来处理发送过来的消息
        // stompClient.send("/receive-single", {}, JSON.stringify({'name': name}));
        stompClient.send("/notice", {}, JSON.stringify({'message': name}));
    }

    function showResponse(message) {
        console.log(message + "==================")
        var response = $("#response");
        response.html(message + "\r\n" + response.html());
    }
</script>
</body>

</html>
