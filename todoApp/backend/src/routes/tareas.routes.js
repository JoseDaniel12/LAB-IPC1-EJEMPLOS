const express = require('express');
const tareas_controller = require('../controllers/tareas.controller');

const router = express.Router();

router.post('/agregar_tarea', tareas_controller.agregar_tarea);
router.get('/obtener_tareas', tareas_controller.obtener_tareas);
router.put('/realizar_tarea', tareas_controller.realizar_tarea);
router.delete('/borrar_tarea', tareas_controller.borrar_tarea);

module.exports = router;