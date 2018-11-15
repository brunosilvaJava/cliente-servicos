$(document).ready(function () {

    $('#btnSalvarCliente').on("click", function (e) {
        e.stopPropagation();

        var obj = new Object();
        obj.nome = $("#nomeCliente").val();
        obj.cpf = $("#cpfCLiente").val();
        obj.tipoDesconto = parseInt($("#tipoDesconto").val());

        $.ajax({
            url: url + "/api/clientes",
            type: 'POST',
            dataType: 'json',
            contentType: "application/json; charset=UTF-8",
            data: JSON.stringify(obj),
            success: function (retorno) {
                console.log(retorno);
            },
            error: function (xhr, textStatus, thrownError) {
                console.log(thrownError);
            }
        });

    });

    $('#btnAddServico').on("click", function () {

        var servico = $("#servico option:selected");
        var valor = parseFloat(servico.attr("data-valor"));
        var dataInicial = $("#dataInicial").val();
        var dataFinal = $("#dataFinal").val();

        $('#tbServicosCliente > tbody:last-child')
            .append('<tr>')
            .append('<td style="display: none">'+servico.val()+'</td>')
            .append('<td>'+servico.text()+'</td>')
            .append('<td>'+dataInicial+'</td>')
            .append('<td>'+dataFinal+'</td>')
            .append('<td>'+valor+'</td>')
            .append('</tr>');

    });



});

function toDate(textDate) {
    var values = $(textDate).val().split("/")
    return new Date(values[2], values[1] - 1, values[0])
}