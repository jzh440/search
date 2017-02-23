(function(win){
    var doc = win.document;
    // 获取html节点对象
    var docEl = doc.documentElement;
    var tid;

    function refreshRem() {
        var width = docEl.getBoundingClientRect().width;
//            if (width > 540) { // 最大宽度
//                width = 540;
//            }
        var rem = width / 10; // 将屏幕宽度分成10份， 1份为1rem
        docEl.style.fontSize = rem + 'px';
        //   document.body.style.fontSize = rem + 'px';
    }


    win.addEventListener('resize', function() {
        clearTimeout(tid);
        tid = setTimeout(refreshRem, 300);
    }, false);
    win.addEventListener('pageshow', function(e) {
        if (e.persisted) {
            clearTimeout(tid);
            tid = setTimeout(refreshRem, 300);
        }
    }, false);

    refreshRem();
})(window);
(function($){
    $.getUrlParam = function(name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r!=null) return unescape(r[2]); return null;
    }
})(jQuery);

function loginValid(loginInfoObj){
    var phoneReg= /^\d{11}$/;
    var validStr= "";
    if(typeof(loginInfoObj)!= "object"){
        validStr= "前台验证异常";
    }else{
        var mobile= loginInfoObj[0].value;
        var content= loginInfoObj[1].value;
        if(!mobile || !content){
            validStr= "手机号、内容不能为空";
        }else{
            if(!phoneReg.test(mobile)){
                validStr= "手机号不正确";
            }
        }
    }
    return validStr;
}
/** 提交意见**/
var pdsFlg2 = true;

function postOpinion() {
    if(!pdsFlg2){
        return false;
    }

    var dataArr = $("form[name = opinion]").serializeArray();
    var validStr = loginValid(dataArr);
    if(validStr != ""){
        alert(validStr);
        return false;
    }
    pdsFlg2 = false;
    opinionObj.mobile = $("input[name = mobile]").val();
    opinionObj.content = $("textarea[name = content]").val();
    $.ajax({
        type: "post",
        url: "user/feedBack/postFeedBack",
        contentType : 'application/json',
        data: JSON.stringify(opinionObj),
        async: false,
        success: function(msg){
            pdsFlg2 =true;
            if(msg.status){
                $("form[name = opinion]")[0].reset();
                opinionObj.mobile = "";
                opinionObj.content = "";
                $("#interactionWord").text(100)
                alert("提交成功");
            }else{
                alert("提交失败");
            }

        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {
            pdsFlg2 =true;
            alert("提交失败");
        }
    });
}