<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/cliente-servico/cliente-servico.js"></script>

<script type="text/javascript">var url = "${pageContext.request.contextPath}";</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Cliente</h1>

<div>
    <form id="formClienteSalvar">
        <div class="row">

            <div class="col fltLeft wid50">
                <select id="cliente" name="cliente">
                    <option selected="false" value="0">Selecione o Cliente</option>
                    <c:forEach items="${clientes}" var="cliente">
                        <option value="${cliente.id}">
                                ${cliente.nome}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="col fltLeft wid50">
                <select id="servico" name="servico">
                    <option selected="false" value="0">Selecione o Serviço</option>
                    <c:forEach items="${servicos}" var="servico">
                        <option data-valor="${servico.valor}" value="${servico.id}">
                                ${servico.nome}
                        </option>
                    </c:forEach>
                </select>
                <input id="btnAddServico" type="button" value="Adicionar"/>
            </div>

            <div class="col fltLeft wid50"><td>
                <label name="dataInicial">Data Inicial</label>
                <input id="dataInicial" type="text" name="dataInicial"/>
            </div>


            <div class="col fltLeft wid50"><td>
                <label name="dataFinal">Data Final</label>
                <input id="dataFinal" type="text" name="dataFinal"/>
            </div>

            <div class="col fltLeft wid50">
                <table id="tbServicosCliente">
                    <thead>
                        <tr>
                            <th style="display: none">id</th>
                            <th>Nome</th>
                            <th>Data Início</th>
                            <th>Data Fim</th>
                            <th>Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>

            <div class="col fltLeft wid50">
                <input id="btnSalvarCliente" type="button" value="Salvar"/>
            </div>

        </div>
    </form>
</div>
</body>
</html>