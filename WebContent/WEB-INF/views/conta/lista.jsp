<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista de Contas</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('table tr td #btnPagar').on('click', function(event){
				event.preventDefault();
				var btnPagar = $(event.currentTarget);
				var urlRequest = btnPagar.attr('href');

				console.log('url request', urlRequest);

				$.ajax({
					url: urlRequest,
					method: 'GET',
					success: function(dados){
						console.log('dados', dados);
						if(dados === 'Pago'){
							var spanPago = $('table tr td span#pago');
							console.log('acessou pago', spanPago);
							spanPago.html(dados);
						}else{
							var spanNPago = $('table tr td span#nPago');
							console.log('acessou não pago', spanNPago);
							spanNPago.html(dados);
						}
					},
					fail: function(dados){
						alert('Erro ao pagar a conta!');
					},
				});
			});
		});
	</script>
</head>
<body>
	
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Descrição</th>
				<th>Valor</th>
				<th>Tipo</th>
				<th>Paga</th>
				<th>Data de Pagamento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaContas}" var="conta">
				<tr>
					<td>${conta.id}</td>
					<td>${conta.descricao}</td>
					<td>${conta.valor}</td>
					<td>${conta.tipo}</td>
					<td>
						<c:if test="${conta.paga eq false}">
							<span id="nPago">Não pago</span>
						</c:if>
						<c:if test="${conta.paga eq true}">
							<span id="pago">Pago</span>
						</c:if>
					</td>
					<td>
						<fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy"/>
					</td>
					<td>
						<a href="exclui?id=${conta.id}">Excluir</a>
						<c:if test="${conta.paga eq false}">
							<a id="btnPagar" href="pagarConta?id=${conta.id}">Pagar</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>