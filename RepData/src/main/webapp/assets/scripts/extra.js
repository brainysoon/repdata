function onShow() {
    var tbody = document.getElementById("tbody");
    ajax('TAA.json', function (str) {
        var str = str;

        var oJson = (new Function('return (' + str + ')'))();

        var a = oJson['show'];

        for (var i = 0; i < a.length; i++) {
            var showTr = document.createElement('tr');
            showTr.id = 'newTr';
            tbody.appendChild(showTr);

            for (var j = 0; j < 4; j++) {
                var showTd = document.createElement('td');
                showTd.innerHTML = "<td>" + a[i]['name'] + "</td>";
                var showTd1 = document.createElement('td');
                showTd1.innerHTML = "<td>" + a[i]['size'] + "</td>";
                var showTd2 = document.createElement('td');
                showTd2.innerHTML = "<td>" + a[i]['extension'] + "</td>";
                var showTd3 = document.createElement('td');
                showTd3.innerHTML = "<td>" + a[i]['open'] + "</td>";
                var showTd4 = document.createElement('td');
                showTd4.innerHTML = "<td><a href='" +
                    a[i]['link'] + "'><button class='btn btn-success btn-sm'><i class='lnr lnr-download'></i></button></a></td>"

            }

            showTr.appendChild(showTd);
            showTr.appendChild(showTd1);
            showTr.appendChild(showTd2);
            showTr.appendChild(showTd3);
            showTr.appendChild(showTd4);


        }
    })
}