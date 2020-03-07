<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">


<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../js/patrimonioController.js"></script>

<meta charset="ISO-8859-1">
<title>Patrimonio</title>

<script>
function acao(acao,id,descricao,localizacao){
	document.getElementById("action").value = acao;
	document.getElementById("id").value = id;
	document.getElementById("descricao").value = descricao;
	document.getElementById("localizacao").value = localizacao;
	document.getElementById('lista').submit();
}
</script>



</head>
<body>

	<jsp:include page="templates/header.jsp"></jsp:include>

<form id="lista" class="form-horizontal" action="<c:url value='/PatrSrv'/>" method="post" >
<input type="hidden" name="action" id="action">
<input type="hidden" name="id" id="id">
<input type="hidden" name="descricao" id="descricao">
<input type="hidden" name="localizacao" id="localizacao">
<div class="container">
	<div class="row col-md-6 col-md-offset-2 custyle">
		<table class="table table-striped custab">
			<thead>
			<a href="<c:url value='pages/patrimonio.jsp' />" class="btn btn-primary btn-xs pull-right"><b>+</b> Adicionar novo patrimônio</a>
		    <tr>
		        <th>ID</th>
		        <th>Descrição</th>
		        <th>Localização</th>
		        <th class="text-center">Action</th>
		    </tr>
			</thead>
			<c:forEach var="patrimonio" items="${lista_patrimonios}" >
			
			<tr>
			    <td>${patrimonio.id}</td>
			    <td>${patrimonio.descricao}</td>
			    <td>${patrimonio.localizacao}</td>
			    <td class="text-center">
		    	<a class='btn btn-info btn-xs' onclick="acao('alterar','${patrimonio.id}','${patrimonio.descricao}','${patrimonio.localizacao}')"><span class="glyphicon glyphicon-edit"></span> Editar</a> 
		    	<a class='btn btn-danger btn-xs' onclick="acao('deletar','${patrimonio.id}')" ><span class="glyphicon glyphicon-remove"></span> Excluir</a>
		     	</td>
		  	</tr>  

		    </c:forEach>    
		 
	  </table>
  </div>
</div>
</form>
</body>
</html>