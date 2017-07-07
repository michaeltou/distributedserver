$(function () {

    $("#Save").click(function () {
        $.ajax({
            url: "",
            type: "POST",
            data:"",
            contentType: "application/json; charset=utf-8",
            success: function (data, textStatus) {
                if (data.success) {

                }
                else {

                }
            }
        });
        window.location.href = "StudentLeaveList.html";
    });

    $("#Cancel").click(function () {
        window.location.href = "StudentLeaveList.html";
    });

    $("#leaveModeText").selectedIndex = 0;
    $(".classList").empty();

    $("#leaveModeText").change(function () {
        var selectedItem = $(this).find("option:selected").html();
        if (selectedItem == "按天") {
            $(".classList").empty();
        }
        else if (selectedItem == "按班级") {
            for (var i = 0; i < 10; i++) {
                $div = $('<div class="classTimeDiv"></div>');
                $chk = $('<input value="" name="classTimes" type="checkbox" class="classTimes">');
                $chk.attr("value", "2017-07-07 10:00-12:00");
                $lbl = $('<label></label>');
                $lbl.html("2017-07-07 10:00-12:00");
                $div.append($chk);
                $div.append($lbl);
                $(".classList").append($div);
            }
            $.ajax({
                url: "",
                type: "POST",
                data: JSON.stringify({id: courseID, kc_category_name: courseName, institution_code: institution_code}),
                contentType: "application/json; charset=utf-8",
                success: function (data, textStatus) {
                    if (data.success) {


                    }
                    else {

                    }
                }
            });

        }
    });
});





