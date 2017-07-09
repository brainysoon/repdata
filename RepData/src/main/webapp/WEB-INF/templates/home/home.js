/**
 * Created by hxmic on 17-7-9.
 */
function through() {
    if (window.XMLHttpRequest){
        var oAjax = new XMLHttpRequest();
    }else {
        var oAjax = new ActiveXObject();
    }
    var key = $('#key').val();
    oAjax.open('GET', 'http://localhost:8080/search?key=' + key, true);


    oAjax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    oAjax.send();

    oAjax.onreadystatechange = function () {
        if (oAjax.readyState == 4) {
            if (oAjax.status == 200) {
                var data = JSON.parse(oAjax.responseText);
                var tbody = document.getElementById('tbody');
                for (var i = 0; i < data.result.length; i++) {
                    /*增加行*/
                    var showTr = document.createElement('tr');
                    tbody.appendChild(showTr);

                    for (var j = 0; j < 4; j++) {
                        var showTd = document.createElement('td');
                        showTd.innerHTML = "<td>" + data.result[i].name + "</td>";
                        var showTd1 = document.createElement('td');
                        showTd1.innerHTML = "<td>" + data.result[i].size + "</td>";
                        var showTd2 = document.createElement('td');
                        showTd2.innerHTML = "<td>" + data.result[i].extension + "</td>";
                        var showTd3 = document.createElement('td');
                        showTd3.innerHTML = "<td>" + data.result[i].open + "</td>";
                        var showTd4 = document.createElement('td');
                        showTd4.innerHTML = "<td><a href='" +
                            data.result[i].link + "'><button class='btn btn-success btn-sm'><i class='lnr lnr-download'></i></button></a></td>"
                    }
                    showTr.appendChild(showTd);
                    showTr.appendChild(showTd1);
                    showTr.appendChild(showTd2);
                    showTr.appendChild(showTd3);
                    showTr.appendChild(showTd4);

                }
            }
        } else {
            /*alert(oAjax.status);*/
        }
    }


}