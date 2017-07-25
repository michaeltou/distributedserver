/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {

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

    /*$(".sendObjectsDiv").on("click", ".deleteButton", function () {
        var studentName = $(this).siblings().html();
        var items = $("#authorityBody .section .item");
        for(var i = 0;i< items.length;i++){
            if(items.eq(i).find("label").html() == studentName){
                items.eq(i).find(".option").click();
            }
        }
        $(this).parent().remove();

    });*/

    var b_validate_result = true;
    var b_validate_result1 = true;
    var b_validate_result2 = true;
    var b_validate_result3 = true;
    var b_validate_result4 = true;
    var b_validate_result5 = true;

    $("#title").focusout(function () {

        if ($("#title").val().length < 2) {
            $("#title").next().text("标题小于2个字符，不合法!");
            $("#title").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#title").next().css("display", "none");
            b_validate_result1 = true;
        }


    });

    $("#content").focusout(function () {

        if ($("#content").val().length < 2) {
            $("#content").next().text("通知内容小于2个字符，不合法!");
            $("#content").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#content").next().css("display", "none");
            b_validate_result2 = true;
        }
    });



    $("#save").click(function () {
        $("#title").focus();
        $("#content").focus();

        if($(".sendObjectDiv").length == 0){
            b_validate_result3 = false;
            alert("请选择发送对象!");
        }else {
            b_validate_result3 = true;
        }


        b_validate_result = b_validate_result1 & b_validate_result2 & b_validate_result3;
        if (!b_validate_result) {
            return;
        }

        var notify_object_phone = "";
        var notify_object_name = "";

        var selectionItems = $(".tree-multiselect .selections .section");
        for(var j = 0;j< selectionItems.length; j++){
            var items = selectionItems.eq(i).find(".item");
            for (var i = 0; i < items.length; i++) {
                if($(".sendToAll").is(":checked")){
                    notify_object_name += items.eq(i).children("label").html()+",";
                    notify_object_phone += items.eq(i).attr("data-value")+",";
                }
                else {
                    if(items.eq(i).children("input").is(":checked")){
                        notify_object_name += items.eq(i).children("label").html()+",";
                        notify_object_phone += items.eq(i).attr("data-value")+",";
                    }
                }
            }
        }
        alert(notify_object_name);
        alert(notify_object_phone);

        var url = "/insertSmsNotice";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                title: $("#title").val(),
                content: $("#content").val(),
                notify_object_phone:notify_object_phone,
                notify_object_name:notify_object_name,
                send_person: "",
                address: $("#address").val(),
                note: $("#note").val()
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    //清空表格数据
                    $("#myform1")[0].reset();
                    $("#myform2")[0].reset();
                    //显示
                    $("#successLabel").show();
                    $("#createAgainBtn").show();
                    $("#backToListBtn").show();
                    //隐藏
                    $("#submitAreaDiv").empty();
                    $("#formdiv1").empty();
                    $("#formdiv2").empty();

                }
                else {
                    $("#failLabel").css("display:block");
                  //  alert("发生了错误！错误码：" + data.errorCode + ",错误详情：" + data.errorMsg);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("系统异常！");
            }
        });


    });


    $("#createAgainBtn").click(function () {

        $.ajax({
            type: "GET",
            url: "/xiaobao/createSMSNotice",
            success: function (data) {
                $('#mainContents').empty();
                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                var data3= data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

                var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");
                $('#mainContents').append(data4);
            }
        });
    });




    $("#backToListBtn").click(function () {
        $("#smsNoticeguanli").click();

    });

    $("#formBackBtn").click(function () {
        $("#smsNoticeguanli").click();

    });

    $("#backToListbreadLink").click(function () {
        $("#smsNoticeguanli").click();

    });








});

