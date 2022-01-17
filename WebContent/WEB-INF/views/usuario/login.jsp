<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>


	<form action="efetuaLogin" method="POST">
		<label for="login">Login:</label>
		<input type="text" name="login"/>
		<br/>
		
		<label for="senha">Senha:</label>
		<input type="password" name="senha"/>
		
		<input type="submit" value="entrar"/>
	</form>

</body>
</html>