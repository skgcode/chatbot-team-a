var $messages = $('.messages-content'),
    d, h, m,
    i = 0;

// accessToken του botακιου
var accessToken = "0285176607954548808307bde116bf9e";

//url του dialogflow api
var baseUrl = "https://api.dialogflow.com/v1/";

//φορτωση 1ου μηνυματος (δεν δουλευει)
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
        },
        error: function () {
            return false;
        }
    });
    $('<div class="message loading new"><figure class="avatar"><img src="https://us.123rf.com/450wm/goodzone95/goodzone951803/goodzone95180300023/96668201-chatbot-icon-cute-robot-working-behind-laptop-modern-bot-sign-design-smiling-customer-service-robot-.jpg?ver=6" /></figure><span></span></div>').appendTo($('.mCSB_container'));
    updateScrollbar();

    setTimeout(function () {
        $('.message.loading').remove();
		//put bot's answer in window
        if (msg.match(/.*result.*/gi)) {
            $('<div class="message new"><figure class="avatar"><img src="https://us.123rf.com/450wm/goodzone95/goodzone951803/goodzone95180300023/96668201-chatbot-icon-cute-robot-working-behind-laptop-modern-bot-sign-design-smiling-customer-service-robot-.jpg?ver=6" /></figure>' + '<a href="resultpage.html" style="color: white;">' + respText + '</a> ' + '</div>').appendTo($('.mCSB_container')).addClass('new');

        } else {
            $('<div class="message new"><figure class="avatar"><img src="https://us.123rf.com/450wm/goodzone95/goodzone951803/goodzone95180300023/96668201-chatbot-icon-cute-robot-working-behind-laptop-modern-bot-sign-design-smiling-customer-service-robot-.jpg?ver=6" /></figure>' + respText + '</div>').appendTo($('.mCSB_container')).addClass('new');

        }
        setDate();
        updateScrollbar();
        //i++;
    }, 1000 + (Math.random() * 20) * 100);

}