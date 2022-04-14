const form = document.querySelector('.js-form');

form.addEventListener('submit', e => {
    e.preventDefault();
    const name = document.querySelector('#name');
    const birthDate = document.querySelector('#birth-date');
    console.log(name.value, birthDate.value);
});