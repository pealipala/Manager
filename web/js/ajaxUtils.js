
function ajaxUtils(method,url,data,deal200,deal404,deal500,async) {
    //获取ajax引擎对象
    var ajax=getAjax();
    //覆写onreadystatechange函数
    ajax.onreadystatechange=function () {
        //判断ajax状态码
        if(ajax.readyState==4){
            if(ajax.status==200){
                if(deal200){
                    deal200(ajax);
                }else if(deal404){
                    deal404();
                }else if(deal500){
                    deal500();
                }
            }
        }
    }
    if ("get"==method){
        ajax.open("get",url+(data==null?"":"?"+data),async);
        ajax.send(null);
    }else if ("post"==method){
        ajax.open("post",url,async);
        ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        ajax.send(data)
    }

}
function getAjax() {
     var ajax;
     if(window.XMLHttpRequest){
         ajax=new XMLHttpRequest();
     }else if(window.ActiveXObject){
         ajax=new ActiveXObject("Msxml2.XMLHTTP")
     }
     return ajax;
 }