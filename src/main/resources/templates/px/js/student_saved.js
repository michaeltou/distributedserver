(function ($) {
    var printAreaCount = 0;
    $.fn.printArea = function () {
        var ele = $(this);
        var idPrefix = "printArea_";
        removePrintArea(idPrefix + printAreaCount);
        printAreaCount++;
        var iframeId = idPrefix + printAreaCount;
        var iframeStyle = 'position:absolute;width:0px;height:0px;left:-500px;top:-500px;';
        iframe = document.createElement('IFRAME');
        $(iframe).attr({
            style: iframeStyle,
            id: iframeId
        });
        document.body.appendChild(iframe);
        var doc = iframe.contentWindow.document;
        $(document).find("link").filter(function () {
            return $(this).attr("rel").toLowerCase() == "stylesheet";
        }).each(
            function () {
                doc.write('<link type="text/css" rel="stylesheet" href="'
                    + $(this).attr("href") + '" >');
            });
        doc.write('<div class="' + $(ele).attr("class") + '">' + $(ele).html()
            + '</div>');
        doc.close();

        var frameWindow = iframe.contentWindow;
        frameWindow.close();
        frameWindow.focus();
        pagesetup_null();
        frameWindow.print();
        pagesetup_default();
    }
    var removePrintArea = function (id) {
        $("iframe#" + id).remove();
    };
})(jQuery);

$(function () {
    $(".btnPrint").click(function () {
        //$(".printDataDiv").printArea();
        if ($(this).parents(".feeVoucher").length > 0) {
            $(this).parents(".feeVoucher").children(".printDataDiv").printArea();
        } else if ($(this).parents(".classPermit").length > 0) {
            $(this).parents(".classPermit").children(".printDataDiv").printArea();
        }
    });

    $("#back").click(function () {
        //alert("");
        window.location.href = "Student.html";
    });
});

var hkey_root, hkey_path, hkey_key
hkey_root = "HKEY_CURRENT_USER"
hkey_path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\"
//设置网页打印的页眉页脚为空
function pagesetup_null() {
    try {
        var RegWsh = new ActiveXObject("WScript.Shell")
        hkey_key = "header"
        RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
        hkey_key = "footer"
        RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "")
    } catch (e) {
    }
}
//设置网页打印的页眉页脚为默认值
function pagesetup_default() {
    try {

        var RegWsh = new ActiveXObject("WScript.Shell")
        hkey_key = "header"
        RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "&w&b页码，&p/&P")
        hkey_key = "footer"
        RegWsh.RegWrite(hkey_root + hkey_path + hkey_key, "&u&b&d")
    } catch (e) {
    }
}
