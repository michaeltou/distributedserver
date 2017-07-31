/**
 * Created by lenovo on 2017/7/4.
 */
$(document).ready(function () {

    // $("#panel-people-management a").on('click', function () {
    $("a.list-group-item").on('click', function () {

        var href = $(this).attr('href');



        /**  这是第二种加载页面方式 **/
        $.ajax({
            type: "GET",
            url:   href,
            success: function (data) {

                $('#mainContents').empty();
                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                var data3= data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

                var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");

                $('#mainContents').append(data4);


            }
        });

//阻止跳转
        return false;
    });

    //   bootstrap 页面设计工具：http://www.layoutit.com/



});