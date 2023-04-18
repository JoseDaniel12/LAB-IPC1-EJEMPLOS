from flask import Flask, render_template
from flask_cors import CORS
from blueprints.autenticacion import autenticacion_bp

# Instancia de la aplicacón
app = Flask(__name__, static_folder='static')
app.secret_key = 'secret key'


# Cross-Origin Resource Sharing - Compartir recursos entre diferentes orígenes
CORS(app, resources={r'/*': {'origins': '*'}})

# Rutas
@app.route('/')
def index():
    return render_template('autenticacion/login.html')

app.register_blueprint(autenticacion_bp)

# Se coloca la apliacion en modo de escucha
if __name__ == '__main__':
    app.run(host='0.0.0.0', port=3000, debug=True)