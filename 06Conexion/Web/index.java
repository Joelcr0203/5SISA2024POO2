<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Mi primera Conexion</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <form name="formulario" 
                  action="Registro"
                  method="post"    >
                <label>Nombre: </label>
                <br>
                <input type="text" 
                       name="nombre" >
                <br>
                <label>Apellido Paterno: </label>
                <br>
                <input type="text" 
                       name="appat" >
                <br>
                <label>Apellido materno: </label>
                <br>
                <input type="text" 
                       name="apmat" >
                <br>
                <label>Edad: </label>
                <br>
                <input type="text" 
                       name="edad" >
                <br>
                <input type="submit" name="enviar"
                       value="Registrar Alumno">
                <input type="reset" name="borrar"
                       value="Borrar Datos">
            </form>
            
            <br>
            
            <a href="Consultar" >Consultar Lista</a>
        </div>
    </body>
</html>