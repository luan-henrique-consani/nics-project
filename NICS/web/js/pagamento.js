const cre = document.querySelector(".credito");
const deb = document.querySelector(".debito");
const pix = document.querySelector(".pix")

const btnCre = document.getElementById("credit");

const btnDeb = document.getElementById("debit");

const btnPix = document.getElementById("pix");

const submitBtn = document.querySelector(".btn")

btnCre.addEventListener("click", ()=>{
    cre.classList.add("block");
    deb.classList.remove("block");
    pix.classList.remove("block");
});
btnDeb.addEventListener("click", ()=>{
    cre.classList.remove("block");
    deb.classList.add("block");
    pix.classList.remove("block");
});
btnPix.addEventListener("click", ()=>{
    cre.classList.remove("block");
    deb.classList.remove("block");
    pix.classList.add("block");
});

submitBtn.addEventListener('click', () => {
    const paymentMethod = document.querySelector('input[name="paymentMethod"]:checked').id;
    let valid = true;

    if (paymentMethod === 'credit') {
        valid = document.getElementById('cc-name').value &&
            document.getElementById('cc-number').value &&
            document.getElementById('cc-expiration').value &&
            document.getElementById('cc-cvv').value;
    } else if (paymentMethod === 'debit') {
        valid = document.getElementById('cc-name-debit').value &&
            document.getElementById('cc-number-debit').value &&
            document.getElementById('cc-expiration-debit').value &&
            document.getElementById('cc-cvv-debit').value;
    }

    if (valid) {
        alert('Formulário enviado com sucesso!');
        window.location.href = './endereco';
    } else {
        alert('Por favor, preencha todos os campos do cartão antes de prosseguir.');
    }
});