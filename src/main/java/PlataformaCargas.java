import modelo.Asignatura;
import modelo.Docente;
import modelo.Estatus;
import modelo.Solicitud;
import modelo.Tutor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class PlataformaCargas {
    private Deque<Solicitud> solicitudes;
    private Solicitud solicitud;
    private ArrayList<Asignatura> asignaturas;
    private Asignatura asignatura;
    private Tutor tutor;
    private Scanner scanner = new Scanner(System.in);

    PlataformaCargas(){
        this.solicitudes = new ArrayDeque<>();
        this.asignaturas = new ArrayList<>();
        this.tutor = new Tutor();
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

    void gestionarSolicitud() {
        if (solicitudes.isEmpty()) {
            System.out.println("No hay solicitudes pendientes por gestionar");
            return;
        }

        mostrarSolicitudes();
        solicitud = solicitudes.getFirst();
        System.out.println("Solicitud mas antigua:");
        System.out.println("Asignatura: " + solicitud.getAsignatura().getNombre());
        System.out.println("Estatus: " + solicitud.getEstatus());
        System.out.println("Fecha: " + solicitud.getFechaSolicitud());
        System.out.println("1. Aceptar | 2. Procesar | 3. Rechazar");

        if (!scanner.hasNextInt()) {
            System.out.println("Debes ingresar una opcion numerica del 1 al 3");
            scanner.nextLine();
            return;
        }

        int opcion = scanner.nextInt();
        if (opcion < 1 || opcion > 3) {
            System.out.println("Opcion no valida");
            return;
        }

        if (opcion == 1) {
            tutor.modificarEstatus(solicitud, Estatus.ACEPTADA);
            solicitudes.removeFirst();
            System.out.println("Solicitud aceptada");
        } else if (opcion == 2) {
            tutor.modificarEstatus(solicitud, Estatus.PROCESADA);
            System.out.println("Solicitud procesada; permanece en la cola");
        } else {
            tutor.modificarEstatus(solicitud, Estatus.RECHAZADA);
            solicitudes.removeFirst();
            System.out.println("Solicitud rechazada");
        }
    }

    void solicitarCarga() {
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
        solicitudes.addLast(solicitud);
        System.out.println("Tu Solicitud ha Sido Enviada");
    }

    void mostrarAsignaturas() {
        int index = 0;
        for (Asignatura a : this.asignaturas) {
            index++;
            System.out.println(index + ". " + a.getNombre() + " - " + a.getDocente().getNombre());
        }
    }

    void mostrarSolicitudes() {
        int index = 0;
        for (Solicitud s : this.solicitudes) {
            index++;
            System.out.println(index + ". " + s.getAsignatura().getNombre()
                    + " - " + s.getEstatus()
                    + " - Fecha " + s.getFechaSolicitud());
        }
    }
}