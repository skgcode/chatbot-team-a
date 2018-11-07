$(document).ready(function () {
    $.ajax({
        url: "localhost:8080"
    }).then(function (data) {
        $.each(data, function (key, entry) {
            $(."#results").append("<a href" class=\"btn btn-primary\">" + .append(data.name) + "</button>");
        })
    });
});