$(function () {
    //

    $("#authorifyselect").treeMultiselect({searchable: true, hideSidePanel: true, freeze: false, collapsible: true,});
    $(".search").attr("placeholder", "请输入班级名称或者学员名称")

    $(".sendToAll").click(function () {
        var html = $("#authorifyselect").prop("outerHTML")
        $("#authorityBody").empty().append(html);
        if ($(this).is(':checked')) {
            $("#authorifyselect").treeMultiselect({
                searchable: true,
                hideSidePanel: true,
                freeze: true,
                collapsible: true,
            });

            var $div = $('<div class="sendObjectDiv"></div>');
            var $lbl = $("<label></label>");
            $lbl.html("全员送信");
            var $span = $('<span class="deleteButton icon iconfont icon-close"></span>')
            $div.append($lbl);
            $div.append($span);
            $(".sendObjectsDiv").empty();
            $(".sendObjectsDiv").append($div);
        } else {
            $("#authorifyselect").treeMultiselect({
                searchable: true,
                hideSidePanel: true,
                freeze: false,
                collapsible: true,
            });

            $(".sendObjectsDiv").empty();
        }
        $(".search").attr("placeholder", "请输入班级名称或者学员名称")
    });

    $("#authorityBody").on("click", ".option", function () {
        var studentName = $(this).siblings().html();
        if ($(this).is(":checked")) {
            <!-- 加载方法1 -->
            var $div = $('<div class="sendObjectDiv"></div>');
            var $lbl = $("<label></label>");
            $lbl.html(studentName);
            var $span = $('<span class="deleteButton icon iconfont icon-close"></span>')
            $div.append($lbl);
            $div.append($span);
            $(".sendObjectsDiv").append($div);


            <!-- 加载方法2 -->
            /* var html = '<div class="sendObjectDiv">' +
             '<label>'+
             $lbl.html()+
             '</label>'+
             '<span class="deleteButton icon iconfont icon-close"></span>' +
             '</div>'
             $(".sendObjectsDiv").html($(".sendObjectsDiv").html() + html);*/
        } else {
            var items = $(".sendObjectsDiv").children();
            for (var i = 0; i < items.length; i++) {
                if (items.eq(i).find("label").html() == studentName) {
                    items.eq(i).remove();
                    break;
                }
            }
        }
    });

    $("#authorityBody").on("click", ".title .section", function () {

        if ($(this).is(":checked")) {
            for (var i = 0; i < $(this).parents(".section").find(".item").length; i++) {
                var studentName = $(this).parents(".section").find(".item").eq(i).children("label").html();
                var items = $(".sendObjectsDiv").children();
                var bExist = false;
                for (var j = 0; j < items.length; j++) {
                    if (items.eq(j).find("label").html() == studentName) {
                        bExist = true;
                        break;
                    }
                }
                if(!bExist){
                    <!-- 加载方法1 -->
                    var $div = $('<div class="sendObjectDiv"></div>');
                    var $lbl = $("<label></label>");
                    $lbl.html(studentName);
                    var $span = $('<span class="deleteButton icon iconfont icon-close"></span>')
                    $div.append($lbl);
                    $div.append($span);
                    $(".sendObjectsDiv").append($div);
                }

            }
        }else {
            for (var i = 0; i < $(this).parents(".section").find(".item").length; i++) {
                var items = $(".sendObjectsDiv").children();
                var studentName = $(this).parents(".section").find(".item").eq(i).children("label").html();
                for (var j = 0; j < items.length; j++) {
                    if (items.eq(j).find("label").html() == studentName) {
                        items.eq(j).remove();
                        break;
                    }
                }
            }
        }
    });

    $(".sendObjectsDiv").on("click", ".deleteButton", function () {
        var studentName = $(this).siblings().html();
        var items = $("#authorityBody .section .item");
        for(var i = 0;i< items.length;i++){
            if(items.eq(i).find("label").html() == studentName){
                items.eq(i).find(".option").click();
            }
        }
        $(this).parent().remove();

    });
});

function onCancelClick() {
    window.location.href = "MessageNoticeList.html";
}
function onSendlClick() {
    window.location.href = "MessageNoticeList.html";
}
