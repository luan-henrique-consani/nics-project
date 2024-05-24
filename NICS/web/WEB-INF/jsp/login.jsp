<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,300..900;1,300..900&display=swap"
            rel="stylesheet">
        <title>JSP Page</title>
    </head>

    <body>
        <div class="container">
            <img src="assets/1.png" alt="logo">
            <div class="content">
                <form action="log-usu" enctype="multipart/form-data" method="post">
                    <div class="email">
                        <i class="fa-solid fa-envelope"></i>
                        <input type="email" placeholder="Seu email..." name="email">
                    </div>
                    <div class="senha">
                        <i class="fa-solid fa-lock"></i>
                        <input type="password" placeholder="Seu senha..." name="senha">
                    </div>
                    <input type="submit" value="Logar">
                </form>
                <p>Você não tem uma conta?<a href="./cad-usu">Cadastrar</a></p>
            </div>
        </div>
    </body>

    </html>