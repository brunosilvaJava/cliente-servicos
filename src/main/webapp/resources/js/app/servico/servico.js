$(document).ready(function () {

    $('#btnSalvarServico').on("click", function (e) {
        e.stopPropagation();

        var obj= new Object();
        obj.nome = $("#nomeServico").val();
        obj.valor = parseFloat($("#valorServico").val());

        $.ajax({
            url: url + "/api/servicos",
            type: 'POST',
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(obj),
            success: function (retorno) {
                console.log(retorno);
            },
            error: function (xhr, textStatus, thrownError) {
                console.log(thrownError);
            }
        });

    });

});
