$(function(){
    		$(".form1").Validform({
    			ajaxPost:true,
    			tiptype:function(msg,o,cssctl){
    				 if(!o.obj.is("form")){
    				 	var objtip=o.obj.siblings(".Validform_checktip");
    				 	cssctl(objtip,o.type);
				 	 if(msg =="codeNotExist"){
						var a=document.getElementById ("error");
            				a.innerHTML = "验证码不一致";
					}else{
						var a=document.getElementById ("error");
            				a.innerHTML = msg;
					}
    				}else{
    					if(msg ==1){
    					}else{
                        			if(o.type !== 1){
						}
    					}
    				}
    			},
    			callback:function(data){
    				if(data.status=="n"){
    					var error=document.getElementById ("error");
            			error.innerHTML = data.info;
            			document.getElementById ("txtPwd").value="";
            			document.getElementById ("txtCode").value="";
            			return false;
    				}else{
    					alert(data.info);
                    		setTimeout(function(){
                        		window.location="index.html";
                    		}, 1000);
    					return true;
    				}
    			},
    });
})

function changeImage(img){
    	img.src = img.src+"?"+new Date().getTime();
    	}
