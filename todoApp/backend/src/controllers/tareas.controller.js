const { mysql_exec_query } = require('../database/mysql_exec');


const agregar_tarea = async (req, res) => {
    const { descripcion } = req.body;
    let query = `INSERT INTO tarea (descripcion) VALUES (\'${descripcion}\')`;
    await mysql_exec_query(query);
    query = `SELECT * FROM tarea WHERE id_tarea = LAST_INSERT_ID();`;
    rows = await mysql_exec_query(query);
    tarea = rows[0]
    return res.status(200).json({ tarea });
}


const obtener_tareas = async (req, res) => {
    let query = `SELECT * FROM tarea`;
    let tareas = await mysql_exec_query(query);
    return res.status(200).json({ tareas });
}


const realizar_tarea = async (req, res) => {
    const { id_tarea } = req.body;
    let query = `UPDATE tarea set finalizada = 1 WHERE id_tarea = ${id_tarea}`;
    await mysql_exec_query(query);
    return res.status(200).json({ msg: 'Tarea actaulizada con exito.' });
}


const borrar_tarea = async (req, res) => {
    const { id_tarea } = req.body;
    let query = `DELETE FROM tarea WHERE id_tarea = ${id_tarea}`;
    mysql_exec_query(query);
    return res.status(200).json({ msg: 'Tarea eliminada con exito.' });
}


module.exports = {
    agregar_tarea,
    obtener_tareas,
    realizar_tarea,
    borrar_tarea
};
