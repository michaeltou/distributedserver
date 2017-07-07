$(function () {

    $("#NewLeave").click(function () {
        window.location.href = "AddStudentLeave.html";

    });

    $("body").on('click', ".deleteButton", function () {
        if (window.confirm('你确定要删除吗？')) {
            //alert("确定");
            DeleteData($(this).get(0));
            $.ajax({
                url: "XXXX",
                type: "POST",
                data: JSON.stringify({id: courseID, kc_category_name: courseName, institution_code: institution_code}),
                contentType: "application/json; charset=utf-8",
                success: function (data, textStatus) {
                    if (data.success) {
                        alert("通知删除成功");
                        window.location.href = "/px/serachKeChengCategory";
                    }
                    else {
                        window.alert("通知删除失败");
                    }
                }
            });
            return true;
        } else {
            //alert("取消");
            return false;
        }
    });
});

function DeleteData(delRow) {
    var table = delRow.parentNode.parentNode.parentNode;
    table.removeChild(delRow.parentNode.parentNode);

}


