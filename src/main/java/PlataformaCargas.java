import modelo.Asignatura;
import modelo.Docente;
import modelo.Solicitud;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class PlataformaCargas {
    private Deque<Solicitud> solicitudes;
    private Solicitud solicitud;
    private ArrayList<Asignatura> asignaturas;
    private Asignatura asignatura;

    PlataformaCargas(){
        this.solicitudes = new ArrayDeque<>();  
        this.asignaturas = new ArrayList<>();
        precargarAsignaturas();
    }

    private void precargarAsignaturas() {
        this.asignaturas.add(new Asignatura("Estructura de Datos", new Docente("Dr. Roberto Martínez")));
        this.asignaturas.add(new Asignatura("Programación Orientada a Objetos", new Docente("Mtra. Ana Ruiz")));
        this.asignaturas.add(new Asignatura("Bases de Datos", new Docente("Ing. Carlos López")));
        this.asignaturas.add(new Asignatura("Ingeniería de Software", new Docente("Dra. Laura Sánchez")));
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    void gestionarSolictud(){

    }

    void solicitarCarga(){

    }

    void mostrarAsignaturas(){
        int index = 0;
        for(Asignatura a: this.asignaturas){
            index++;
            System.out.println(index + ". " + a.getNombre() + " - " + a.getDocente().getNombre());
        }
    }
}
