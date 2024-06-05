<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>header</title>
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Bungee+Shade&display=swap" rel="stylesheet">
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link
                href="https://fonts.googleapis.com/css2?family=Bungee+Shade&family=Rubik:ital,wght@0,300..900;1,300..900&display=swap"
                rel="stylesheet">
            <link rel="stylesheet" href="styles/header.css">
        </head>

        <body>
            <header>
                <div class="cima">
                    <a href="./home"><i class="fa-solid fa-house"></i></a> 
                    <h1>NICS</h1>
                    <div class="pesquisa">
                        <form action="achar" enctype="multipart/form-data" method="post">
                            <input type="text" name="pesquisar" id="pesquisar" placeholder="Pesquise aqui...">
                            <button type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                        </form>
                    </div>
                    <a href="./carrinho"><i class="fa-solid fa-cart-shopping"></i></a>
                    <a href="./cad-usu"><i class="fa-regular fa-user"></i></a>
                </div>
                <div class="baixo">
                    <ul>
                        <c:forEach items="${categoria}" var="categorias">
                            <li><a href="./cate?id=${categorias.iCategoria}">${categorias.nomeCategoria}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </header>
            <script src="https://kit.fontawesome.com/560340c572.js" crossorigin="anonymous"></script>
        </body>

        </html>