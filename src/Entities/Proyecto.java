/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 3 - mar - 2021
 * Descripción:
 * Clase que contiene la información del Proyecto
 */
package Entities;

/**
 * Clase que contiene la información del Proyecto
 */
public class Proyecto {
    private int idProyecto;
    private String nombre;
    private String descripcion;
    private int numEstudiantesRequeridos;
    private int numEstudiantesAsignados;
    private String fechaRegistro;

    /**
     * Constructor sin parametros de la clase Proyecto.
     * Crea una instancia con id = 0 y valores vacíos.
     */
    public Proyecto() {
        idProyecto = 0;
        nombre = "";
        descripcion = "";
        numEstudiantesRequeridos = 0;
        numEstudiantesAsignados = 0;
        fechaRegistro = "";
    }

    /**
     * Constructor de clase Proyecto. Crea una insancia con los
     * valores introducidos.
     * @param idIn el ID del proyecto.
     * @param nombreIn el nombre del proyecto
     * @param descripcionIn la descripcion del proyecto
     * @param numEstudiantesRequeridosIn la cantidad de estudiantes requeridos
     * @param numEstudiantesAsignadosIn la cantidad de estudiantes asignados
     * @param fechaRegistroIn la fecha de registro del proyecto en el sistema
     */
    public Proyecto( int idIn, String nombreIn, String descripcionIn, int numEstudiantesRequeridosIn,
                     int numEstudiantesAsignadosIn, String fechaRegistroIn ) {
        idProyecto = idIn;
        nombre = nombreIn;
        descripcion = descripcionIn;
        numEstudiantesRequeridos = numEstudiantesRequeridosIn;
        numEstudiantesAsignados = numEstudiantesAsignadosIn;
        fechaRegistro = fechaRegistroIn;
    }

    /**
     * Constructor de clase Proyecto. Crea una instancia a partir
     * de una isntancia existente de la clase Proyecto.
     * @param original
     */
    public Proyecto( Proyecto original ) {
        idProyecto = original.idProyecto;
        nombre = original.nombre;
        descripcion = original.descripcion;
        numEstudiantesRequeridos = original.numEstudiantesRequeridos;
        numEstudiantesAsignados = original.numEstudiantesAsignados;
        fechaRegistro = original.fechaRegistro;
    }

    /**
     * Regresa el nombre del proyecto
     * @return
     */
    public String GetNombre() {
        return nombre;
    }

    /**
     * Regresa la descripción del proyecto
     * @return
     */
    public String GetDescripcion() {
        return descripcion;
    }

    /**
     * Regresa la cantidad de estudiantes requeridos para
     * realizar este proyecto
     * @return
     */
    public int GetEstudiantesRequeridos() {
        return numEstudiantesRequeridos;
    }

    /**
     * Regresa la cantidad de estudiantes asignados a este proyecto
     * @return
     */
    public int GetEstudiantesAsignados() {
        return numEstudiantesAsignados;
    }

    /**
     * Regresa la fecha de registro en el sistema del proyecto
     * @return
     */
    public String GetFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Cambia el nombre del proyecto al valor introducido
     * @param nombreIn
     */
    public void SetNombre( String nombreIn ) {
        nombre = nombreIn;
    }

    /**
     * Cambia la descripción del proyecto al valor introducido
     * @param descripcionIn
     */
    public void SetDescripcion( String descripcionIn ) {
        descripcion = descripcionIn;
    }

    /**
     * Cambia la cantidad de estudiantes requeridos al valor introducido
     * @param cantidad
     */
    public void SetEstudiantesRequeridos( int cantidad ) {
        numEstudiantesRequeridos = cantidad;
    }

    /**
     * Cambia la cantidad de estudiantes asignados al valor introducido
     * @param cantidad
     */
    public void SetEstudiantesAsignados( int cantidad ) {
        numEstudiantesAsignados = cantidad;
    }

    /**
     * Cambia la fecha de registro al valor introducido
     * @param fechaIn
     */
    public void SetFechaRegistro( String fechaIn ) {
        fechaRegistro = fechaIn;
    }
}