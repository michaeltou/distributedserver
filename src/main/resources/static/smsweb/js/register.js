$(function(){
    	$(".regform").Validform({
    	 ajaxPost:true,
        tiptype:function(msg,o,cssctl){

            if(!o.obj.is("form")){
               var objtip=o.obj.siblings(".Validform_checktip");
				cssctl(objtip,o.type);
				if(msg =="userExist"){
					objtip.text("用户名已存在");
				}else if(msg =="codeNotExist"){
					objtip.text("验证码不一致");
				}else{
					objtip.text(msg);
				}
            }
        },
       
        callback:function(data){
        		alert("注册成功.");
                    setTimeout(function(){
                        window.location="login.html";
                    }, 1000);
    		},
    });
})

function changeImage(img){
    	img.src = img.src+"?"+new Date().getTime();
    }
    
