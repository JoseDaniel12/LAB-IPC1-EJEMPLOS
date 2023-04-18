function registrarse(event) {
    event.preventDefault();
    const form = document.getElementById('form');
    const formData = new FormData(form);

    const data = {};
    for (const [key, value] of formData.entries()) {
      data[key] = value;
    }


    fetch('http://localhost:3000/autenticacion/registro', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.status === 200) {
            window.location.href = "../login/login.html"
        } else {
            return response.json().then(data => {
                throw new Error(data.msg);
            });
        }
    })
    .catch(error => {
        alert(error.message)
    });
}