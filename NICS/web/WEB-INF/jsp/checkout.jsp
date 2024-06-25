<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Checkout NICS</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
                    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                    crossorigin="anonymous">
                <link rel="stylesheet" href="styles/check.css">
                <jsp:include page="header.jsp"></jsp:include>
            </head>

            <body>
                <main>
                    <div class="content">
                        <div class="container">
                            <c:forEach items="${carrinho}" var="carrinhos">
                                <div class="card" style="width: 18rem;">
                                    <div class="img-area">
                                        <img class="card-img-top" src="data:image/png;base64,${carrinhos.imgBase64}"
                                            alt="${carrinhos.nomeProdutos}">
                                    </div>
                                    <div class="card-body">
                                        <h5 class="card-title">${carrinhos.nomeProdutos} x${carrinhos.quantidade}</h5>
                                        <fmt:setLocale value="pt-BR" />
                                        <p>
                                            <fmt:formatNumber value="${carrinhos.preco}" type="currency" />
                                        </p>
                                    </div>
                                    <form action="deletar" enctype="multipart/form-data" method="post">
                                        <input type="hidden" value="${carrinhos.idCarrinho}" name="idCarrinho">
                                        <td><button type="submit"><i class="fa-solid fa-trash"></i></button></td>
                                    </form>
                                </div>
                            </c:forEach>
                            <c:forEach items="${carrinho2}" var="carrinhos">
                                <fmt:setLocale value="pt-BR" />
                                <h3>Total:
                                    <fmt:formatNumber value="${carrinhos.preco}" type="currency" />
                                </h3>
                            </c:forEach>
                        </div>


                        <hr class="mb-4">
                        <div class="pagamento">
                            <h4 class="mb-3">Pagamento</h4>

                            <div class="d-block my-3">
                                <div class="custom-control custom-radio">
                                    <input id="credit" name="paymentMethod" type="radio" class="custom-control-input"
                                        required>
                                    <label class="custom-control-label" for="credit">Cartão de crédito</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input id="debit" name="paymentMethod" type="radio" class="custom-control-input"
                                        required>
                                    <label class="custom-control-label" for="debit">Cartão de débito</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input id="pix" name="paymentMethod" type="radio" class="custom-control-input"
                                        required>
                                    <label class="custom-control-label" for="pix">Pix</label>
                                </div>
                            </div>
                            <div class="none credito">
                                <div class="row">
                                    <div class="col-md-6 mb-3">
                                        <label for="cc-name">Nome no cartão</label>
                                        <input type="text" class="form-control" id="cc-name" placeholder="" required>
                                        <small class="text-muted">Nome completo</small>
                                        <div class="invalid-feedback">
                                            o nome e requisitado
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label for="cc-number">Número do cartão de crédito</label>
                                        <input type="text" class="form-control" id="cc-number" placeholder="" required>
                                        <div class="invalid-feedback">
                                            Número do cartão de crédito é requisitado
                                        </div>
                                    </div>
                                </div>
                                <div class="row data">
                                    <div class="col-md-3 mb-3">
                                        <label for="cc-expiration">Expiração</label>
                                        <input type="month" class="form-control" id="cc-expiration" placeholder=""
                                            required>
                                        <div class="invalid-feedback">
                                            Data de expiração requisitada
                                        </div>
                                    </div>
                                    <div class="col-md-3 mb-3">
                                        <label for="cc-expiration">CVV</label>
                                        <input type="text" class="form-control" id="cc-cvv" placeholder="" required>
                                        <div class="invalid-feedback">
                                            CVV requisitado
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="none debito">
                                <div class="row">
                                    <div class="col-md-6 mb-3">
                                        <label for="cc-name">Nome no cartão</label>
                                        <input type="text" class="form-control" id="cc-name" placeholder="" required>
                                        <small class="text-muted">Nome completo</small>
                                        <div class="invalid-feedback">
                                            o nome e requisitado
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label for="cc-number">Número do cartão de débito</label>
                                        <input type="text" class="form-control" id="cc-number-debit" placeholder="" required>
                                        <div class="invalid-feedback">
                                            Número do cartão de débito é requisitado
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3 mb-3">
                                        <label for="cc-expiration">Expiração</label>
                                        <input type="month" class="form-control" id="cc-expiration" placeholder=""
                                            required>
                                        <div class="invalid-feedback">
                                            Data de expiração requisitada
                                        </div>
                                    </div>
                                    <div class="col-md-3 mb-3">
                                        <label for="cc-expiration">CVV</label>
                                        <input type="text" class="form-control" id="cc-cvv-debit" placeholder="" required>
                                        <div class="invalid-feedback">
                                            CVV requisitado
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="none pix">
                                <img src="assets/pix.png" alt="">
                            </div>
                            <hr class="mb-4">
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Finalizar</button>
                        </div>
                    </div>
                </main>
                <script src="js/pagamento.js"></script>
                <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js"></script>
                <script src="js/mask-check.js"></script>
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

                    <jsp:include page="footer.jsp"></jsp:include>
            </body>

            </html>