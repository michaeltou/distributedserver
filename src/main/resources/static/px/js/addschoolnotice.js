$(function () {
    updateAll();
});


function updateAll() {
    var arrVar = [], sVar, sJSInit, sInit;
    var textareaID = "elem1";
    var editor = $('textarea[name=preview]')[0].editor;
    if (editor) editor.getSource();
    $('textarea[name=preview]').attr('id', textareaID).xheditor(false);
    sJSInit = "$('#" + textareaID + "').xheditor(" + (sVar ? '{' + sVar + '}' : '') + ');';
    if ($('#editorMode').val() == 1) {
        sInit = ' class="xheditor' + (sVar ? ' {' + sVar + '}' : '') + '"';
        sInit = sInit.replace(/(.+?xheditor)(.+?)tools:'(simple|mini)',?(.+?)/i, '$1-$3$2$4');
    }
    else sInit = sJSInit;
    $('link[id^=xheCSS]').remove();
    try {
        eval(sJSInit);
    } catch (e) {
    }
    $('#source').val(sInit);
}

function onCancelClick() {
    window.location.href = "SchoolNoticeList.html";
}
function onSendlClick() {
    window.location.href = "SchoolNoticeList.html";
}

function onRoleTypeCheckBoxClick(sender) {
    if (sender.checked) {
        var parentNode = sender.parentNode;
        parentNode.innerHTML = '<input value="所有人" name="roleType" type="checkbox" class="roleType" checked = "checked"; onclick="onRoleTypeCheckBoxClick(this);"> 所有人';
    } else {
        for (var i = 0; i < 10; i++) {
            var newChcekBox = document.createElement("input");
            newChcekBox.value = "value" + i;
            newChcekBox.name = "roleType";
            newChcekBox.type = "checkbox";
            newChcekBox.className = "roleType";
            addEventHandler(newChcekBox, 'click', fnHandle);

            var parentNode = sender.parentNode;
            parentNode.appendChild(newChcekBox);
            parentNode.appendChild(document.createTextNode('销售'));

        }
    }
}


function onSchoolTypeCheckBoxClick(sender) {
    if (sender.checked) {
        var parentNode = sender.parentNode;
        parentNode.innerHTML = '<input value="" name="schoolType" type="checkbox" class="schoolType" checked = "checked"; onclick="onSchoolTypeCheckBoxClick(this)"> 所有校区';
    } else {
        for (var i = 0; i < 10; i++) {
            var newChcekBox = document.createElement("input");
            newChcekBox.value = "value" + i;
            newChcekBox.name = "schoolType";
            newChcekBox.type = "checkbox";
            newChcekBox.className = "schoolType";
            addEventHandler(newChcekBox, 'click', fnHandle);

            var parentNode = sender.parentNode;
            parentNode.appendChild(newChcekBox);
            parentNode.appendChild(document.createTextNode('校区' + i));

        }
    }
}
function onForTopCheckBoxClick() {

}

function fnHandle(e) {
    e = e || window.event; 　//IE window.event
    var t = e.target || e.srcElement; //目标对象
    var classname = t.className;
    if (classname == 'ac') {
        oul.removeChild(t.parentNode);
    }
    if (e.target.checked){
        e.target.setAttribute("checked",true);
    }else {
        e.target.setAttribute("checked",false);
        e.target.removeAttr("checked");
    }
}


function addEventHandler(oTarget, sEventType, fnHandler) {
    if (oTarget.addEventListener) {   //监听IE9，谷歌和火狐
        oTarget.addEventListener(sEventType, fnHandler, false);
    } else if (oTarget.attachEvent) {  //IE
        oTarget.attachEvent("on" + sEventType, fnHandler);
    } else {
        oTarget["on" + sEventType] = fnHandler;
    }
}




