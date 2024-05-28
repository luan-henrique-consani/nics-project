<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadatro de produtos</title>
    </head>
    <body>
        <form action="criar" enctype="multipart/form-data" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">Nome produto</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nome produto" name="nome">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Preço</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Preço" name="preco">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Quantidade</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Quantidade" name="qtd">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Variação</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Variação" name="var">
            </div>
            <div class="form-group">
                <label for="exampleFormControlFile1">Exemplo de input de arquivo</label>
                <input type="file" class="form-control-file" id="exampleFormControlFile1 imagem" name="imagem">
            </div>
            <select class="custom-select" name="cat">
                <option selected>Escolha...</option>
                <c:forEach items="${categoria}" var="categorias">
                    <option value="${categorias.iCategoria}">${categorias.nomeCategoria}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Enviar">
        </form>    
    </body>
</html>
