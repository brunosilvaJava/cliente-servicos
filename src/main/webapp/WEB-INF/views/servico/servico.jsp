<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/servico/servico.js"></script>

<script type="text/javascript">var url = "${pageContext.request.contextPath}";</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Serviço</h1>

<div>
    <form id="formClienteSalvar">
        <div class="row">
            <div class="col fltLeft wid50"><td>
                <label name="descricao">Descricao</label>
                <input id="nomeServico" type="text" name="servico"/>
            </div>
            <div class="col fltLeft wid50"><td>
                <label name="valor">Valor</label>
                <input id="valorServico" type="text" name="valor"/>
            </div>
            <div class="col fltLeft wid50">
                <input id="btnSalvarServico" type="button" value="Salvar"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>