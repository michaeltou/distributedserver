$(function(){
	
		//自定义函数
		//=============================================
		$.extend({chargingModeChanged:function(){
			$("#tuitionStandardUnit").empty();
			if($("#chargingModeText").children('option:selected').val() == "1"){
				$("#tuitionStandardUnit").append("<option value='1' selected>元/课时</option>");
				$(".classHourDiv").hide();
			}
			else if($("#chargingModeText").children('option:selected').val() == "2"){
				$("#tuitionStandardUnit").append("<option value='2' selected>元/天 </option>");
				$("#tuitionStandardUnit").append("<option value='3' >元/月 </option>");
				$("#tuitionStandardUnit").append("<option value='4' >元/季</option>");
				$("#tuitionStandardUnit").append("<option value='5' >元/年</option>");
				$(".classHourDiv").hide();
			}else if($("#chargingModeText").children('option:selected').val() == "3"){
				$("#tuitionStandardUnit").append("<option value='6' selected>元/期 </option>");
				$(".classHourDiv").show();
			}
		}});
		
		//=============================================
		
		$.chargingModeChanged();
		
		$("input[name='classType']").eq(0).attr("checked","checked");
		$("input[name='classType']").eq(0).click();
		
		$("input[name='courseStatus']").eq(0).attr("checked","checked");
		$("input[name='courseStatus']").eq(0).click();
		
		$('.addCourse input[type=radio]').button();
		$('.addCourse input[title]').tooltip({
			show:false,
			hide:false,
			position:{
				my:'top left',
				at:'right center'
			}
		});
		
		$('#newCourse').click(function(){
			$('.addCourse').dialog("option","title", "新建课程").dialog('open');
		});
		
		$("#chargingModeText").change(function(){
			$.chargingModeChanged();
		});
		
		$('#newTeachingMaterial').click(function(){
			var html = '<select id="authorifyselect" multiple="multiple">' +
                  '<option  value="1" data-section="教材"  selected>电脑</option>' +
                  '<option  value="2" data-section="教材"  selected>钢琴</option>' +
                  '<option  value="3" data-section="教材"  selected>跳舞鞋</option>' +
                  '<option  value="6" data-section="杂费">手续费</option>' +
                  '<option  value="7" data-section="杂费">场地费</option>' +
                  '</select>';
        		$("#authorityBody").empty().append(html);
        		$("#authorifyselect").treeMultiselect({ searchable: false, hideSidePanel: false });
			$('.addTeachingMaterial').dialog("option","title", "教材杂费一览").dialog('open');
		});
		
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
 			$('.addCourse').dialog("option","title", "编辑课程").dialog('open');
		});
		
	
		$('.addCourse').dialog({
			autoOpen:false,
			resizable: false,
			modal: true,
			width:870,
			height:640,
			title:'新建课程',
			buttons:{
			'保存':function(){
				if($("#employeeNameText").val() == ""){
					alert("姓名不能为空。");
					$("#employeeNameText").focus();
					return;
				}else if($("#employeePhoneText").val() == ""){
					alert("手机号码不能为空。");
					$("#employeePhoneText").focus();
					return;
				}else if($("#employeeAgeText").val() == ""){
					alert("年龄不能为空。");
					$("#employeeAgeText").focus();
					return;
				}else if($("#schoolTypeText").children('option:selected').val() == undefined){
					alert("所属校区不能为空。");
					$("#schoolTypeText").focus();
					return;
				}
				//$(this).submit();
				$(this).dialog('close');
				//-----------------------------
				var tr = $("<tr></tr>").attr("bgcolor","#FFFFFF"); 
				tr.append($("<td></td>").html($("#employeeNameText").val())); 
				tr.append($("<td></td>").html($("#employeePhoneText").val())); 
				tr.append($("<td></td>").html($("#schoolTypeText").children('option:selected').val())); 
				tr.append($("<td></td>").html($("input[type='radio'][name='sex']:checked").val())); 
				tr.append($("<td></td>").html($("#employeeAgeText").val())); 
				tr.append($("<td></td>").html($("#logonAcountText").val())); 
				tr.append($("<td></td>").html($("input[type='radio'][name='logonPermission']:checked").val())); 
				tr.append($("<td></td>").html("<input type='button' name='deleteButton' value='删除' class='deleteButton'> <input type='button' name='editButton' value='编辑' class='editButton' >")); 
				tr.appendTo($("tbody")); 
				
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
		
		
		$('.addTeachingMaterial').dialog({
			autoOpen:false,
			resizable: false,
			modal: true,
			width:600,
			height:400,
			title:'教材杂费一览',
			buttons:{
			'保存':function(){
				$(this).dialog('close');
			},
			'取消':function(){
			$(this).dialog('close');
			}
			},
			open: function (event, ui) {
			 $(".ui-dialog-titlebar-close", $(this).parent()).hide();
			 },
		
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
		
		//加的效果
    	$("body").on('click',".add", function(){
			var price = $(this).parent().parent().parent().children('td:eq(2)').text();
			price = parseInt(price);
			var n=$(this).prev().val();
			var num=parseInt(n)+1;
			if(num==0){ return;}
			$(this).prev().val(num);
			var totalPrice = num*price;
			totalPrice +="元";
			$(this).parent().parent().parent().children('td:eq(3)').text(totalPrice) ;
		});
		//减的效果
    	$("body").on('click',".jian", function(){
			var price = $(this).parent().parent().parent().children('td:eq(2)').text();
			price = parseInt(price);
			var n=$(this).next().val();
			var num=parseInt(n)-1;
			if(num==0){ return}
			$(this).next().val(num);
			var totalPrice = num*price;
			totalPrice +="元";
			$(this).parent().parent().parent().children('td:eq(3)').text(totalPrice) ;
		});
});

function EditData(editRow){
	var tr = editRow.parentNode.parentNode;
	byId("employeeNameText").value = (tr.cells[0]).innerHTML;
	byId("employeePhoneText").value = (tr.cells[1]).innerHTML;
	var all_options = document.getElementById("schoolTypeText").options;
  	for (i=0; i<all_options.length; i++){
       if (all_options[i].value == (tr.cells[2]).innerHTML)  // 根据option标签的ID来进行断  测试的代码这里是两个等号
       {
         	all_options[i].selected = true;
       }
       
       if(tr.cells[3].innerHTML == "女"){
       	 byId("female").click();
       }else{
      	 byId("male").click();
      }
    }
    byId("employeeAgeText").value = (tr.cells[4]).innerHTML;
}

function DeleteData(delRow){
	var table=delRow.parentNode.parentNode.parentNode;
 	 table.removeChild(delRow.parentNode.parentNode);
}
 
 function byId(id) { 
	return document.getElementById(id); 
} 

function load()    
{    
	var object = byId("courseTypeText");    
    	object.selectedIndex = -1;    
    	
    	object = byId("courseTimeText");    
    	object.selectedIndex = -1;  
    	
    	object = byId("chargingModeText");    
    	object.selectedIndex = 0;  
}    
