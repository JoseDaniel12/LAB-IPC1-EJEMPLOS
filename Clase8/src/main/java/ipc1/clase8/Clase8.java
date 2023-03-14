package ipc1.clase8;

import java.util.LinkedList;

/**
 *
 * @author josed
 */

class Trabajador implements Runnable {
    private String nombre;
    private String tarea;
    private Departamento departamento;
    private boolean estaTrabajando;
    
    public Trabajador(String nombre, Departamento departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    
    public boolean estaTrabajando() {
        return this.estaTrabajando;
    }
    
    @Override
    public void run() {        
        try {
            while(departamento.tieneTareasPendientes()) {
                String tarea = departamento.getTarea(this);
                if (tarea != null) {
                    estaTrabajando = true;
                    System.out.println(nombre + " esta trabajando en " + tarea);
                    Thread.sleep((int) (Math.random() * 1000));
                    System.out.println(nombre + " ha termiando la tarea " + tarea);
                }
            }   
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Departamento {
    private LinkedList<String> tareas = new LinkedList();
    
    public void agregarTarea(String tarea) {
        this.tareas.add(tarea);
    }
    
    public synchronized String getTarea(Trabajador trabajador) {
        if (this.tieneTareasPendientes()) {
            String tarea = tareas.get(0);
            tareas.remove(0);
            trabajador.setTarea(tarea);
            return tarea;
        }
        return null;
    }
    
    public boolean tieneTareasPendientes() {
        return !this.tareas.isEmpty();
    } 
}

class Empresa {
    private Departamento produccion;
    private Departamento emsablaje;
    private Departamento empaquetado;
    
    public Empresa() {
        this.produccion = new Departamento();
        produccion.agregarTarea("Cortar material");
        produccion.agregarTarea("Moldear componentes");
        produccion.agregarTarea("Pintar partes");
        
        this.emsablaje = new Departamento();
        emsablaje.agregarTarea("Ensamblar compoentes");
        emsablaje.agregarTarea("Instalar cableado");
        emsablaje.agregarTarea("Probar producto final");
        
        this.empaquetado = new Departamento();
        empaquetado.agregarTarea("Empacar producto terminado");
    }
    
    public void hacerProcesos(){
        LinkedList<Trabajador> trabadores = new LinkedList<>();
        trabadores.add(new Trabajador("T1", produccion));
        trabadores.add(new Trabajador("T2", produccion));
        trabadores.add(new Trabajador("T3", emsablaje));
        trabadores.add(new Trabajador("T4", emsablaje));
        trabadores.add(new Trabajador("T4", empaquetado));
        
        LinkedList<Thread> hilos = new LinkedList<>();
        for (Trabajador t: trabadores) {
            Thread hilo = new Thread(t);
            hilo.start();
            hilos.add(hilo);
        }
        
        try {
            for (Thread h : hilos) {
                h.join();
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        //System.out.println("Porductos terminados " + empaquetado.getTareas.size());
    }
}

public class Clase8 {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        empresa.hacerProcesos();
    }
}
