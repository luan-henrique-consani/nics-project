<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadatro de endereços</title>
        <jsp:include page="header.jsp"></jsp:include>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    </head>
    <body>
        <form action="criar-endereco" enctype="multipart/form-data" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">Rua</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="Rua" placeholder="Rua" name="rua">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">numero</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="numero" placeholder="numero" name="numero">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">bairro</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="bairro" placeholder="bairro" name="bairro">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">estado</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="estado" placeholder="estado" name="estado">
            </div>
                        <div class="form-group">
                <label for="exampleInputEmail1">cep</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="cep" placeholder="cep" name="cep">
            </div>
             <input type="hidden" class="form-control" id="exampleInputEmail1" aria-describedby="idUsuario" value="${usuario.idUsuario}" name="idUsuario">

            <input type="submit" value="Enviar">
        </form>    
            <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
