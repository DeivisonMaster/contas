<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Contas</title>
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
							Não pago
						</c:if>
						<c:if test="${conta.paga eq true}">
							Pago
						</c:if>
					</td>
					<td>
						<fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy"/>
					</td>
					<td>
						<a href="exclui?id=${conta.id}">Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>