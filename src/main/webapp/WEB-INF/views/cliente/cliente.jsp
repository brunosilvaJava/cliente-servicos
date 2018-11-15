<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/cliente/cliente.js"></script>

<script type="text/javascript">var url = "${pageContext.request.contextPath}";</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <h1>Cliente</h1>

    <div class="row">
        <form id="formClienteSalvar">
            <div class="col fltLeft wid100"><td>
                <label name="nome">Name</label>
                <input id="nomeCliente" type="text" name="nome"/>
            </div>
            <div class="col wid50"><td>
                <label name="cpf">CPF</label>
                <input id="cpfCLiente" type="text" name="cpf"/>
            </div>
            <div class="col fltLeft wid50">
                <select id="tipoDesconto" name="tipoDesconto">
                    <option value="0">Selecione um Tipo de Desconto</option>
                    <c:forEach items="${tiposDesconto}" var="tipoDesconto">
                        <option value="${tipoDesconto.tipo}">
                            ${tipoDesconto.nome}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="col fltLeft wid50">
                <input id="btnSalvarCliente" type="button" value="Salvar"/>
            </div>
        </form>
    </div>

    <div class="row">
        <div class="col fltLeft wid50">
            <table id="tbClientes">
                <thead>
                <tr>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Tipo Desconto</th>
                    <th>Serviços</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${clientes}" var="cliente">
                    <tr>
                        <td>${cliente.nome}</td>
                        <td>${cliente.cpf}</td>
                        <td>${cliente.tipoDesconto.nome}</td>
                        <td><input type="button" onclick="getServicosByCliente(${cliente.id})" value="O"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="col fltLeft wid50">
            <table id="tbServicosCliente">
                <thead>
                <tr>
                    <th>Serviço</th>
                    <th>Data Início</th>
                    <th>Data Fim</th>
                    <th>Dias Restantes</th>
                    <th>Valor</th>
                    <th>Data Pagamento</th>
                    <th>Efetuar Pagamento</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>