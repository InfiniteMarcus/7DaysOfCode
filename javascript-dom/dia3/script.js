const form = document.querySelector('.js-form');

form.addEventListener('submit', e => {
    const name = document.querySelector('#name').value;
    const birthDate = document.querySelector('#birth-date').value;

    const pessoas = JSON.parse(localStorage.getItem('pessoas')) || [];

    const birthDateObj = new Date(birthDate).toLocaleDateString("pt-BR", {timeZone: 'UTC'});

    pessoas.push({name, birthDate: birthDateObj});

    localStorage.setItem('pessoas', JSON.stringify(pessoas));
});

window.addEventListener('load', () => {
    const tableContent = document.querySelector('#table-content');

    const pessoas = JSON.parse(localStorage.getItem('pessoas'));

    if(pessoas){

        const table = document.querySelector('.data-table');

        table.style.display = 'block';

        pessoas.forEach(pessoa => {
            tableContent.innerHTML += `<tr><td class="data-content">${pessoa.name}</td><td class="data-content">${pessoa.birthDate}</td></tr>`;
        });
    }
});