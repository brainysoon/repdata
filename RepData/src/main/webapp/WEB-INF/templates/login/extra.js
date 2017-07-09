/**
 * Created by hxmic on 17-7-9.
 */
function logi() {

    //Ajax 请求服务器发送短信验证码
    //1【创建】
    if (window.XMLHttpRequest) {
        var oAjax = new XMLHttpRequest();
    } else {
        var oAjax = new ActiveXObject("Microsoft.XMLHTTP");
    }
    ;

    // oAjax.header("Access-Control-Allow-Origin:*");
    // /*星号表示所有的域都可以接受，*/
    // oAjax.header("Access-Control-Allow-Methods:GET,POST");


    //2: 【连接】true:表示异步
    oAjax.open('POST', "http://localhost:8080/login", true);

    var name = $("#signin-user").val();
    var password = $("#signin-password").val();

    oAjax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //3：【发送】
    oAjax.send("name=" + name + "&password=" + password);


    //4：【接受
    oAjax.onreadystatechange = function () {

        //判断浏览器操作到哪一步
        if (oAjax.readyState == 4) {//4：读取完成
            if (oAjax.status == 200) {

                var result = JSON.parse(oAjax.responseText);

                if (result.status) {

                    location.href = "../home/home.html";
                } else {
                    alert(result.message);
                }

            } else {
                alert(oAjax.status);
                alert(oAjax.responseText);
            }

        }
    }
}