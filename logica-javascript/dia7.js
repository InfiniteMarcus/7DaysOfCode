
function ehNaN(a, b){
    a = Number(a);
    b = Number(b);

    if(isNaN(Number(a)) || isNaN(Number(b))){
        alert('Valores fornecidos inválidos! Verifique os números e tente novamente');
        return true;
    }

    return false;
}

function soma (a, b) {

    if(ehNaN(a, b)) return;

    a = Number(a);
    b = Number(b);

    alert(`A soma de ${a} e ${b} é: ${a+b}`);
}

function subtracao (a, b) {

    if(ehNaN(a, b)) return;

    a = Number(a);
    b = Number(b);

    alert(`A subtração de ${a} e ${b} é: ${a-b}`);
}

function multiplicacao (a, b) {

    if(ehNaN(a, b)) return;

    a = Number(a);
    b = Number(b);

    alert(`A multiplicação de ${a} e ${b} é: ${a*b}`);
}

function divisao (a, b) {

    if(ehNaN(a, b)) return;

    a = Number(a);
    b = Number(b);

    if(!b)
        return alert('Divisão inválida! Verifique os números fornecidos');

    alert(`A divisão de ${a} e ${b} é: ${a/b}`);
}


let opcao = prompt('Escolha a operação matemática que você deseja (soma, subtração, multiplicação ou divisão) ou digite sair');

while(opcao != 'sair'){

    const a = prompt('Forneça o primeiro número da sua operação');
    const b = prompt('Forneça o segundo número da sua operação');

    switch (opcao) {
        case 'soma':
            soma(a, b);
            break;
        case 'subtração':
            subtracao(a, b);
            break;
        case 'multiplicação':
            multiplicacao(a, b);
            break;
        case 'divisão':
            divisao(a, b);
            break;
    }

    opcao = prompt('Escolha a operação matemática que você deseja (soma, subtração, multiplicação ou divisão) ou digite sair');
}

alert('Até a próxima!');
