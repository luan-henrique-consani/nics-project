const prt = document.querySelector("#prtValue");
const pre = document.querySelector("#preValue");
const qtd = document.querySelector("#qtdValue");
const vari = document.querySelector("#varValue");

prt.addEventListener("click", () =>{
    document.querySelector("#nomePrt").value = prt.textContent;
    document.querySelector("#precoPrt").value = pre.textContent;
    document.querySelector("#qtdPrt").value = qtd.textContent;
    document.querySelector("#varPrt").value = vari.textContent; 
});