$(function () {
    var socket = null;


    $("#showcards").on("click", function () {
        socket = new WebSocket("ws://localhost:8080/UnoGameTeam3/distributecards/" + $("#gamekey").val());
        document.getElementById("showcards").disabled = true;
        socket.onopen = function () {
            var msg = {
                room: $("#gamekey").val(),
                playerid: $("#userkey").val(),
                cmd: "setusername"
            }
            socket.send(JSON.stringify(msg));
        }

        socket.onmessage = function (evt) {

            var msg = JSON.parse(evt.data);
            var cmd = msg.cmd;

            switch (cmd)
            {
                case "logmeout" :
                    window.location.assign("http://localhost:8080/UnoGameTeam3/unohomepage.jsp");
                    break;
                case "takebackcard":
                    var newImg = document.createElement("img");
                    newImg.src = msg.link;

                    $(this).remove("pile");
                    document.getElementById("mycards").appendChild(newImg);
                    break;
                case "takeacard":
                    var newImg = document.createElement("img");
                    newImg.src = msg.link;

                    document.getElementById("mycards").appendChild(newImg);
                    break;
                case "sevencards":
                    var newImg = document.createElement("img");
                    newImg.src = msg.link;
                    $("#mycards").on("click", "img", function () {

                        var ImageSource = $(this).attr('src');
                        var msg1 = {
                            room: $("#gamekey").val(),
                            playerid: $("#userkey").val(),
                            cmd: "throwCard",
                            cardThrown: ImageSource
                        }
                        socket.send(JSON.stringify(msg1));

                        $(this).remove();
                    });

                    document.getElementById("mycards").appendChild(newImg);
                    break;
                case "topcard":
                    document.getElementById("pile").src = msg.link;
                    break;
                case "PlayerScore":
                    document.getElementById("score").innerHTML = msg.link;
            }
        }

    });
    $("img").on({
        'click': function () {
            var src = ($(this).attr('src'));
            if (src === "Images/back.png")
            {

                var msg = {
                    room: $("#gamekey").val(),
                    playerid: $("#userkey").val(),
                    cmd: "takeacard"

                }
                socket.send(JSON.stringify(msg));
            }
        }
    });
    $("#pile").on({
        'click': function () {
            var msg = {
                room: $("#gamekey").val(),
                playerid: $("#userkey").val(),
                cmd: "takebackcard"
            }
            socket.send(JSON.stringify(msg));


        }
    }
    );
    $("#logout").on("click", function () {


        var msg = {
            room: $("#gamekey").val(),
            playerid: $("#userkey").val(),
            cmd: "logout"
        }
        socket.send(JSON.stringify(msg));
    })



})




