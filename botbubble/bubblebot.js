// Connection dialogflow bot with chat box 
var accessToken ="0285176607954548808307bde116bf9e";



    var baseUrl = "https://api.dialogflow.com/v1/";

    $(document).ready(function() {
        $.ajax({
            type: "POST",
            url: baseUrl + "query?v=20150910",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            headers: {
                "Authorization": "Bearer " + accessToken
            },
            data: JSON.stringify({ query: "howdy", lang: "en", sessionId: "somerandomthing" }),
            success: function(data) {
                var respText = data.result.fulfillment.speech;
                console.log("Respuesta: " + respText);
                setResponse(respText);
            },
            error: function() {
                setResponse("Internal Server Error");
            }
        });
    });

    $(document).ready(function() {
        $("#input").keypress(function(event) {
            if (event.which == 13) { // to 13 einai gia na leitourgei to enter otan to pataei o user
                event.preventDefault();
                send();
                this.value = '';
            }
        });
        $("#rec").click(function(event) {
            // switchRecognition();
            event.preventDefault();
            send();
            $("#input").value = '';
        });
    });
    var recognition;
    function startRecognition() {
        recognition = new webkitSpeechRecognition();
        recognition.onstart = function(event) {
            updateRec();
        };
        recognition.onresult = function(event) {
            var text = "";
            for (var i = event.resultIndex; i < event.results.length; ++i) {
                text += event.results[i][0].transcript;
            }
            setInput(text);
            stopRecognition();
        };
        recognition.onend = function() {
            stopRecognition();
        };
        recognition.lang = "en-US";
        recognition.start();
    }
    function stopRecognition() {
        if (recognition) {
            recognition.stop();
            recognition = null;
        }
        updateRec();
    }
    function switchRecognition() {
        if (recognition) {
            stopRecognition();
        } else {
            startRecognition();
        }
    }
    function setInput(text) {
        $("#input").val(text);
        send();
    }
    function updateRec() {
        $("#rec").text(recognition ? "Stop" : "Speak");
    }
function send() {
        var text = $("#input").val();
    conversation.push("Me: " + text + '\r\n');
        $.ajax({
            type: "POST",
            url: baseUrl + "query?v=20150910",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            headers: {
                "Authorization": "Bearer " + accessToken
            },
            data: JSON.stringify({ query: text, lang: "en", sessionId: "somerandomthing" }),
            success: function(data) {
                var respText = data.result.fulfillment.speech;
                console.log("Respuesta: " + respText);
                setResponse(respText);
               
            },
            error: function() {
                setResponse("Internal Server Error");
            }
        });
    }
    function setResponse(val) {
	    //Edit "AI: " to change name
        conversation.push("Rea: " + val + '\r\n');
        $("#response").text(conversation.join(""));
    }
	
	////////////////////////////////FUNCTION TO CHANGE BACKGROUND COLOR//////////////////////////////////////////////
	function setResponseC(val) {
	    //Edit "AI: " to change name
        $("#response").text(conversation.join("")); 
		document.body.style.backgroundColor = val;
		
    }

	
    var conversation = [];