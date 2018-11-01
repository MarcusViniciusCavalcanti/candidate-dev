var errors = document.querySelector("[role=\"errors\"]");
var success = document.querySelector("[role=\"success\"]");

if (errors !== null) {
    new PNotify({ title: 'Algo não esta certo!', text: errors.innerHTML, type: 'error', styling: 'bootstrap3' });
}

if (success !== null) {
    new PNotify({ title: 'Tudo certo!', text: success.innerHTML, type: 'success', styling: 'bootstrap3' });
}