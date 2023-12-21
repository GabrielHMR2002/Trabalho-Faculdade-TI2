// Conteúdo do script.js
function enviarDados(event) {
    event.preventDefault();

    const cnpj = document.getElementById("cnpj").value;
    const quality = document.getElementById("quality").value;
    const delivery = document.getElementById("delivery").value;
    const cost = document.getElementById("cost").value;
    const complaint = document.querySelector('input[name="complaint"]:checked').value;

    const dadosParaEnviar = {
        cnpj: cnpj,
        quality: quality,
        delivery: delivery,
        cost: cost,
        complaint: complaint
    };

    fetch("http://localhost:8080/iqf", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify(dadosParaEnviar)
})
.then(response => response.json())
.then(data => {
    alert('Dados enviados com sucesso!');
    console.log("Dados enviados com sucesso:", data);
    // Você pode realizar ações adicionais se necessário
})
.catch(error => {
    alert('Erro ao enviar os dados!');
    console.error("Erro ao enviar dados:", error);
    // Adicione informações detalhadas sobre o erro
});

}
