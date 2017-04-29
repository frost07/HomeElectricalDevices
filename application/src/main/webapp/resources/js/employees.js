$(document).ready(function () {


    $('.js-action-reset-salary').on('click', function () {
        var self = $(this);
        var keyValue = self.attr('data-employee-key');
        $.ajax(location.href, {
            method: 'post',
            data: {key: keyValue},
            success: function (result) {
                //var newData = JSON.parse(result);
                var newData = $.parseJSON(result);
                Object.keys(newData).forEach(function (key) {
                    var value = newData[key];
                    // jquery selectors
                    self.closest('tr').children('td[data-name=' + key + ']').text(value);
                });
            }
        });
    });

    $('.resultSearch').on('click', function () {
        var minValue = document.getElementById("min").value;
        var maxValue = document.getElementById("max").value;
       // var loc=location.href;
        $.ajax(location.href, {

            method: 'post',
            data: {min: minValue, max: maxValue},
            success: function () {
                   // document.location.replace("http://localhost:8080/test");
                document.location.href = "../test";
            },
        });
    });

    $('.return').on('click', function () {
                document.location.href = "../employees";
    });

    $('#employees').DataTable();
});

