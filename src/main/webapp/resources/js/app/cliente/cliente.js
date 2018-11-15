$(document).ready(function () {

    $('#btnSalvarCliente').on("click", function (e) {
        e.stopPropagation();

        $('#tbServicosCliente > tbody').html("");

        var obj= new Object();
        obj.nome = $("#nomeCliente").val();
        obj.cpf = $("#cpfCLiente").val();
        obj.tipoDesconto = parseInt($("#tipoDesconto").val());

        $.ajax({
            url: url + "/api/clientes",
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(obj),
            success: function (retorno) {
                getClientes();
            },
            error: function (xhr, textStatus, thrownError) {
                console.log(thrownError);
            }
        });

    });

});

function getClientes() {

    $('#tbClientes > tbody').html("");

    $.ajax({
        url: url + "/api/clientes/",
        type: 'GET',
        dataType: 'json',
        success: function (clientes) {

            $.each(clientes, function(index, cliente) {
                $('#tbClientes > tbody:last-child')
                    .append('<tr><td style="display: none">'+cliente.id+'</td>')
                    .append('<td>'+cliente.nome+'</td>')
                    .append('<td>'+cliente.cpf+'</td>')
                    .append('<td>'+cliente.tipoDesconto.nome+'</td>')
                    .append('<input type="button" onclick="getServicosByCliente('+cliente.id+')" value="O"/>')
            });

        },
        error: function (xhr, textStatus, thrownError) {
            console.log(thrownError);
        }
    });

}

function getServicosByCliente(idCliente) {

    $('#tbServicosCliente > tbody').html("");

    $.ajax({
        url: url + "/api/clientes/"+idCliente+"/servicos/",
        type: 'GET',
        dataType: 'json',
        success: function (servicos) {

            $.each(servicos, function(index, servico) {
                $('#tbServicosCliente > tbody:last-child')
                    .append('<tr>')
                    .append('<td>'+servico.servico+'</td>')
                    .append('<td>'+servico.dataInicio+'</td>')
                    .append('<td>'+servico.dataFim+'</td>')
                    .append('<td>'+servico.diasRestantes+'</td>')
                    .append('<td>'+servico.valor+'</td>')
                    .append('<td>'+servico.dataPagamento+'</td>')
                    .append('<td><input type="button" onclick="efetuarPagamento('+idCliente+', '+servico.idServico+')" value="O"/></td>')
                    .append('</tr>');
            });

            /**/

        },
        error: function (xhr, textStatus, thrownError) {
            console.log(thrownError);
        }
    });

}

function efetuarPagamento(idCliente, idClienteServico){

    $.ajax({
        url: url + "/api/clientes/"+idCliente+"/servicos/"+idClienteServico+"/pagamentos",
        type: 'POST',
        success: function () {
            getServicosByCliente(idCliente);
        },
        error: function (xhr, textStatus, thrownError) {
            console.log(thrownError);
        }
    });


}