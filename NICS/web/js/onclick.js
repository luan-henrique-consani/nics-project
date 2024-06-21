const usuario = document.querySelector(".usuarios");
const produtos = document.querySelector(".produtos");
const estoque = document.querySelector(".estoque");
const categoria = document.querySelector(".categorias");

const usuBtn = document.querySelector("#usuBtn");
const proBtn = document.querySelector("#proBtn");
const catBtn = document.querySelector("#catBtn");
const estBtn = document.querySelector("#estBtn");

usuBtn.addEventListener("click", () =>{
    usuario.classList.add("home");
    produtos.classList.remove("home");
    estoque.classList.remove("home");
    categoria.classList.remove("home");
});
proBtn.addEventListener("click", () =>{
    usuario.classList.remove("home");
    produtos.classList.add("home");
    estoque.classList.remove("home");
    categoria.classList.remove("home");
});
catBtn.addEventListener("click", () =>{
    usuario.classList.remove("home");
    produtos.classList.remove("home");
    estoque.classList.remove("home");
    categoria.classList.add("home");
});
estBtn.addEventListener("click", () =>{
    usuario.classList.remove("home");
    produtos.classList.remove("home");
    estoque.classList.add("home");
    categoria.classList.remove("home");
});



