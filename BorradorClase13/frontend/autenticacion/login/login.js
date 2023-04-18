function login(event) {
    event.preventDefault();
    const form = document.getElementById('form');
    const formData = new FormData(form);

    const data = {};
    for (const [key, value] of formData.entries()) {
      data[key] = value;
    }

    fetch('http://localhost:3000/autenticacion/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.status === 200) {
           return response.json();
        } else {
            return response.json().then(data => {
                throw new Error(data.msg);
            });
        }
    }).then(response => {
        const {usuario} = response;
        localStorage.setItem('usuario', JSON.stringify(usuario));
        window.location.href = "../../medicos/carga-pacientes/carga-pacientes.html"
    })
    .catch(error => {
        alert(error.message)
    });
}