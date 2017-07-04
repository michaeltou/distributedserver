$(function () {

    var totalAmount = 0;
    for(var i = 0; i< $("tbody tr").length;i++){

        var price =  $("tbody tr").eq(i).children().eq(4).html();
        price = parseInt(price);
        if (isNaN(price)){
            price = 0;
        }
        totalAmount += price;
    }
    totalAmount += "元";
    $("#teachingMaterialTotalAmount").text(totalAmount);

});

