// JavaScript source code
$(function () {
    document.title = "vriskospiti.gr";
    $('head').append('<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">');
    $('head').append('<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script >');
    $('head').append('<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>');
    $('link[href="/menus/faqpage.css"]').prop('disabled', true);
    $("#webpage").load("carousel.html");
});
