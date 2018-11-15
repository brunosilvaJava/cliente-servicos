$(document).ready(function () {

    var servicos = [];

    $('#btnSalvarServicoCliente').on("click", function (e) {
        e.stopPropagation();

        $.ajax({
            url: url + "/api/clientes/"+$("#cliente option:selected").val()+"/servicos/",
            type: 'POST',
            contentType: "application/json; charset=UTF-8",
            data: JSON.stringify(servicos),
            success: function (retorno) {
                servicos = [];
                $('#tbServicosCliente > tbody').html("");
            },
            error: function (xhr, textStatus, thrownError) {
                console.log(thrownError);
            }
        });



    });

    $('#btnAddServico').on("click", function () {

        var clienteObj = new Object();
        clienteObj.id = $("#cliente option:selected").val();

        var servicoObj = new Object();
        var servico = $("#servico option:selected");
        servicoObj.id = servico.val();

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

        var clienteServico = new Object();
        clienteServico.cliente = clienteObj;
        clienteServico.servico = servicoObj;
        clienteServico.dataInicio = new Date(dataInicial);
        clienteServico.dataFim = new Date(dataFinal);
        clienteServico.valor = valor;

        servicos.push(clienteServico);

    });

});