/**
 * Created by hxmic on 17-7-9.
 */
function logt() {
    if (window.XMLHttpRequest) {
        var oAjax = new XMLHttpRequest;
    } else {
        var oAjax = new ActiveXObject("Microsoft.XMLHTTP");
    }

    oAjax.open('GET', 'http://localhost:8080/logout', true);

    oAjax.send();

    oAjax.onreadystatechange = function () {
        if (oAjax.readyState == 4) {
            if (oAjax.status == 200) {
                location.href = "../logout.html";

            } else {
                alert(oAjax.status);
                alert(oAjax.responseText)
            }
        }
    }

}