$(function () {

    $('#newClassroom').click(function () {
        $('.addClassroom').dialog("option", "title", "新建教室").dialog('open');
    });


    $("body").on('click', ".deleteButton", function () {

        if (window.confirm('你确定要删除吗？')) {
            //alert("确定");
            DeleteData($(this).get(0));
            return true;
        } else {
            //alert("取消");
            return false;
        }
    });


    $('.addClassroom').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 500,
        height: 200,
        title: '新建教室',
        buttons: {
            '保存': function () {
                if ($("#schoolDistrictName option:selected").val() == "") {
                    alert("请选择校区。");
                    $("#schoolDistrictName").focus();
                    return;
                } else if ($("#classRoomNameText").val() == "") {
                    alert("教室名称不能为空。");
                    $("#classRoomNameText").focus();
                    return;
                }
                //$(this).submit();
                $(this).dialog('close');
                $.ajax({
                    url: "",
                    type: "POST",
                    data: "",
                    contentType: "application/json; charset=utf-8",
                    success: function (data, textStatus) {
                        if (data.success) {
                            alert("教室更新成功");
                            window.location.href = "";
                        }
                        else {
                            window.alert("教室更新成功");
                        }
                    }
                });
            },
            '取消': function () {
                $(this).dialog('close');
            }
        },
    });


    $("#search").click(function () {

        var institution_code = "tm";
        var classroomName = $("#classRoomNameTextForSearch").val();
        $.ajax({
            url: "",
            type: "POST",
            data: "",
            contentType: "application/json; charset=utf-8",

            success: function (data, textStatus) {


                if (data.success) {
                    // alert(JSON.stringify(data)); 调试使用，请勿删除

                    //清空当前表格
                    document.getElementById("data_body").innerHTML = '';

                    //动态构建表格数据.
                    /*$.each(data.data, function (id, keChengCategory) {
                        var $tr = $("<tr ></tr>");
                        var $td1 = $("<td ></td>");
                        var $td2 = $("<td style='text-align: center;' ></td>");
                        var $td3 = $("<td style='text-align: center;'>  <button class='deleteButton icon iconfont icon-delete'>删除</button> </td>");
                        $tr.append($td1.clone().text(keChengCategory.id));
                        $tr.append($td2.clone().text(keChengCategory.kc_category_name));
                        $tr.append($td3.clone());
                        $tr.appendTo($("#data_body"));
                    });*/

                }
                else {
                    window.alert("教室取得成功");
                }
            }
        });
    });
});


function DeleteData(delRow) {
    //var table = delRow.parentNode.parentNode.parentNode;
    //table.removeChild(delRow.parentNode.parentNode);
    var tr = delRow.parentNode.parentNode;
    /*var courseID = (tr.cells[0]).innerText;
    var courseName = (tr.cells[1]).innerText;*/
    var institution_code = "tm";//(tr.cells[0]).innerText;
    $.ajax({
        url: "",
        type: "POST",
        data: "",
        contentType: "application/json; charset=utf-8",
        success: function (data, textStatus) {
            if (data.success) {
                alert("教室删除成功");
                window.location.href = "";
            }
            else {
                window.alert("教室删除失败");
            }
        }
    });
}

function byId(id) {
    return document.getElementById(id);
}

function load() {

}    