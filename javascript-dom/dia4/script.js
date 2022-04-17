const form = document.querySelector('.js-form');
const nameInput = document.querySelector('#name');
const birthDateInput = document.querySelector('#birth-date');

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
            tableContent.innerHTML += `<tr><td class="data-content">${pessoa.name}</td><td class="data-content">${pessoa.birthDate}</td><td><button class="edit-button" onClick="edit(this)">Editar</button</td></tr>`;
        });
    }
});

function edit (element) {
    const row = element.parentNode.parentNode;

    const name = row.childNodes[0];
    const birthday = row.childNodes[1];

    const splittedDate = birthday.innerHTML.split('/');

    nameInput.value = name.innerHTML;
    birthDateInput.value = `${splittedDate[2]}-${splittedDate[1]}-${splittedDate[0]}`;

    const pessoas = JSON.parse(localStorage.getItem('pessoas')) || [];
    
    pessoas.splice(pessoas.indexOf({name, birthDay: birthday}), 1);

    localStorage.setItem('pessoas', JSON.stringify(pessoas));
}