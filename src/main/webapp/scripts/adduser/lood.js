$(document).ready(function () {
    loadDataToTable();
});

function loadDataToTable() {
    let json = $.ajax({
        url: session.context + "/RCD/getall",
        contentType: "application/json;charset=UTF-8",
        headers: {Accept: "application/json;charset=UTF-8"},
        type: "GET",
        async: false
    }).done(function () {
    }).responseText;
    console.log(json);
    json = JSON.parse(json);
    console.log(json);
    $('#tbody').empty();
    if (json.length > 0) {
        for (let x of json) {
            $('#tbody').append('' +
                '<tr>' +
                '<td class="text-center">' + x.id + '</td>' +
                '<td> ' + x.userId + '</td>' +
                '</td>' +
                '</tr>'
            );
        }
    } else {
        $('#tbody').append('<tr><td style="text-align: center;" colspan="5">No data.</td></tr>');
    }
}

