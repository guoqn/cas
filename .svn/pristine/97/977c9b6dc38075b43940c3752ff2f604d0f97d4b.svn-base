/**
 * Created by qn_guo on 2016/1/21.
 */
$.fn.bigGlass = function(type){
    /**
     * 针对数字的分隔  用“,”  3 ,3, 3
     * @type {*|Window|Number|jQuery}
     */
    var glassT = $(this).offset().top, glassL = $(this).offset().left;//定义预展示输入框的坐标
    var gId = $(this).attr("id");
    var glassStr = '<div id="bigGlass"><nobr><span></span></nobr></div>';
    $(this).after($(glassStr));
    $(this).keyup(function(event){
        var keyCode = event.which;
        showBigGlass(keyCode);
    })
    //生成放大镜
    function showBigGlass(keyCode){
        var inputVal = $("#"+gId).val(), l = inputVal.length;
        $("#bigGlass").css({"top":(glassT-50)+"px","left":glassL+"px"});
        style="top:'+(glassT-50)+'px;left:'+glassL+'px;"
        if(!inputVal){
            $("#bigGlass").hide();
            return false;
        }
        $("#bigGlass").html('<nobr><span></span></nobr>');

/*        if ( $.isNumeric(inputVal) !== true || keyCode == 32){//判断输入类型，并去除空格
            $(this).val(inputVal.slice(0,-1) );  //截掉非数字和空格
            return false;
        }*/
        var re=/(?=(?!\b)(\d{3})+$)/g; //分割数字 1,000
        inputVal = inputVal.replace(re,",");
        $("#bigGlass").find("span").eq(0).text(inputVal);
        $("#bigGlass").show();
    }
    //控制数字放大镜的显示与销毁
    $(document).click(function(event){
        var obj = event.srcElement || event.target;
        if($(obj).attr("id") != gId){
            $("#bigGlass").html("").hide();
        }else{
            showBigGlass();
        }
    });
}
/**
 * 验证输入是否是正确的金额
 * @param obj
 */
function clearNoNum(obj) {
    obj.value = obj.value.replace(/[^\d.]/g, "");  //清除“数字”和“.”以外的字符
    obj.value = obj.value.replace(/^\./g, "");  //验证第一个字符是数字而不是.
    obj.value = obj.value.replace(/\.{2,}/g, "."); //只保留第一个. 清除多余的.
    obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
}