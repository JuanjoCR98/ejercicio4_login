<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <center>
            <h1>LOGIN</h1>
            <form action="servletLogin">
                <label>Usuario </label><br><input type="text" name="usuario"><br/>
                <label>Contraseña </label><br><input type="password" name="password"><br/><br><br>
                <input type="submit" value="Login">
            </form>
        </center> 
    </body>
</html>
