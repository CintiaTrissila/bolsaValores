<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transacoes</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>Transações</h2>
   <hr />

   <input type="button" value="Novo Monitoramento"
    onclick="window.location.href='showForm'; return false;"
    class="btn btn-primary" />
    <br/><br/>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Transações</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>Empresa</th>
       <th>Conta</th>
       <th>Data</th>
       <th>Tipo</th>
       <th>Valor</th>
       <th>Quantidade</th>
      </tr>

      <c:forEach var="tempTransacao" items="${transacoes}">
       <tr>
        <td>${tempTransacao.empresa.nome}</td>
        <td>${tempTransacao.conta.email}</td>
        <td>${tempTransacao.data}</td>
        <td>${tempTransacao.tipoTransacao}</td>
        <td>${tempTransacao.valor}</td>
        <td>${tempTransacao.quantidadeAcoes}</td>
       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
</body>
</html>