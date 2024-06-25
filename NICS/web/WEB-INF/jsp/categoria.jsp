<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NICS</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <jsp:include page="header.jsp"></jsp:include>
            <link rel="stylesheet" href="styles/index.css">
        </head>

        <body>
        <main>
            <div class="container">
            <c:forEach items="${produto}" var="produtos">
                <div class="card" style="width: 18rem;">
                    <div class="img-area">
                        <img class="card-img-top" src="data:image/png;base64,${produtos.imgBase64}"
                             alt="${produtos.nomeProdutos}">
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">${produtos.nomeProdutos}</h5>
                        <fmt:setLocale value="pt-BR"/>
                        <p><fmt:formatNumber value="${produtos.preco}" type="currency"/></p>
                        <a href="./produtoUni?id=${produtos.idProdutos}" class="btn btn-primary">Visitar</a>
                    </div>
                </div>
            </c:forEach>
        </div>


    </main>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
    crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
    crossorigin="anonymous"></script>
    <jsp:include page="footer.jsp"></jsp:include>
</body>

</html>