from flask import Blueprint, request, render_template, redirect
from app_state import usuarios, tareas

tareas_bp = Blueprint(
    'tareas_bp',
    __name__,
    url_prefix='/tareas'
)


@tareas_bp.route('/agregar_tarea', methods=['POST'])
def agregar_tarea():
    tarea = request.form['tarea']
    tareas.append(tarea)
    return redirect(request.url)