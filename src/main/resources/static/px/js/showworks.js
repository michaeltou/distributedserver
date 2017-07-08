$(function () {

    for(var i = 0 ;i < 30;i++){
        $div = $('<div class="col-sm-4 col-md-3"></div>');
        $a = $('<a class="lightbox" href="http://img10.360buyimg.com/N0/25765/8c345757-28b4-43e3-bc07-1088eb92e394.jpg"></a>');
        $img = $('<img src="http://img10.360buyimg.com/N0/25765/8c345757-28b4-43e3-bc07-1088eb92e394.jpg" alt="Park">');
        $a.append($img);
        $div.append($a);
        $(".row").append($div);
    }
    baguetteBox.run('.tz-gallery');

});