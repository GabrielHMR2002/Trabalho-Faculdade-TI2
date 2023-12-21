const url = "http://localhost:8080/denuncia/2";

function show(denuncias){
    let tab = `<thead>
            <th scope="col">ID</th>
            <th scope="col">Situação</th>
            <th scope="col">Nome</th>
            <th scope="col">E-mail</th>
            <th scope="col">Denúncia</th>
            <th scope="col">Resposta</th>
            <th scope="col">Ações</th>
        </thead>`;

    for (const denuncia of denuncias) {
        tab +=`
            <tr>
                <td scope="row">${denuncia.id}</td>
                <td>${denuncia.situacao}</td>
                <td>${denuncia.nomeDenunciante}</td>
                <td>${denuncia.email}</td>
                <td>${denuncia.tipo_denuncia}</td>
                <td>${denuncia.resposta}</td>
            </tr>
        `;
    }

    document.getElementById("denuncias").innerHTML= tab;
}



async function getAPI(url){
    const response = await fetch(url, { method: "GET"});

    if (response.ok) {
        let data = await response.json();
        console.log(data);

        if (Array.isArray(data)) {
            show(data);
        } else if (typeof data === 'object' && data !== null) {
            // Se a resposta for um objeto, crie uma array com esse objeto
            show([data]);
        } else {
            console.error("A resposta da API não é uma array ou objeto válido:", data);
        }
    } else {
        console.error("Erro ao obter dados da API");
    }
}


getAPI(url);

async function enviarDenuncia() {
    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const tipoDenuncia = document.getElementById('tipo-denuncia').value;
    const descricao = document.getElementById('descricao').value;

    const denuncia = {
        nomeDenunciante: nome,
        email: email,
        tipoDenuncia: tipoDenuncia,
        descricao: descricao
    };

    try {
        const response = await fetch("http://localhost:8080/denuncia", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(denuncia),
        });

        if (response.ok) {
            console.log('Denúncia enviada com sucesso!');
            // Você pode adicionar lógica adicional aqui, como limpar o formulário ou atualizar a lista de denúncias.
        } else {
            console.error('Erro ao enviar a denúncia:', response.statusText);
        }
    } catch (error) {
        console.error('Erro durante a requisição:', error);
    }
}







// const denuncia = {
//     proximoId: 1, // Inicializa o próximo ID como 1
//     adicionar: function() {
//       // Obter os valores do formulário
//       const nome = document.getElementById('nome').value;
//       const email = document.getElementById('email').value;
//       const tipoDenuncia = document.getElementById('tipo-denuncia').value;
//       const descricao = document.getElementById('descricao').value;
  
//       // Criar uma nova linha na tabela
//       const table = document.querySelector('table');
//       const newRow = table.insertRow(-1); // -1 para inserir no final da tabela
  
//       // Inserir as células na nova linha
//       const idCell = newRow.insertCell(0);
//       const situacaoCell = newRow.insertCell(1);
//       const nomeCell = newRow.insertCell(2);
//       const emailCell = newRow.insertCell(3);
//       const denunciaCell = newRow.insertCell(4);
//       const respostaCell = newRow.insertCell(5);
//       const acoesCell = newRow.insertCell(6); // Adicione a coluna de ações
  
//       // Definir os valores das células
//       idCell.textContent = String(this.proximoId).padStart(2, '0'); // Converte o ID em formato "02", "03", etc.
//       situacaoCell.textContent = 'Pendente'; // Nova denúncia
//       nomeCell.textContent = nome;
//       emailCell.textContent = email;
//       denunciaCell.textContent = tipoDenuncia;
//       respostaCell.textContent = ''; // Coluna de resposta vazia
  
//       // Criar um botão de exclusão
//       const excluirButton = document.createElement('button');
//       excluirButton.innerHTML = '<img src="icones/lixo.png" alt="Excluir">';
//       excluirButton.className = 'excluir-button'; // Adicione a classe "excluir-button"
//       excluirButton.addEventListener('click', () => this.excluirDenuncia(table, newRow));
  
//       // Adicionar o botão de exclusão à coluna de ações
//       acoesCell.appendChild(excluirButton);
  
//       // Incrementa o próximo ID
//       this.proximoId++;
  
//       // Limpar os campos do formulário
//       document.getElementById('nome').value = '';
//       document.getElementById('email').value = '';
//       document.getElementById('tipo-denuncia').value = '';
//       document.getElementById('descricao').value = '';
//     },
  
//     excluirDenuncia: function(table, row) {
//       const rowIndex = row.rowIndex;
//       table.deleteRow(rowIndex);
//     },
//   };
    