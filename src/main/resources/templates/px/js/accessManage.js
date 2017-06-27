$(function () {

    //自定义函数
    //=============================================
    $.extend({
        accessDataChanged: function () {
            var html = "";
            if ($("#accessRoleID").val() === "小张") {
                html += '<select id="authorifyselect" multiple="multiple">' +
                    '<option  value="monitor_index" data-section="学校管理" >校区管理</option>' +
                    '<option  value="manage_logs" data-section="学校管理" >课程管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" >班级管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" >教材管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" >排课管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" >员工管理</option>' +
                    '<option  value="interface_logs" data-section="学员管理" >学员管理</option>' +
                    '<option  value="interface_logs" data-section="学员管理" data-description="家长管理">家长管理</option>' +
                    '<<option  value="interface_logs" data-section="设置管理" >系统设置</option>' +
                    '<option  value="interface_logs" data-section="设置管理" >账户管理</option>' +
                    '<option  value="interface_logs" data-section="设置管理" >权限管理</option>' +
                    '<option  value="interface_logs" data-section="报表统计" >财务收支</option>' +
                    '<option  value="interface_logs" data-section="报表统计" >商品库存</option>' +
                    '<option  value="interface_logs" data-section="通知管理" >校内通知</option>' +
                    '</select>';
                $("#authorityBody").empty().append(html);
                $("#authorifyselect").treeMultiselect({
                    searchable: false,
                    hideSidePanel: false,
                    freeze: false,
                    collapsible: false,
                });
            }
            else if ($("#accessRoleID").val() === "小王") {
                html += '<select id="authorifyselect" multiple="multiple">' +
                    '<option  value="monitor_index" data-section="学校管理"  selected>校区管理</option>' +
                    '<option  value="manage_logs" data-section="学校管理" selected>课程管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" selected>班级管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" selected>教材管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" selected>排课管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" selected>员工管理</option>' +
                    '<option  value="interface_logs" data-section="学员管理" selected>学员管理</option>' +
                    '<option  value="interface_logs" data-section="学员管理" selected>家长管理</option>' +
                    '<<option  value="interface_logs" data-section="设置管理" selected>系统设置</option>' +
                    '<option  value="interface_logs" data-section="设置管理" selected>账户管理</option>' +
                    '<option  value="interface_logs" data-section="设置管理" selected>权限管理</option>' +
                    '<option  value="interface_logs" data-section="报表统计" selected>财务收支</option>' +
                    '<option  value="interface_logs" data-section="报表统计" selected>商品库存</option>' +
                    '<option  value="interface_logs" data-section="通知管理" selected>校内通知</option>' +
                    '</select>';
                $("#authorityBody").empty().append(html);
                $("#authorifyselect").treeMultiselect({
                    searchable: false,
                    hideSidePanel: false,
                    freeze: false,
                    collapsible: false,
                });
            } else if ($("#accessRoleID").val() === "小李") {
                html += '<select id="authorifyselect" multiple="multiple">' +
                    '<option  value="monitor_index" data-section="学校管理" >校区管理</option>' +
                    '<option  value="manage_logs" data-section="学校管理" selected>课程管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" selected>班级管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" >教材管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" selected>排课管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" selected>员工管理</option>' +
                    '<option  value="interface_logs" data-section="学员管理" selected>学员管理</option>' +
                    '<option  value="interface_logs" data-section="学员管理" selected>家长管理</option>' +
                    '<<option  value="interface_logs" data-section="设置管理" >系统设置</option>' +
                    '<option  value="interface_logs" data-section="设置管理" >账户管理</option>' +
                    '<option  value="interface_logs" data-section="设置管理" >权限管理</option>' +
                    '<option  value="interface_logs" data-section="报表统计" >财务收支</option>' +
                    '<option  value="interface_logs" data-section="报表统计" >商品库存</option>' +
                    '<option  value="interface_logs" data-section="通知管理" >校内通知</option>' +
                    '</select>';
                $("#authorityBody").empty().append(html);
                $("#authorifyselect").treeMultiselect({
                    searchable: false,
                    hideSidePanel: false,
                    freeze: false,
                    collapsible: false,
                });
            } else {
                html += '<select id="authorifyselect" multiple="multiple">' +
                    '<option  value="monitor_index" data-section="学校管理" >校区管理</option>' +
                    '<option  value="manage_logs" data-section="学校管理" >课程管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" >班级管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" >教材管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" >排课管理</option>' +
                    '<option  value="interface_logs" data-section="学校管理" >员工管理</option>' +
                    '<option  value="interface_logs" data-section="学员管理" >学员管理</option>' +
                    '<option  value="interface_logs" data-section="学员管理" data-description="家长管理">家长管理</option>' +
                    '<<option  value="interface_logs" data-section="设置管理" >系统设置</option>' +
                    '<option  value="interface_logs" data-section="设置管理" >账户管理</option>' +
                    '<option  value="interface_logs" data-section="设置管理" >权限管理</option>' +
                    '<option  value="interface_logs" data-section="报表统计" >财务收支</option>' +
                    '<option  value="interface_logs" data-section="报表统计" >商品库存</option>' +
                    '<option  value="interface_logs" data-section="通知管理" >校内通知</option>' +
                    '</select>';
                $("#authorityBody").empty().append(html);
                $("#authorifyselect").treeMultiselect({
                    searchable: false,
                    hideSidePanel: false,
                    freeze: false,
                    collapsible: false,
                });
            }
        }
    });

    $.extend({
        changeTableRowColor: function () {
            if ($lastSelectedCourse) {
                var trSeq = $lastSelectedCourse.parent().find("tr").index($lastSelectedCourse);
                if (trSeq % 2 == 0) {
                    $lastSelectedCourse.css("background-color", "white");
                } else {
                    $lastSelectedCourse.css("background-color", "white");
                }
            }
        }
    });

    //=============================================
    $("#authorifyselect").treeMultiselect({searchable: false, hideSidePanel: false, freeze: false, collapsible: false,});
    $("#accessRoleDelete").hide();

    //新建角色按钮
    $('#NewAccessRole').click(function () {
        $("#accessRoleID").val("");
        $("#accessRoleName").val("");
        $.accessDataChanged();
        $.changeTableRowColor();
        $("#NewAccessRole").attr("disabled", true);
        $("#accessRoleDelete").hide();
    });

    //删除按钮
    $("body").on('click', "#accessRoleDelete", function () {
        if (window.confirm('你确定要删除吗？')) {
            //alert("确定");
            if ($lastSelectedCourse) {
                $("#accessRoleID").val("");
                $("#accessRoleName").val("");
                $lastSelectedCourse.remove();
                $.accessDataChanged();
            }
            return true;
        } else {
            //alert("取消");
            return false;
        }
    });

    //取消按钮
    $('#accessRoleCancel').click(function () {
        $("#accessRoleID").val("");
        $("#accessRoleName").val("");
        $.accessDataChanged();
        $.changeTableRowColor();
        $("#NewAccessRole").attr("disabled", false);
        $("#accessRoleDelete").hide();
    });

    //保存按钮
    $('#accessRoleCancel').click(function () {

        if ($("#accessRoleID").val() === "") {
            //新建角色
        } else {
            //修正角色
        }
        $.ajax({
            type: "POST",
            url: "XXXXXX",
            data: "keyword=" + $("#keyword").val(),
            success: function (data) {

            }
        });
        $("#accessRoleID").val("");
        $("#accessRoleName").val("");
        $.accessDataChanged();
        $.changeTableRowColor();
        $("#NewAccessRole").attr("disabled", false);
        $("#accessRoleDelete").hide();
    });


    var $lastSelectedCourse;
    $(".recordList .yunmo tr").click(function () {
        $("#NewAccessRole").attr("disabled", false);
        $("#accessRoleDelete").show();

        $.changeTableRowColor();
        $(this).css("background-color", "#6FF");
        $("#accessRoleID").val($(this).children().eq(0).html());
        $("#accessRoleName").val($(this).children().eq(0).html());
        $.accessDataChanged();
        $lastSelectedCourse = $(this);
    });
});


function DeleteData(delRow) {
    var table = delRow.parentNode.parentNode.parentNode;
    table.removeChild(delRow.parentNode.parentNode);
}

function byId(id) {
    return document.getElementById(id);
}

function load() {

}    
