
const areaDeAtuacao = prompt("Deseja seguir na área de Front-End ou Back-End?").trim().toLocaleLowerCase();

if(areaDeAtuacao == 'front-end'){
    const tecnologia = prompt("Deseja aprender React ou Vue?").trim().toLocaleLowerCase();
    alert(`Quer aprender mais sobre ${tecnologia}? Que massa!`);
}

if(areaDeAtuacao == 'back-end'){
    const tecnologia = prompt("Deseja aprender C# ou Java?").trim().toLocaleLowerCase();
    alert(`Quer aprender mais sobre ${tecnologia}? Que daora!`);
}

const desejaSerFullstack = prompt(`Deseja se especializar em ${areaDeAtuacao} ou seguir carreira Fullstack? Responda 1 para se especializar e 2 para Fullstack`);

alert(desejaSerFullstack == 2 ? 'Então bora ser Fullstack!' : `Então bora ser ${areaDeAtuacao}!`);

let especializacao = prompt(`Tem mais alguma tecnologia que você gostaria de aprender (digite "ok" para continuar)?`).trim().toLocaleLowerCase();

while(especializacao == 'ok'){
    const tecnologiaAEspecializar = prompt('Qual é o nome dessa tecnologia?');

    alert(`Que legal! Você quer aprender mais sobre ${tecnologiaAEspecializar}? Eu também!`);

    especializacao = prompt(`Tem mais alguma tecnologia que você gostaria de aprender?`).trim().toLocaleLowerCase();
}
