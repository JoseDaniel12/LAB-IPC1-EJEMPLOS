from flask import Blueprint, request, render_template, flash
from app_state import usuarios, tareas

autenticacion_bp = Blueprint(
    'autenticacion_bp',
    __name__,
    url_prefix='/autenticacion'
)


@autenticacion_bp.route('/registro', methods=['GET', 'POST'])
def registro():
    if request.method == 'GET':
        return render_template('autenticacion/registro.html')
    else:
        usuarios.append(request.form)
        return render_template('autenticacion/login.html')
        

@autenticacion_bp.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'GET':
        return render_template('autenticacion/login.html')
    else:
        nombre = request.form['nombre']
        contrasenia = request.form['contrasenia']
        for usuario in usuarios:
            if nombre == usuario['nombre'] and contrasenia == usuario['contrasenia']:
                return render_template('tareas/crear_tarea.html', usuario = usuario)
            else:
                return render_template('autenticacion/login.html')