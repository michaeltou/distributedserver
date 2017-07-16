/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {


    $("#selectALLBtn").click(function(){
        $("[name='openSchoolNameList']").attr("checked",'true');//全选
        checkSchoolList();
    })
    $("#unSelectALLBtn").click(function(){
        $("[name='openSchoolNameList']").removeAttr("checked");//取消全选
        checkSchoolList();
    })


    var b_validate_result = true;
    var b_validate_result1 = true;
    var b_validate_result1 = true;
    var b_validate_result1 = true;
    var b_validate_result1 = true;
    var b_validate_result1 = true;

    $("#name").focusout(function () {

        if ($("#name").val().length < 2) {
            $("#name").next().text("课程名称小于2个字符，不合法!");
            $("#name").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#name").next().css("display", "none");
            b_validate_result1 = true;
        }


    });



    $("#kc_category_name").focusout(function () {

        if ($("#kc_category_name").val().length < 2) {
            $("#kc_category_name").next().text("名称小于2个字符，不合法!");
            $("#kc_category_name").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#kc_category_name").next().css("display", "none");
            b_validate_result2 = true;
        }


    });

    $("#chargeFee").focusout(function () {

        var telReg = /^\d+\.\d\d$/i;
        if (!telReg.test($("#chargeFee").val())) {
            $("#chargeFee").next().text("收费标准输入数据不合法!");
            $("#chargeFee").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#chargeFee").next().css("display", "none");
            b_validate_result3 = true;
        }


    });

  function checkSchoolList() {

      var openSchoolNameList = document.getElementsByName('openSchoolNameList'); //选择所有name="'test'"的对象，返回数组
      //取到对象数组后，我们来循环检测它是不是被选中
      var schoolList = '';
      for (var i = 0; i < openSchoolNameList.length; i++) {
          if (openSchoolNameList[i].checked){
              schoolList += openSchoolNameList[i].value + ','; //如果选中，将value添加到变量s中
          }
      }
      //去掉最后一个逗号(如果不需要去掉，就不用写)
      if (schoolList.length > 0) {
          schoolList = schoolList.substr(0, schoolList.length - 1);
      }

     $("#openSchoolNameListHidden").val(schoolList);

      if (schoolList.length < 1) {
          b_validate_result4 = false;
          $("#schoolTips").text("必须至少选择一个开课学校!");
          $("#schoolTips").css({"display": "block", "color": "red"});
          return;
      } else {
          $("#schoolTips").css("display", "none");
          b_validate_result4 = true;
      }
  };

    $(".mycheckbox").change(function () {
        checkSchoolList();
    });





    $("#save").click(function () {

        //校验是否选择了学校.
        checkSchoolList();

        $("#name").focus();
        $("#kc_category_name").focus();
        $("#chargeFee").focus();
        $("#note").focus();
        $("#name").focus();


      b_validate_result = b_validate_result1&b_validate_result2&b_validate_result3&b_validate_result4;
        if (!b_validate_result) {
            return;
        }




        var url = "/insertKeChengAndChargeInfo";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                name: $("#name").val(),
                kc_category_name: $("#kc_category_name").val(),
                openSchoolNameList:  $("#openSchoolNameListHidden").val(),
                note: $("#note").val(),
                chargeType: $("#chargeType").val(),
                chargeFee: $("#chargeFee").val()
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    //清空表格数据
                    $("#myform")[0].reset();
                    //显示
                    $("#successLabel").show();
                    $("#createAgainBtn").show();
                    $("#backToListBtn").show();
                    //隐藏
                    $("#submitAreaDiv").empty();
                    $("#formdiv").empty();
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
            url: "/xiaobao/createKeCheng",
            success: function (data) {
                $('#mainContents').empty();
                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                var data3= data2.replace(/\<script src=\"js\/bootstrap.js\"\>\<\/script\>/, "");

                var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"css\/bootstrap.css\"\/\>/, "");
                $('#mainContents').append(data4);
            }
        });
    });




    $("#backToListBtn").click(function () {
        $("#kechengguanli").click();

    });

    $("#formBackBtn").click(function () {
        $("#kechengguanli").click();

    });

    $("#backToListbreadLink").click(function () {
        $("#kechengguanli").click();

    });








});

