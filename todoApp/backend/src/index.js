const app = require('./app');
const path = require('path')

require('dotenv').config({ path: path.join(__dirname, '.env') });
const PORT = process.env.BACKEND_PORT;
app.listen(PORT, () => {
    console.log(`Server listening on ${5000}.`);
});

