<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <title>Chating</title>
    <style>
        *{
            margin:0;
            padding:0;
        }
        .container{
            width: 500px;
            margin: 0 auto;
            padding: 25px
        }
        .container h1{
            text-align: left;
            padding: 5px 5px 5px 15px;
            color: #FFBB00;
            border-left: 3px solid #FFBB00;
            margin-bottom: 20px;
        }
        .chating{
            background-color: #000;
            width: 500px;
            height: 500px;
            overflow: auto;
        }
        .chating p{
            color: #fff;
            text-align: left;
        }
        input{
            width: 330px;
            height: 25px;
        }

    </style>
</head>

<script type="text/javascript">
    var ws;
    var hurl = window.location.href;
    var url = new URL(hurl);
    var room = url.searchParams.get('room');

    wsOpen();

    function wsOpen(){

        ws = new WebSocket("ws://" + location.host + "/chating");
        wsEvt();
    }

    function wsEvt() {
        ws.onopen = function(data){
            //소켓이 열리면 초기화 세팅하기
            var uN = document.querySelector('#loginuser').dataset.nm;
            var sendData = {
                'msg': uN + '님이 접속하였습니다.',
                'uid': uN,
                'cmd': 'CMD_ENTER',
                'room': room
            }
            // var msg = $("#chatting").val();
            // ws.send(JSON.stringify(sendData));
            ws.send(JSON.stringify(sendData));
            $('#chatting').val("");
        }

        ws.onmessage = function(data) {
            var msg = data.data;
            if(msg != null && msg.trim() != ''){
                $("#chating").append("<p>" + msg + "</p>");
            }
        }

        document.onkeydown = function() {
            if (event.keyCode == 505) {
                ws.send("님이 종료하였습니다.");
                alert(document.body.onBeforeUnload);
            }
        }

        document.addEventListener("keypress", function(e){
            if(e.keyCode == 13){ //enter press
                send();
            }
        });
    }

    ws.onerror = (error) => {
        alert(error);
    }

    function noEvent() {
        if (event.keyCode == 116) {
            event.keyCode= 2;
            return false;
        }
        else if(event.ctrlKey && (event.keyCode==78 || event.keyCode == 82))
        {
            return false;
        }
    }
    document.onkeydown = noEvent;



    // window.addEventListener('beforeunload', ()=>{
    //     ws.close(()=>{
    //
    // });

    function send() {
        var uN = document.querySelector('#loginuser').dataset.nm;
        var msg = $("#chatting").val();
        var sendData = {
            'msg': msg,
            'uid': uN,
            'cmd': 'CMD_SEND_MSG',
            'room': room
        }
        ws.send(JSON.stringify(sendData));
        $('#chatting').val("");
    }


</script>
<body>
<div id="loginuser" data-nm="${sessionScope.loginUser.nm}"></div>
<div id="container" class="container">
    <h1>채팅</h1>
    <div id="chating" class="chating">
    </div>


    <div id="yourMsg">
        <table class="inputTable">
            <tr>
                <th>메시지</th>
                <th><input id="chatting" placeholder="보내실 메시지를 입력하세요."></th>
                <th><button onclick="send()" id="sendBtn">보내기</button></th>
            </tr>
        </table>
    </div>
</div>
</body>
</html>