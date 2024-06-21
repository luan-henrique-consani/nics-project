<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">

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
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
      <link rel="stylesheet" href="styles/adm.css">
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
              <li class="nav-link" id="usuBtn">
                <a href="#">
                  <i class="fa-regular fa-user icon"></i>
                  <span class="text nav-text">Usuários</span>
                </a>
              </li>
              <li class="nav-link" id="proBtn">
                <a href="#">
                  <i class="fa-solid fa-basket-shopping icon"></i>
                  <span class="text nav-text">Produtos</span>
                </a>
              </li>
              <li class="nav-link" id="catBtn">
                <a href="#">
                  <i class="fa-solid fa-layer-group icon"></i>
                  <span class="text nav-text">Categorias</span>
                </a>
              </li>
              <li class="nav-link" id="estBtn">
                <a href="#">
                  <i class="fa-solid fa-boxes-stacked icon"></i>
                  <span class="text nav-text">Estoque</span>
                </a>
              </li>

              <li class="nav-link">
                <a href="./logar-usu">
                  <i class="fa-solid fa-right-from-bracket icon"></i>
                  <span class="text nav-text">logout</span>
                </a>
              </li>
            </ul>
          </div>




        </div>
        </div>

      </nav>

      <section class="none usuarios home">
        <h3>usuarios</h3>
      </section>
      <section class="none estoque ">
        <h3>estoque</h3>
      </section>
      <section class="none categorias">
        <h3>categorias</h3>
      </section>
      <section class="none produtos">
        <h3>produtos</h3>

        <div class="container">
          <div class="listagem">
            <table class="table">
              <thead class="thead-dark">
                <tr>
                  <th scope="col">id</th>
                  <th scope="col">nome</th>
                  <th scope="col">preco</th>
                  <th scope="col">quantidade</th>
                  <th scope="col">variacao</th>
                  <th scope="col"></th>
                </tr>
              </thead>
              <div class="tabelacorpo">
                <tbody>

                  <c:forEach items="${produto}" var="produtos">
                    <tr>
                      <th scope="col">${produtos.idProdutos}</th>
                      <td id="prtValue">${produtos.nomeProdutos}</td>
                      <td id="preValue">${produtos.preco}</td>
                      <c:forEach items="${estoque}" var="estoques">
                        <td id="qtdValue">${estoques.quantidade}</td>
                        <td id="varValue">${estoques.variacao}</td>
                      </c:forEach>
                      <form action="deletar" enctype="multipart/form-data" method="post">
                        <input type="hidden" value="${produtos.idProdutos}" name="id">
                        <td><button type="submit"><i class="fa-solid fa-trash"></i></button></td>
                      </form>
                    </tr>
                  </c:forEach>
                </tbody>
              </div>
            </table>
          </div>
          <div class="formulario">
            <form action="criar" enctype="multipart/form-data" method="post">
              <div class="form-group">
                <label for="exampleInputEmail1">Nome produto</label>
                <input type="text" class="form-control" id="nomePrt" aria-describedby="emailHelp"
                  placeholder="Nome produto" name="nome" value="">
              </div>
              <div class="form-group">
                <label for="exampleInputEmail1">Preço</label>
                <input type="text" class="form-control" id="precoPrt" aria-describedby="emailHelp" placeholder="Preço"
                  name="preco">
              </div>
              <div class="form-group">
                <label for="exampleInputEmail1">Quantidade</label>
                <input type="text" class="form-control" id="qtdPrt" aria-describedby="emailHelp"
                  placeholder="Quantidade" name="qtd">
              </div>
              <div class="form-group">
                <label for="exampleInputEmail1">Variação</label>
                <input type="text" class="form-control" id="varPrt" aria-describedby="emailHelp"
                  placeholder="Variação" name="var">
              </div>
              <div class="form-group">
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
          </div>
        </div>
      </section>
      <script src="js/onclick.js"></script>
      <script src="js/editar.js"></script>
      <script src="js/sidebar.js"></script>
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

      <script src="https://kit.fontawesome.com/560340c572.js" crossorigin="anonymous"></script>

    </body>

    </html>