var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").value = "";
    }
    $("#chatRoomMessages").html("");
}

function connect() {
    var socket = new SockJS('http://localhost:8080/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        displayOldMessages();
        stompClient.subscribe('/topic/chatroom/' + $("#chatRoomId").val(), function (chatmessageresponse) {
            appendMessage(JSON.parse(chatmessageresponse.body).content);
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/api/chatroomapi/" + $("#chatRoomId").val(), {}, JSON.stringify(
    {
        'message': $("#message").val(),
        'userNameOfSender': $("#userName").val(),
    }
    ));
}

function appendMessage(message) {
    $("#chatRoomMessages").append("<tr><td>" + message + "</td></tr>");
    document.getElementById("message").value = "";
}

function displayOldMessages() {
    $.get("http://localhost:8080/api/chatrooms/" + $("#chatRoomId").val() + "/messages", function(data, status){
        for(var i = 0; i < data.length; i++) {
            appendMessage(data[i].userNameOfSender + ": " + data[i].message);
        }
    });
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});