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

    if(pessoas && pessoas.length > 0) {
        const table = document.querySelector('.data-table');

        table.style.display = 'block';

        pessoas.forEach(pessoa => {
            tableContent.innerHTML += `<tr><td class="data-content">${pessoa.name}</td><td class="data-content">${pessoa.birthDate}</td><td class="data-actions"><button class="edit-button" onClick="edit(this)">Editar</button><button class="remove-button" onClick="remove(this)">Remover</button</td></tr>`;
        });
    }
});

function getIndexOfObject (array, keyField1, keyField2, key) {
    return array.map(function(e) { return `${e[keyField1]}${e[keyField2]}`; }).indexOf(key);
}

function edit (element) {
    const row = element.parentNode.parentNode;

    const name = row.childNodes[0].innerHTML;
    const birthday = row.childNodes[1].innerHTML;

    const splittedDate = birthday.split('/');

    nameInput.value = name;
    birthDateInput.value = `${splittedDate[2]}-${splittedDate[1]}-${splittedDate[0]}`;

    const pessoas = JSON.parse(localStorage.getItem('pessoas')) || [];
    
    pessoas.splice(getIndexOfObject(pessoas, 'name', 'birthDate', `${name}${birthday}`), 1);

    localStorage.setItem('pessoas', JSON.stringify(pessoas));
}

function remove (element) {
    const row = element.parentNode.parentNode;
    const name = row.childNodes[0].innerHTML;
    const birthday = row.childNodes[1].innerHTML;

    row.remove();

    const pessoas = JSON.parse(localStorage.getItem('pessoas')) || [];

    pessoas.splice(getIndexOfObject(pessoas, 'name', 'birthDate', `${name}${birthday}`), 1);

    localStorage.setItem('pessoas', JSON.stringify(pessoas));
}