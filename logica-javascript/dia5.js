const listaDeCompras = {
    "Frutas": [],
    "Laticínios": [],
    "Congelados": [],
    "Doces": [],
    "Outros": []
};

let opcao = prompt('Você deseja adicionar uma comida na sua lista de compras? (sim, não)');

while (opcao == 'sim') {
    const comida = prompt('Qual comida você deseja inserir?');
    const categoria = prompt('Em qual categoria essa comida se encaixa? (Frutas, Laticínios, Congelados, Doces, Outros)');

    if(listaDeCompras[categoria])
        listaDeCompras[categoria].push(comida);
    else{
        alert('Categoria não encontrada. Adicionado a categoria "outros"');
        listaDeCompras['Outros'].push(comida);
    }

    opcao = prompt('Você deseja adicionar uma comida na sua lista de compras? (sim, não)');
}

console.log('Lista de compras:');
for (categoria in listaDeCompras){
    console.log(`${categoria}:`);
    listaDeCompras[categoria].forEach(comida => console.log(`- ${comida}`));
}
