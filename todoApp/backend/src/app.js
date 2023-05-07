// IMPORTS
const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');

// VARIABLES
const corsOptions = { origin: true, optionSuccessStatus: 200 };

// APPLICATION
const app = express();

// MIDLEWARES
app.use(cors(corsOptions));
app.use(bodyParser.json({ limit: '10mb', extended: true }));
app.use(bodyParser.urlencoded({ limit: '10mb', extended: true }));

// ROUTES
app.get('/', async (req, res) => {
    res.status(200).json({ msg: 'Todo App.' });
});

app.use('/tareas', require('./routes/tareas.routes'))

module.exports = app;
