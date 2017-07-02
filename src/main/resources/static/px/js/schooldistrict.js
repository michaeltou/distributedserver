$(function () {

    $('#newSchoolBtn').click(function () {
        $('.AddSchoolDistrict').dialog("option", "title", "新建校区").dialog('open');
    });




    /*
     $('input[name="deleteButton"]').click(function(event){
     DeleteData($(this).get(0));
     });

    /*
     $('.editButton').click(function(event){
     EditData($(this).get(0));
     $('.AddSchoolDistrict').dialog('open');
     });
     */
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

    $("body").on('click', ".editButton", function () {
        EditData($(this).get(0));
        $('.UpdateSchoolDistrict').dialog("option", "title", "编辑校区").dialog('open');
    });


    $('.AddSchoolDistrict').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 440,
        height: 460,
        title: '新建校区',
        buttons: {
            '保存': function () {
                if ($("#schoolCodeText").val() == "") {
                    alert("校区编码不能为空。");
                    $("#schoolCodeText").focus();
                    return;
                } else if ($("#schoolNameText").val() == "") {
                    alert("校区名称不能为空。");
                    $("#schoolNameText").focus();
                    return;
                } else if ($("#schoolContactText").val() == "") {
                    alert("校长不能为空。");
                    $("#schoolContactText").focus();
                    return;
                }
                else if ($("#schoolContactPersonText").val() == "") {
                    alert("校长身份证不能为空。");
                    $("#schoolContactPersonText").focus();
                    return;
                }else if ($("#schoolPhoneText").val() == "") {
                    alert("联系电话不能为空。");
                    $("#schoolPhoneText").focus();
                    return;
                }
                else if ($("#schoolAddressText").val() == "") {
                    alert("校区地址不能为空。");
                    $("#schoolAddressText").focus();
                    return;
                }
                //$(this).submit();
                $.ajax({
                    url: "/px/insertSchool",//servlet文件的名称
                    type: "POST",
                    data:JSON.stringify({ school_name:$("#schoolNameText").val(), phone:$("#schoolCodeText").val(), address:$("#schoolAddressText").val(),
                        phone:$("#schoolPhoneText").val(), principal_name:$("#schoolContactText").val() , principal_sfz_code:$("#schoolContactPersonText").val(), type:$("#schoolTypeText").val()}),
                    contentType: "application/json; charset=utf-8",
                    success: function (data, textStatus) {
                        if(data.success){
                            alert("更新学校成功");
                            window.location.href="/px/serachSchool";
                        }
                        else{
                            window.alert("更新学校失败");
                        }
                    }
                });
                $(this).dialog('close');
                //-----------------------------

                //------------------------------
            },
            '取消': function () {
                $(this).dialog('close');
            }
        },
        open: function (event, ui) {
            $(".ui-dialog-titlebar-close", $(this).parent()).hide();
        },

    });

    $('.UpdateSchoolDistrict').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 440,
        height: 400,
        title: '更新校区',
        buttons: {
            '保存': function () {
            if ($("#schoolMasterText").val() == "") {
                    alert("校长不能为空。");
                    $("#schoolMasterText").focus();
                    return;
                }
                else if ($("#schoolMasterCodeText").val() == "") {
                    alert("校长身份证不能为空。");
                    $("#schoolMasterCodeText").focus();
                    return;
                }else if ($("#phoneText").val() == "") {
                    alert("联系电话不能为空。");
                    $("#phoneText").focus();
                    return;
                }
                else if ($("#addressText").val() == "") {
                    alert("校区地址不能为空。");
                    $("#addressText").focus();
                    return;
                }
                //$(this).submit();
                $.ajax({
                    url: "/px/updateSchool",//servlet文件的名称
                    type: "POST",
                    data:JSON.stringify({ id:$("#idText").val(), address:$("#addressText").val(),school_name:$("#updateSchoolNameTitle").val(),institution_code:$("#updateCodeTitle").val(),
                        phone:$("#phoneText").val(), principal_name:$("#schoolMasterText").val() , principal_sfz_code:$("#schoolMasterCodeText").val(), type:$("#typeText").val()}),
                    contentType: "application/json; charset=utf-8",
                    success: function (data, textStatus) {
                        if(data.success){
                            alert("更新学校成功");
                            window.location.href="/px/serachSchool";
                        }
                        else{
                            window.alert("更新学校失败");
                        }
                    }
                });
                $(this).dialog('close');
                //-----------------------------

                //------------------------------
            },
            '取消': function () {
                $(this).dialog('close');
            }
        },
        open: function (event, ui) {
            $(".ui-dialog-titlebar-close", $(this).parent()).hide();
        },

    });


    $(document).ready(function () {
        $("#NewSchoolDistrict").attr("disabled", "true");
        $("#UpdateSchoolDistrict").attr("disabled", "true");
        $(".MaxSchoolDistrictCount").show();
        /*
        $.ajax({
            url: "/sms/servlet/CheckSignatureExistServlet",//servlet文件的名称
            type: "GET",
            success: function (data, textStatus) {
                if (data == "exist") {
                    $("#NewSchoolDistrict").attr("disabled", false);
                    $(".MaxSchoolDistrictCount").hide();
                } else {
                    $("#NewSchoolDistrict").attr("disabled", "true");
                    $(".MaxSchoolDistrictCount").show();
                }
            }
        });
        */
    });

    
    $("#search").click(function () {

        if ($("#keyword").val() == "") {
            alert("输入不能为空");
            $("#keyword").focus();
            return;
        }
        var institution_code=$("#keyword").val();
        window.location.href="/px/querySchoolListByInstitution?institution_code="+institution_code;
    });
    
});

function EditData(editRow) {
    var tr = editRow.parentNode.parentNode;
    var cell = tr.cells[0];//获取某行下面的某个td元素
    byId("idText").value = (tr.cells[0]).innerHTML;
    byId("schoolMasterText").value = (tr.cells[4]).innerHTML;
    byId("schoolMasterCodeText").value = (tr.cells[5]).innerHTML;
    byId("phoneText").value = (tr.cells[6]).innerHTML;
    byId("addressText").value = (tr.cells[7]).innerHTML;
    byId("updateSchoolNameTitle").value=(tr.cells[1]).innerHTML;
    byId("updateCodeTitle").value=(tr.cells[2]).innerHTML;
    //byId("schoolTypeText").value = (tr.cells[2]).innerHTML;
    var all_options = document.getElementById("typeText").options;
    for (i = 0; i < all_options.length; i++) {
        if (all_options[i].value == (tr.cells[3]).innerHTML)  // 根据option标签的ID来进行断  测试的代码这里是两个等号
        {
            all_options[i].selected = true;
        }
    }
}

function DeleteData(delRow) {
    var tr = delRow.parentNode.parentNode;
    var idTxt=(tr.cells[0]).innerText;
    var schoolName=(tr.cells[1]).innerText;
    var institutionCode=(tr.cells[2]).innerText;
    $.ajax({
        url: "/px/deleteSchool",//servlet文件的名称
        type: "POST",
        data:JSON.stringify({id:idTxt,school_name:schoolName,institution_code:institutionCode,}),
        contentType: "application/json; charset=utf-8",
        success: function (data, textStatus) {
            if(data.success){
                alert("删除学校成功");
                window.location.href="/px/serachSchool";
            }
            else{
                window.alert("删除学校失败");
            }
        }
    });

}

function byId(id) {
    return document.getElementById(id);
} 