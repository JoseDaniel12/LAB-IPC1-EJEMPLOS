from flask import Blueprint, request, render_template, flash
from app_state import usuarios

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
        print(request.form)
        return '<h1>hola</h1>'
        

@autenticacion_bp.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'GET':
        return render_template('autenticacion/login.html')
    else:
        nombre = request.form['nombre']
        for usuario in usuarios:
            if usuario['nombre'] == nombre:
                return render_template('paciente/solicitar_cita.html', usuario = usuario)
            else:
                return render_template('autenticacion/login.html')