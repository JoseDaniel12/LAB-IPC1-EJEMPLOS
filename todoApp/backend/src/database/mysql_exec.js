const conn = require('./mysql_conn');


const mysql_exec_query = async (query) => {
    try {
        const [result] = await conn.promise().execute(query);
        return result;
    } catch (err) {
        return { err };
    }
}

module.exports = {
    mysql_exec_query
}
