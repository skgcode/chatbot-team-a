$(document).ready(function() {
    $.ajax({
    url: "/getAllHouses"
 }).then(function(data) {
    $.each(data, function (key, entry) {
        var block = document.createElement("div");
        block.append(entry.type.name);
        block.append(entry.price);
        $('#results').append(block);
    })
 });
 });