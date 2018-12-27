var stompClient = null;
var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

var currentUser = $("#current-user").text();

var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');

//连接
function connect() {
    var socket = new SockJS('/websocket-rabbitmq');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/user/topic/rabbitmq', function (data) {
            var message = JSON.parse(data.body);
            console.log("单聊");
            showMessage(message);
            data.ack();
        }, {ack: 'client', 'durable': true, 'auto-delete': false});
        //订阅群消息 后面的greeting 应该用群名代替
        stompClient.subscribe('/topic/rabbitmqs', function (data) {
            var message = JSON.parse(data.body);
            showMessage(message);
            data.ack();
        }, {ack: 'client', 'durable': true, 'auto-delete': false});

    });
}

//匹配 @用户 正则
var patt = /@(\S+)\s/;

function sendMessage(event) {
    var messageContent = messageInput.value;
    if (messageContent && stompClient) {
        var chatMessage = {
            sender: currentUser,
            content: messageContent,
            type: 'CHAT'
        };
        if (patt.test(messageContent)) {
            var user = patt.exec(messageContent);
            chatMessage.content = chatMessage.content.replace(patt, '');
            //发送给指定用户
            stompClient.send("/toUser", {'user': user[1]}, JSON.stringify(chatMessage));
            showMessage(chatMessage);
        } else {
            //群发
            stompClient.send("/toGroup", {'group': 'rabbitmqs'}, JSON.stringify(chatMessage));
        }
        messageInput.value = '';
    }
    event.preventDefault();
}

//将信息展示于页面
function showMessage(message) {
    var messageElement = document.createElement('li');

    if (message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' 加入！';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' 离开！';
    } else if (message.sender === currentUser) {
        messageElement.classList.add('chat-message-me');
        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(message.sender[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(message.sender);

        messageElement.appendChild(avatarElement);

        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    } else {
        messageElement.classList.add('chat-message');
        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(message.sender[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(message.sender);

        messageElement.appendChild(avatarElement);

        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    }

    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}

//随机给用户一个头像
function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }

    var index = Math.abs(hash % colors.length);
    return colors[index];
}

messageForm.addEventListener('submit', sendMessage, true);

//初始化 连接 websocket
$(function () {
    connect();
});
