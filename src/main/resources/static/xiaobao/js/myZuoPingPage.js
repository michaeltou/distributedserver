/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {


    var obj = $(".myimage"),
        windowheight = window.innerHeight || document.documentElement.clientHeight;
    for (var i = 0; i < obj.length; i++) {
        obj[i].url = obj[i].getAttribute("data-url");
        obj[i].top = obj[i].offsetTop;
        obj[i].flag = true;  //防止浏览器一直加载图片，这样图片加载成功后，滚动浏览器的时候就不会再加载图片了；
    }
    var fnLoad = function (obj) {
        var scrollY = document.body.scrollTop || document.documentElement.scrollTop;
        //  if(t+h>obj.top+200&&obj.top>t){ //给个200为了提高让用户看到图片加载状态，更加友好
        //  alert("windowheigt:"+windowheight + ",scrollY:"+scrollY + ",object.top:"+obj.top);

        if (scrollY + windowheight > obj.top + 300 && obj.top + 200 > scrollY) { //给个200为了提高让用户看到图片加载状态，更加友好
            setTimeout(function () {
                obj.src = obj.url;
                obj.flag = false;
            }, 500)
        }
    }
    window.onscroll = window.onload = function () {
        for (var i = 0; i < obj.length; i++) {
            if (obj[i].flag) {
                fnLoad(obj[i]);
            }
        }
    }

    for (var i = 0; i < obj.length; i++) {
        if (obj[i].flag) {
            fnLoad(obj[i]);
        }
    }

});

