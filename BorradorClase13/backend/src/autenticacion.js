const express = require('express');
const router = express.Router();
const AppState = require('./AppState');

router.post('/login', (req, res) => {
    const { nombre, contrasenia } = req.body;
    const usuarioEncontrado = AppState.usuarios.find(u => {
        return u.nombre === nombre && u.contrasenia === contrasenia
    })

    if (!usuarioEncontrado) {
        return res.status(400).json({ msg: 'Credenciales Incorrectas.' });
    }

    return res.status(200).json({ usuario: usuarioEncontrado });
});


router.post('/registro', (req, res) => {
    const { nombre, apellido, fecha_nacimiento, sexo, alias, contrasenia, telefono } = req.body;

    const usuarioEncontrado = AppState.usuarios.find(u => {
        return u.nombre === nombre
    })
    if (usuarioEncontrado !== undefined) {
        return res.status(400).json({ msg: 'Ya existe un usuario con ese nombre.' });
    }

    usuario  = {
        nombre,
        apellido,
        fecha_nacimiento,
        sexo,
        alias,
        contrasenia,
        telefono
    }
    console.log(usuario)
    AppState.usuarios.push(usuario);
    return res.status(200).json({ msg: 'Usuario reigstrado exitosamente.' });
});


module.exports = router;