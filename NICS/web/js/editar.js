const prt = document.querySelector(".prtValue");
const pre = document.querySelector(".preValue");
const qtd = document.querySelector(".qtdValue");
const vari = document.querySelector(".varValue");


function passar(idProduto){
    document.querySelector("#nomePrt").value = prt.textContent;
    document.querySelector("#precoPrt").value = pre.textContent;
    document.querySelector("#qtdPrt").value = qtd.textContent;
    document.querySelector("#varPrt").value = vari.textContent; 

}

const linhaSel = document.getElementsByClassName("linha-contagem");

console.log(linhaSel.length);
for(let i = 0; i < linhaSel.length; i++) {
    linhaSel[i].addEventListener("click", function() {
        const idProduto = this.getAttribute("data-idproduto");

        passar(idProduto);
    });
}