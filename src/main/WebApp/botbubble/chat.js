var $messages = $('.messages-content'),
    d, h, m,
    i = 0;

// accessToken του botακιου
var accessToken = "85334df769aa486bbb24cecd4eac338a";

//url του dialogflow api
var baseUrl = "https://api.dialogflow.com/v1/";

var parameters = [];

// loading the first message
$(window).load(function () {
    $messages.mCustomScrollbar();
    setTimeout(function () {
        msg = "hi"
        fakeMessage();
    }, 100);
});

//scroll animation
function updateScrollbar() {
    $messages.mCustomScrollbar("update").mCustomScrollbar('scrollTo', 'bottom', {
        scrollInertia: 10,
        timeout: 0
    });
}

//datestamp
function setDate() {
    d = new Date()
    if (m != d.getMinutes()) {
        m = d.getMinutes();
        $('<div class="timestamp">' + d.getHours() + ':' + m + '</div>').appendTo($('.message:last'));
    }
}

//insert user's message
function insertMessage() {
    msg = $('.message-input').val();
    if ($.trim(msg) == '') {
        return false;
    }
    $('<div class="message message-personal">' + msg + '</div>').appendTo($('.mCSB_container')).addClass('new');
    setDate();
    $('.message-input').val(null);
    updateScrollbar();
    setTimeout(function () {
        fakeMessage();
    }, 1000 + (Math.random() * 20) * 100);
}

//onsubmit do
$('.message-submit').click(function () {
    insertMessage();
});

//when 'enter' keyispressed do
$(window).on('keydown', function (e) {
    if (e.which == 13) {
        insertMessage();
        return false;
    }
})

//bot answer
function fakeMessage() {
    if ($('.message-input').val() != '') {
        return false;
    }
    //http call to bot
    $.ajax({
        type: "POST",
        url: baseUrl + "query?v=20150910",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        headers: {
            "Authorization": "Bearer " + accessToken
        },
        data: JSON.stringify({query: msg, lang: "en", sessionId: "somerandomthing"}),
        success: function (data) {
            //take bot's answer in 'respText' variable
            respText = data.result.fulfillment.speech;
            contexts = data.result.contexts;
            for (i = 0; i < contexts.length; i++) {
                if (i === 0) {
                    parameters = contexts[i].parameters;
                }
            }
        },
        error: function () {
            return false;
        }
    });
    $('<div class="message loading new"><figure class="avatar"><img src="botbubble/rea.png" /></figure><span></span></div>').appendTo($('.mCSB_container'));
    updateScrollbar();

    setTimeout(function () {
        $('.message.loading').remove();
        //put bot's answer in window
        if (respText.match(/.*result.*/gi)) { // recognize the result word and it will be link
            var count = 0;
            var countRegion = parameters.Region.length;
            for (var item in parameters) {
                count++;
            }
            console.log(count);
            console.log(countRegion);
            if (count > 6) {
                if (countRegion > 1) {
                    $('<div class="message new"><figure class="avatar"><img src="botbubble/rea.png" /></figure>' + respText + '</div>').appendTo($('.mCSB_container')).addClass('new');
                    sendRequest(parameters);
                } else {
                    $('<div class="message new"><figure class="avatar"><img src="botbubble/rea.png" /></figure>' + respText + '</div>').appendTo($('.mCSB_container')).addClass('new');
                    sendRequestWithoutRegion2(parameters);
                }
            } else if (count <= 6) {
                if (countRegion === 2) {
                    $('<div class="message new"><figure class="avatar"><img src="botbubble/rea.png" /></figure>' + respText + '</div>').appendTo($('.mCSB_container')).addClass('new');
                    sendRequestWithoutKatigoria(parameters);
                } else {
                    $('<div class="message new"><figure class="avatar"><img src="botbubble/rea.png" /></figure>' + respText + '</div>').appendTo($('.mCSB_container')).addClass('new');
                    sendRequestWithoutKatigoriaAndRegion2(parameters);
                }
            }
        } else if (msg.match(/.*sell.*/gi)) { // recognize the sell word and it will be link
            $('<div class="message new"><figure class="avatar"><img src="botbubble/rea.png" /></figure>' + respText + '</div>').appendTo($('.mCSB_container')).addClass('new');
            $("#webpage").empty();
            $("#webpage").load("newform.html");
        } else { // any other word it will be bubble, not link
            $('<div class="message new"><figure class="avatar"><img src="botbubble/rea.png" /></figure>' + respText + '</div>').appendTo($('.mCSB_container')).addClass('new');

        }
        setDate();
        updateScrollbar();
        //i++;
    }, 1000 + (Math.random() * 20) * 100);
}