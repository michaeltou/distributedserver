/**
 * Created by lenovo on 2017/7/4.
 */
$(document).ready(function () {


    $.ajax({
        type: "GET",
        url: "/xiaobao/menu.html",
        success: function (data) {
            $('#menu-left').empty();
            //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
            var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

            var data3= data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

            var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");
            $('#menu-left').append(data4);
        }
    });

    $.ajax({
        type: "GET",
        url: "/xiaobao/top.html",
        success: function (data) {
            $('#top').empty();
            //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）

            var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

            var data3= data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

            var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");

            $('#top').append(data4);
        }
    });

    $.ajax({
        type: "GET",
        url: "/xiaobao/firstpage.html",
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