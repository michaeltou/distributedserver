$(function () {

    $(".upload-footer").hide();

    $('#addPicturesbutton').click(function () {
        $("input[type='file']").click();
    });

    $("#uploadbutton").click(function () {
        alert("代码未对应");
    });

    $(".addPicturesDiv").on("click","img",function () {

        if($(".addPictureDiv").length > 0){
            //如果点击的是最后一个图片,则继续添加图片
            if ($(this).is($(".addPictureDiv").eq($(".addPictureDiv").length -1).find("img"))){
                $("input[type='file']").click();
            }
        }

    });

    $(".addPicturesDiv").on("click",".deleteButton",function () {
        $(this).parents(".addPictureDiv").remove();
        if($(".addPictureDiv").length == 1){
            $(".addPictureDiv").eq(0).remove();
            $(".addBtnDiv").show();
            $(".upload-footer").hide();
        }
    });
});


var filechange = function (event) {
    var files = event.target.files, file;
    if (files && files.length > 0) {


       for(var i = 0; i < files.length;i++){
           // 获取目前上传的文件
           file = files[i];// 文件大小校验的动作
           // 获取 window 的 URL 工具
           var URL = window.URL || window.webkitURL;
           // 通过 file 生成目标 url
           var imgURL = URL.createObjectURL(file);

           // 将添加按钮隐藏

           if ($(".addPictureDiv").length == 0) {
               $div = $('<div class="addPictureDiv"></div>');
               $img = $('<img src="">');
               $img.attr("src", imgURL);

               $divSpan = $('<div style="margin-top: -25px; margin-left: 130px;"></div>');
               $span = $('<span title="删除" class="deleteButton icon iconfont icon-close"></span>');
               $divSpan.append($span);

               $div.append($img);
               $div.append($divSpan);
               $(".addPicturesDiv").append($div);



               $div1 = $('<div class="addPictureDiv"></div>');
               $img1 = $('<img src="image/addimage.png">');
               $div1.append($img1);
               $(".addPicturesDiv").append($div1);
               $(".upload-footer").show();
               $(".addBtnDiv").hide();
           }else {
               $div = $('<div class="addPictureDiv"></div>');
               $img = $('<img src="">');
               $img.attr("src", imgURL);

               $divSpan = $('<div style="margin-top: -25px; margin-left: 130px;"></div>');
               $span = $('<span title="删除" class="deleteButton icon iconfont icon-close"></span>');
               $divSpan.append($span);

               $div.append($img);
               $div.append($divSpan);

               $(".addPictureDiv").eq($(".addPictureDiv").length -1).before($div);
           }
       }
    }
};





