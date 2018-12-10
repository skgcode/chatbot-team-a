function sendRequest(parameters) {

    $("#webpage").empty();
    $('link[href="resultpage.css"]').prop('disabled', false);
    $("#webpage").load("chatResultPage.html");

    $(document).ready(function () {
        $.ajax({
            url: "/rea/building/query/regionAndBuildingTypeAndTransactionTypeAndPriceRange",
            data: {
                "region": parameters.Region[0].toLowerCase(),
                "buildingType": parameters.Types[0],
                "transactionType": parameters.desire,
                "priceMin": 0,
                "priceMax": 999999
            }
        }).then(function getData(data) {
        if (data.length === 0) {
            var block0 = document.createElement("div");
            block0.append("No property was found based on your criteria");
            block0.style.cssText = "vertical-align: top;padding-left: 5%;padding-top:3%;font-size:18px;border:none;font-weight:bold;";
            var image = document.createElement("img");
            image.src="https://media1.tenor.com/images/a828888852e708d9afaaad06c7f9513f/tenor.gif?itemid=10251428";
            image.alt="Results not found";
            image.style.cssText="position:center; width:50%; height:10%;margin-top:3em;"
            $('.coveo-results-column').append(block0);
            $('.coveo-results-column').append(image);
        }
        $.each(data, function (key, entry) {
            var layout = document.createElement("div");
            layout.className = "coveo-list-layout";
            layout.className = "CoveoResult";
            layout.style.cssText = "vertical-align: middle;color: black;background-color: #f4f4f4;border: none;border-radius: 20px;";
            var frame = document.createElement("div");
            frame.className = "coveo-result-frame";
            var resultRow = document.createElement("div");
            resultRow.className = "coveo-result-row";
            var imgCell = document.createElement("div");
            imgCell.className = "coveo-result-row";
            imgCell.style.cssText = "margin-bottom: 50px;margin-top: -95px;";
            var spanClass = document.createElement("span");
            spanClass.className = "CoveoYouTubeThumbnail";
            var imgcontainer = document.createElement("div");
            imgcontainer.className = "coveo-youtube-thumbnail-container";
            var image = document.createElement("img");
            image.src = entry.photo.path;
            image.alt = entry.type.name + " " + entry.id;
            image.style.cssText = "width: 150px; margin-left: 30px; border-radius: 10px;";
            imgcontainer.append(image);
            spanClass.append(imgcontainer);
            imgCell.append(spanClass);
            imgCell.style.cssText = "margin-bottom: 50px;margin-top: -95px;";
            //imgCell.style.cssText="display: table;table-layout: fixed;margin: 0.25em 0;margin-left: 200px;";
            var propertyCell = document.createElement("div");
            propertyCell.className = "coveo-result-cell";
            var titleRow = document.createElement("div");
            titleRow.className = "coveo-result-row";
            var titleCell = document.createElement("div");
            titleCell.className = "coveo-result-cell";
            var title = document.createElement("pre");
            title.append(entry.type.name + " " + entry.id);
            title.style.cssText = "border:none!important;margin-left: -230%;";
            titleCell.append(title);
            titleRow.append(titleCell);
            var priceCell = document.createElement("div");
            priceCell.className = "coveo-result-cell";
            priceCell.style.cssText = "text-align: right;width: 100%;font-size: 12px;margin-left: 50%!important;";
            var pricePre = document.createElement("pre");
            pricePre.className = "CoveoFieldValue";
            pricePre.append(entry.price + "€");
            pricePre.style.cssText = "border: none;text-align: right !important;margin-left: 79% !important;width:30%";
            priceCell.append(pricePre);
            titleRow.append(priceCell);
            titleRow.style.cssText = "text-align: left;width: 100%;font-size: 12px;display: table-cell;border: none !important;margin-left: -20%!important";
            propertyCell.append(titleRow);
            titleCell.style.cssText = "display: table; table-layout: fixed; margin: 0.25em 0px 0.25em 200px;";
            var descriptionRow = document.createElement("div");
            descriptionRow.className = "coveo-result-row";
            descriptionRow.style.cssText = "display: table-row;margin-left: 220px;width: 100%;";
            var descriptionCell = document.createElement("div");
            descriptionCell.className = "coveo-result-cell";
            var descriptionSpanClass = document.createElement("span");
            var text = "Region: " + entry.region.name + "\n" + " Available to: " + entry.transactionType.name + "\n" + " Area: " + entry.squareMeters + "\n" + " Built in: " + entry.year + "\n" + " Floor: " + entry.floor + "\n" + " Heating: " + entry.heating;
            descriptionSpanClass.append(text);
            descriptionCell.append(descriptionSpanClass);
            descriptionRow.append(descriptionCell);
            descriptionRow.style.cssText = "display:table-row;margin-left:220px;";
            propertyCell.append(descriptionRow);
            propertyCell.style.cssText = "margin-left:200%;";
            resultRow.append(propertyCell);
            resultRow.append(imgCell);
            resultRow.style.cssText = "width: 100px; display: table; table-layout: fixed; margin: 0.25em 0px;";
            frame.append(resultRow);
            frame.style.cssText = "margin-left: 0px;display: block;width: 100%;height: 100%;";
            layout.append(frame);
            layout.style.cssText = "color: black;background-color: rgb(244, 244, 244);border: none;border-radius: 20px;width:53%;";
            $('.coveo-results-column').append(layout);
        })
    });
})};