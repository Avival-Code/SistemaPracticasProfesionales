/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 3 - mar - 2021
 * Descripción:
 * Clase que contiene la información de ArchivoConsulta
 */
package Entities;

/**
 * Clase que contiene la información de ArchivoConsulta
 */
public class ArchivoConsulta {
    private int idArchivo;
    private String titulo;
    private String descripcion;

    /**
     * Crea una instancia de la clase con un id = 0
     * y cadenas vacías
     */
    public ArchivoConsulta() {
        idArchivo = 0;
        titulo = "";
        descripcion = "";
    }

    /**
     * Crea una instancia de la clase a partir de los valores introducidos
     * @param idIn el id del archivo
     * @param tituloIn el título del archivo
     * @param descipcionIn la descripción del archivo
     */
    public ArchivoConsulta( int idIn, String tituloIn, String descipcionIn ) {
        idArchivo = idIn;
        titulo = tituloIn;
        descripcion = descipcionIn;
    }

    /**
     * Crea una instancia de la clase a partir de  una instancia existente
     * @param original la instancia existente
     */
    public ArchivoConsulta( ArchivoConsulta original ) {
        this( original.idArchivo, original.titulo, original.descripcion );
    }

    /**
     * Regresa el título del archivo
     * @return el título del archivo
     */
    public String GetTitulo() {
        return titulo;
    }

    /**
     * Regresa la descripción del archivo
     * @return la descripción del archivo
     */
    public String GetDescripcion() {
        return descripcion;
    }

    /**
     * Cambia el título del arhivo al valor introducido
     * @param tituloIn el nuevo título
     */
    public void SetTitulo( String tituloIn ) {
        titulo = tituloIn;
    }

    /**
     * Cambia la descripción del archivo al valor introducido
     * @param descripcionIn la nueva descripción
     */
    public void SetDescripcion( String descripcionIn ) {
        descripcion = descripcionIn;
    }
}