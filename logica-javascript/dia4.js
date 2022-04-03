const numeroRandomico = Math.floor(Math.random() * (10 + 1));

for(let i = 0; i < 3; i++){

    const numeroChutado = prompt('Digite o número que você deseja chutar');

    if(numeroChutado == numeroRandomico){
        alert(`Você acertou! Parabéns. O número era ${numeroChutado}`);
        break;
    }

    if(i == 2)
        alert(`O número correto era ${numeroRandomico}`);
}
