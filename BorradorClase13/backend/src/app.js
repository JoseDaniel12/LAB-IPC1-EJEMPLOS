// IMPORTS
const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const path = require('path');

// APPLICATION
const app = express();
const PORT = 3000;

// MIDLEWARES
app.use(cors({ origin: true, optionSuccessStatus: 200 }));
app.use(bodyParser.json({ limit: '10mb', extended: true }));
app.use(bodyParser.urlencoded({ limit: '10mb', extended: true }));

// ROUTES
app.get('/',  async (req, res) => {
    res.status(200).json({ msg: 'IPC1' });
});

app.use('/autenticacion', require('./autenticacion.js'));

// START
app.listen(PORT, () => {
    console.log(`Server listening on ${PORT}.`);
});
