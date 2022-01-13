<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Contas</title>
</head>
<body>

	<h3>Cadastrar Conta</h3>

	<form action="adicionaConta" method="POST">
		<label for="descricao">Descrição</label>
		<textarea id="descricao" name="descricao" rows="5" cols="100"></textarea>
		<br/>
		
		<label for="Valor">Valor</label>
		<input id="valor" type="text" name="valor"/>
		<br/>
		
		<label for="tipo">Tipo</label>
		<select id="tipo" name="tipo">
			<option value="ENTRADA">Entrada</option>
			<option value="SAIDA">Saida</option>
		</select>
		
		<br/><br/>
		
		<input type="submit" value="Adicionar"/>
	</form>

</body>
</html>