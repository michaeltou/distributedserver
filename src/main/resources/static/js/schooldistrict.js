$(function(){
		$('#NewSchoolDistrict').click(function(){
			$('.AddSchoolDistrict').dialog("option","title", "新建校区").dialog('open');
		});

		/*
		$('.editButton').click(function(event){
			EditData($(this).get(0));
			$('.AddSchoolDistrict').dialog('open');
		});
		*/
		$("body").on('click',".deleteButton", function(){


			if(window.confirm('你确定要删除吗？')){
                 		//alert("确定");
                 		DeleteData($(this).get(0));
                		 return true;
	              }else{
	                 //alert("取消");
	                 return false;
	             }
		});

		$("body").on('click',".editButton", function(){
 			EditData($(this).get(0));
 			$('.AddSchoolDistrict').dialog("option","title", "编辑校区").dialog("option","name","update").dialog('open');
		});
		

		$('.AddSchoolDistrict').dialog({
			autoOpen:false,
			resizable: false,
			modal: true,
			width:440,
			height:400,
			title:'新建校区',
			buttons:{
			'保存':function(){
				if($("#schoolCodeText").val() == ""){
					alert("校区编码不能为空。");
					$("#schoolCodeText").focus();
					return;
				}else if($("#schoolNameText").val() == ""){
					alert("校区名称不能为空。");
					$("#schoolNameText").focus();
					return;
				}else if($("#schoolContactText").val() == ""){
					alert("联系人不能为空。");
					$("#schoolContactText").focus();
					return;
				}else if($("#schoolPhoneText").val() == ""){
					alert("联系电话不能为空。");
					$("#schoolPhoneText").focus();
					return;
				}
				else if($("#schoolAddressText").val() == ""){
					alert("校区地址不能为空。");
					$("#schoolAddressText").focus();
					return;
				}
				var a=byId("AddSchoolDistrict");
                alert(byId("AddSchoolDistrict").title);
				var url = "/insertSchool";
				$.ajax({
					type: "post",
					url: url,
					data: JSON.stringify({schoolName: $("#schoolNameText").val(),schoolCode:$("#schoolCodeText").val(),address:$("#schoolAddressText").val(),phone:$("#schoolPhoneText").val(),
						principalName:$("#schoolContactText").val(),type:$("#schoolTypeText").val()}),
					dataType: "json",
					contentType: "application/json; charset=utf-8",//(可以)
					success: function (data, textStatus) {
						alert("添加校区成功！");
						window.location.href="/schoolsearch";     //在同当前窗口中打开窗口

					},
					error: function (XMLHttpRequest, textStatus, errorThrown) {
						alert("添加校区失败！");
					}
				});
				
				//$(this).submit();
				$(this).dialog('close');
				
				//------------------------------
			},
			'取消':function(){
			$(this).dialog('close');
			}
			},
			open: function (event, ui) {
			 $(".ui-dialog-titlebar-close", $(this).parent()).hide();
			 },
		
		});
		
		
		$(document).ready(function () {
		});
		
		$("#search").click(function(){
			$.ajax({
				type: "POST",
				url: "XXXXXX",
				data: "keyword="+$("#keyword").val(),
				success: function(data){
                        		
                  		}
			});
		});
});

function EditData(editRow){
	var tr = editRow.parentNode.parentNode;
	var cell = tr.cells[0];//获取某行下面的某个td元素
	byId("schoolCodeText").value = (tr.cells[0]).innerHTML;
	byId("schoolNameText").value = (tr.cells[1]).innerHTML;
	byId("schoolContactText").value = (tr.cells[3]).innerHTML;
	byId("schoolPhoneText").value = (tr.cells[4]).innerHTML;
	byId("schoolAddressText").value = (tr.cells[5]).innerHTML;
	//byId("schoolTypeText").value = (tr.cells[2]).innerHTML;
	var all_options = document.getElementById("schoolTypeText").options;
  	 for (i=0; i<all_options.length; i++){
      if (all_options[i].value == (tr.cells[2]).innerHTML)  // 根据option标签的ID来进行断  测试的代码这里是两个等号
      {
         all_options[i].selected = true;
      }
   }
}

function DeleteData(delRow){
	var table=delRow.parentNode.parentNode.parentNode;
	var idValue=delRow.parentNode.parentNode.childNodes[1].innerText;
	var url = "/deleteSchool";
	$.ajax({
		type: "post",
		url: url,
		data: idValue,
		dataType: "json",
		contentType: "application/json; charset=utf-8",//(可以)
		success: function (data, textStatus) {
			alert("删除校区成功！");
			window.location.href="/schoolsearch";     //在同当前窗口中打开窗口

		},
		error: function (XMLHttpRequest, textStatus, errorThrown) {
			alert("删除校区失败！");
		}
	});

}
 
 function byId(id) { 
	return document.getElementById(id); 
} 