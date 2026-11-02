import modelo.Asignatura;
import modelo.Docente;
import modelo.Estatus;
import modelo.Solicitud;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class PlataformaCargas {
    private Deque<Solicitud> solicitudes;
    private Solicitud solicitud;
    private ArrayList<Asignatura> asignaturas;
    private Asignatura asignatura;
    private Scanner scanner = new Scanner(System.in);

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

    public Scanner getScanner() {
        return scanner;
    }

    void gestionarSolictud(){
        int opcion = 0;
        if (solicitudes.isEmpty()) {
            System.out.println("No hay solicitudes pendientes por gestionar");
            return;
        }
        mostrarSolicitudes();
        System.out.println(" ");
        System.out.println("Solicitud Prioritaria Actualmente!!");
        solicitud = solicitudes.getFirst();
        System.out.println("SLT-Prioritaria" + " " + solicitud.getEstatus() + " " + "Fecha" + " " + solicitud.getFechaSolicitud());
        System.out.println("Aceptar 1 | Rechazar 0");
        opcion = scanner.nextInt();
        if (opcion  == 0){
            solicitud.setEstatus(Estatus.RECHAZADA);
            System.out.println("Solicitud Gestational Exitosamente");
            solicitudes.removeFirst();
        } else if (opcion ==1) {
            solicitud.setEstatus(Estatus.ACEPTADA);
            System.out.println("Solicitud Gestionada Exitosamente");
            solicitudes.removeFirst();
        } else {
            System.out.println("Opcion no valida");
        }

    }

    void solicitarCarga(){
        mostrarAsignaturas();
        System.out.println("Selecciona La asignatura Para Solicitar Carga manual");
        if (!scanner.hasNextInt()) {
            System.out.println("Debes ingresar un numero valido");
            scanner.nextLine();
            return;
        }
        int seleccion = scanner.nextInt();
        if (seleccion < 1 || seleccion > asignaturas.size()) {
            System.out.println("Opcion no valida, selecciona una asignatura de la lista");
            return;
        }
        asignatura = asignaturas.get(seleccion - 1);
        solicitud = new Solicitud(asignatura);
        solicitudes.addFirst(solicitud);
        System.out.println("Tu Solicitud ha Sido Enviada");
    }

    void mostrarAsignaturas(){
        int index = 0;
        for(Asignatura a: this.asignaturas){
            index++;
            System.out.println(index + ". " + a.getNombre() + " - " + a.getDocente().getNombre());
        }
    }

    void mostrarSolicitudes(){
        int index = 0;
        for(Solicitud s: this.solicitudes){
            index++;
            System.out.println(index + ". " + "SLT" + index + " - " + s.getEstatus()+ " " + "Fecha" + " " + s.getFechaSolicitud());
        }
    }
}
