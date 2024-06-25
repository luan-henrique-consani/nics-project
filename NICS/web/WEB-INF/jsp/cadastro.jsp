<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,300..900;1,300..900&display=swap"
            rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Bungee+Shade&family=Rubik:ital,wght@0,300..900;1,300..900&display=swap"
            rel="stylesheet">
        <link rel="stylesheet" href="styles/cadastro.css">
        <title>NICS</title>
    </head>

    <body>
        <div class="container">
             <img src="assets/nics.png" alt="logo">
            <div class="content">
                <h2>NICS
                </h2>
                <p>Bem-vindo faça uma conta!</p>
                <form action="criar-usu" enctype="multipart/form-data" method="post">
                    <div class="nome">
                        <i class="fa-solid fa-user"></i>
                        <input type="text" placeholder="Seu nome..." name="nome">
                    </div>
                    <div class="email">
                        <i class="fa-solid fa-envelope"></i>
                        <input type="email" placeholder="Seu email..." name="email">
                    </div>
                    <div class="senha">
                        <i class="fa-solid fa-lock"></i>
                        <input type="password" placeholder="Sua senha..." name="senha" minlength="8" maxlength="45"  pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$])[a-zA-Z0-9@#$]{8,45}$"
                               title="Deve conter pelo menos um número e uma letra maiúscula, minúscula e caracteres especiais(!@#$... ) e pelo menos 8 caracteres">
                        
                    </div>
                    <div class="cpf">
                        <i class="fa-solid fa-id-card"></i>
                        <input type="text" placeholder="000.000.000-00" name="cpf" id="cpf" pattern="([0-9]{3}).([0-9]{3}).([0-9]{3})-([0-9]{2})">
                    </div>
                    <div class="telefone">
                        <i class="fa-solid fa-phone"></i>
                        <input type="text" placeholder="(00)00000-0000" name="telefone" id="telefone" pattern="(\([0-9]{2}\)) ([0-9]{5})-([0-9]{4})" minlength="14">
                    </div>
                    <input type="submit" value="Cadastrar-se" class="btn">
                </form>
                <p class="levar">Você já tem uma conta?<a href="./logar-usu">Logar</a></p>
            </div>
        </div>
        <script src="https://kit.fontawesome.com/560340c572.js" crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js"></script>
    <script src="js/mask.js"></script>
    </body>

    </html>