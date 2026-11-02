package modelo;

public class Asignatura {
    private String nombre;
    private Docente docente;

    public Asignatura() {
    }

    public Asignatura(String nombre, Docente docente) {
        this.nombre = nombre;
        this.docente = docente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
