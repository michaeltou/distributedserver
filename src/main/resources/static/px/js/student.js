$(function(){
	
		//=============================================
		$("input[name='sex']").eq(0).attr("checked","checked");
		$("input[name='sex']").eq(0).click();
		
		$('.AddStudent input[type=radio]').button();
		$('.AddStudent input[title]').tooltip({
			show:false,
			hide:false,
			position:{
				my:'top left',
				at:'right center'
			}
		});
		
		$('#NewStudent').click(function(){
			$('.AddStudent').dialog("option","title", "新生报名").dialog('open');
		});
		
		//课程选择dialog
		$('#accordingCourse').click(function(){
			$('.selectCourse').dialog("option","title", "课程选择").dialog('open');
		});
		
		//班级选择dialog
		$('#accordingClasses').click(function(){
			$('.selectClasses').dialog("option","title", "班级选择").dialog('open');
		});
		// 
		$("body").on('click',".teachingMaterialButton", function(){
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
		
		$("body").on('click',".placementButton", function(){
			$('.selectClasses').dialog("option","title", "班级选择").dialog('open');
		});
		
		$("body").on('click',".discountButton", function(){
			$('.discountSelect').dialog("option","title", "优惠设定").dialog('open');
		});
		
		$("#imageselect").click(function(){
    			$("input[type='file']").click();
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
 			$('.AddEmplyee').dialog("option","title", "编辑社员").dialog('open');
		});
		
	
		$('.AddStudent').dialog({
			autoOpen:false,
			resizable: false,
			modal: true,
			width:1270,
			height:600,
			title:'新生报名',
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
		
		
		// 课程选择dialog
		$('.selectCourse').dialog({
			autoOpen:false,
			resizable: false,
			modal: true,
			width:670,
			height:500,
			title:'选择课程',
			buttons:{
			'选择':function(){
					if($lastClickTr){
					$(this).dialog('close');
					var tdArr = $lastClickTr.children();
					$("#courseText").val(tdArr.eq(0).html());
				}else{
					alert("请选择课程");
					return false;
				}
			},
			'取消':function(){
			$(this).dialog('close');
			}
			},
			open: function (event, ui) {
			 $(".ui-dialog-titlebar-close", $(this).parent()).hide();
			 },
		
		});
		
		//教材杂费dialog
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
		
		// 班级选择dialog
		$('.selectClasses').dialog({
			autoOpen:false,
			resizable: false,
			modal: true,
			width:770,
			height:500,
			title:'选择班级',
			buttons:{
			'选择':function(){
				
			},
			'取消':function(){
			$(this).dialog('close');
			}
			},
			open: function (event, ui) {
			 $(".ui-dialog-titlebar-close", $(this).parent()).hide();
			 },
		
		});
		
		//优惠设定
		$('.discountSelect').dialog({
			autoOpen:false,
			resizable: false,
			modal: true,
			width:600,
			height:250,
			title:'优惠设定',
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
    var object = byId("schoolTypeText");    
    object.selectedIndex = -1;    
    
    object = byId("employeeMarriedText");    
    object.selectedIndex = -1;  
    
    object = byId("politicalStatusText");    
    object.selectedIndex = -1;  
    
    object = byId("educationText");    
    object.selectedIndex = -1;  
    
    object = byId("laborRelationsText");    
    object.selectedIndex = -1;  
    
    object = byId("personnelStatusText");    
    object.selectedIndex = -1;  
    
    object = byId("laborContractText");    
    object.selectedIndex = -1;  
    
    object = byId("socialSecurityText");    
    object.selectedIndex = -1;  
}    

var filechange=function(event){
    var files = event.target.files, file;
    if (files && files.length > 0) {
        // 获取目前上传的文件
        file = files[0];// 文件大小校验的动作
        if(file.size > 1024 * 1024 * 2) {
            alert('图片大小不能超过 2MB!');
            return false;
        }
        // 获取 window 的 URL 工具
        var URL = window.URL || window.webkitURL;
        // 通过 file 生成目标 url
        var imgURL = URL.createObjectURL(file);
        //用attr将img的src属性改成获得的url
        $("#employeeImage").attr("src",imgURL);
        $("#employeeImageHref").attr("href",imgURL);
        // 使用下面这句可以在内存中释放对此 url 的伺服，跑了之后那个 URL 就无效了
        // URL.revokeObjectURL(imgURL);
    }
};