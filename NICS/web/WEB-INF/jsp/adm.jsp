<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <!DOCTYPE html>

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/adm.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
      rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
      href="https://fonts.googleapis.com/css2?family=Bungee+Shade&family=Rubik:ital,wght@0,300..900;1,300..900&display=swap"
      rel="stylesheet">
      <title>adm pages</title>
  </head>

  <body>
    <nav class="sidebar close">
      <header>

        <div class="text logo-text">
          <span class="name">NICS</span>

        </div>

        <i class="fa-solid fa-arrow-right toggle"></i>
      </header>

      <div class="menu-bar">
        <div class="menu">
          <ul class="menu-links">
            <li class="nav-link">
              <a href="./home">
                <i class="fa-solid fa-house icon"></i>
                <span class="text nav-text">Home</span>
              </a>
            </li>
            <li class="nav-link">
              <a href="#">
                <i class="fa-regular fa-user icon"></i>
                <span class="text nav-text">Usuários</span>
              </a>
            </li>

            <li class="nav-link">
              <a href="#">
                <i class="fa-solid fa-boxes-stacked icon"></i>
                <span class="text nav-text">Estoque</span>
              </a>
            </li>

            <li class="nav-link">
              <a href="#">
                <i class="fa-solid fa-layer-group icon"></i>
                <span class="text nav-text">Categorias</span>
              </a>
            </li>
            <li class="nav-link">
              <a href="#">
                <i class="fa-solid fa-basket-shopping icon"></i>
                <span class="text nav-text">Produtos</span>
              </a>
            </li>

        <li class="nav-link">
          <a href="./cad-usu">
            <i class="fa-solid fa-right-from-bracket icon"></i>
            <span class="text nav-text">logout</span>
          </a>
        </li>
      </ul>
    </div>




        </div>
      </div>

    </nav>

    <section class="home usuarios">
      <h3>usuarios</h3>
    </section>
    <section class="home estoque">
      <h3>estoque</h3>
    </section>
    <section class="home categorias">
      <h3>categorias</h3>
    </section>
    <section class="home produtos">
      <h3>produtos</h3>
    </section>

    <script>
      const body = document.querySelector('body'),
        sidebar = body.querySelector('nav'),
        toggle = body.querySelector(".toggle"),
        searchBtn = body.querySelector(".search-box"),
        modeSwitch = body.querySelector(".toggle-switch"),
        modeText = body.querySelector(".mode-text");
      toggle.addEventListener("click", () => {
        sidebar.classList.toggle("close");
      })
      searchBtn.addEventListener("click", () => {
        sidebar.classList.remove("close");
      })

    </script>
    <script src="https://kit.fontawesome.com/560340c572.js" crossorigin="anonymous"></script>

  </body>

  </html>