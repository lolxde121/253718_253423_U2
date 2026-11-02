package modelo;

import java.time.LocalDateTime;

public class Solicitud {
    private Asignatura asignatura;
    private LocalDateTime fechaSolicitud;
    private Estatus estatus;

    public Solicitud() {
        this.fechaSolicitud = LocalDateTime.now();
        this.estatus = Estatus.PROCESADA;
    }

    public Solicitud(Asignatura asignatura) {
        this.asignatura = asignatura;
        this.fechaSolicitud = LocalDateTime.now();
        this.estatus = Estatus.PROCESADA;
    }

    public Solicitud(Asignatura asignatura, LocalDateTime fechaSolicitud, Estatus estatus) {
        this.asignatura = asignatura;
        this.fechaSolicitud = fechaSolicitud;
        this.estatus = estatus;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }
}
