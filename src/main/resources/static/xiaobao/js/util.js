/**
 * Created by lenovo on 2017/7/11.
 */
function BASEisNotNum(theNum)
{
//判断是否为数字
    if (BASEtrim(theNum)=="")
        return true;
    for(var i=0;i<theNum.length;i++){
        oneNum=theNum.substring(i,i+1);
        if (oneNum<"0" || oneNum>"9")
            return true;
    }
    return false;
}
function BASEisNotInt(theInt)
{
//判断是否为整数
    theInt=BASEtrim(theInt);
    if ((theInt.length>1 && theInt.substring(0,1)=="0") || BASEisNotNum(theInt)){
        return true;
    }
    return false;
}
function BASEisNotFloat(theFloat) {
//判断是否为浮点数
    len = theFloat.length;
    dotNum = 0;
    if (len == 0)
        return true;
    for (var i = 0; i < len; i++) {
        oneNum = theFloat.substring(i, i + 1);
        if (oneNum == ".")
            dotNum++;
        if (((oneNum < "0" || oneNum > "9") && oneNum != ".") || dotNum > 1)
            return true;
    }
    if (len > 1 && theFloat.substring(0, 1) == "0") {
        if (theFloat.substring(1, 2) != ".")
            return true;
    }
    return false;
}