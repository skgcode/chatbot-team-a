$(document).ready(function sendRequest() {
    $.ajax({
        url: "/rea/building/query/regionAndBuildingTypeAndTransactionTypeAndPriceRange",
        data: {"region":region,
            "buildingType":buildingType,
            "transactionType": transactionType,
            "priceMin":priceMin,
            "priceMax":priceMax}
    }).then(function getData(data) {
        if(data.length===0){
            var block0= document.createElement("div");
            block0.append("No property was found based on your criteria");
            block0.style.cssText="vertical-align: top;padding-left: 5%;padding-top:3%;font-size:18px;border:none;"
            $('.coveo-results-column').append(block0);
        }
        $.each(data, function (key, entry) {
            var block0 = document.createElement("div");
            block0.className="coveo-list-layout"
            block0.className="CoveoResult";
            var block5 = document.createElement("div");
            block5.className="coveo-result-frame";
            var block = document.createElement("div");
            block.className="coveo-result-cell";
            block.style.cssText="vertical-align: top;text-align:center;width:32px;border:none";
            var block1 =document.createElement("div");
            block1.className="coveo-result-row";
            block.style.cssText="vertical-align: top;padding-left: 16px;border:none;";
            var block2 = document.createElement("div");
            block2.className="coveo-result-row";
            block2.style.cssText="margin-top:0;border:none";
            var block3 = document.createElement("div");
            block3.className="coveo-result-cell";
            block3.style.cssText="vertical-align:top;font-size:16px;border:none";
            var block4 = document.createElement("pre");
            block4.append(entry.type.name+" "+ entry.id);
            var price = document.createElement("pre");
            price.append(entry.price+ "€");
            price.style.cssText="text-align:right;margin-right:3%;border:none";
            block4.append(price);
            block4.style.cssText = "margin-left:2%;border:none";
            var description = document.createElement("div");
            description.className="coveo-result-row";
            description.style.css="margin-top:10px;border:none";
            var description1 = document.createElement("div");
            description1.className="coveo-result-cell";
            var description2 = document.createElement("span");
            description2.append("Region: "+entry.region.name +"\n"+ " Available to: "+ entry.transactionType.name+"\n"+ " Area: "+ entry.squareMeters + "\n"+ " Built in: "+ entry.year +"\n"+" Floor: "+entry.floor+ "\n"+ " Heating: " + entry.heating);
            var hr = document.createElement("hr");
            description2.append(hr);
            description1.append(description2);
            description.append(description1);
            block4.append(description);
            block3.append(block4);
            block2.append(block3);
            block1.append(block2);
            block.append(block1);
            block5.append(block);
            block0.append(block5);
            $('.coveo-results-column').append(block5);
        })
    });
});