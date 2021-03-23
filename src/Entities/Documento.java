/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 3 - mar - 2021
 * Descripción:
 * Clase que contiene la información de Documento
 */
package Entities;

/**
 * Clase que contiene la información de Documento
 */
public class Documento {
    protected int idDocumento;
    protected String titulo;
    protected String descripcion;
    protected String fechaEntrega;

    /**
     * Crea una instancia con un id = 0 y cadenas vacías
     */
    public Documento() {
        idDocumento = 0;
        titulo = "";
        descripcion = "";
        fechaEntrega = "";
    }

    /**
     * Crea una instancia a partir de una instancia existente de la misma clase.
     * @param original la instancia existe
     */
    public Documento( Documento original ) {
        this( original.idDocumento, original.titulo, original.descripcion, original.fechaEntrega );
    }

    /**
     * Crea una intancia a partir de los valores introducidos
     * @param idIn el id del documento
     * @param tituloIn el titulo del documento
     * @param descripcionIn la descripcion del documento
     * @param fechaIn la fecha en la que se subió el documento al sistema
     */
    public Documento( int idIn, String tituloIn, String descripcionIn, String fechaIn ) {
        idDocumento = idIn;
        titulo = tituloIn;
        descripcion = descripcionIn;
        fechaEntrega = fechaIn;
    }

    /**
     * Regresa el título del documento
     * @return el título del documento
     */
    public String GetTitulo() {
        return titulo;
    }

    /**
     * Regresa la descripción del documento
     * @return la descripción del documento
     */
    public String GetDescripcion() {
        return descripcion;
    }

    /**
     * Regresa la fecha de entrega del documento
     * @return la fecha de entrega
     */
    public String GetFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Cambia el título del documento por el valor introducido
     * @param tituloIn el nuevo título
     */
    public void SetTitulo( String tituloIn ) {
        titulo = tituloIn;
    }

    /**
     * Cambia la descripción del documento por el valor introducido
     * @param descripcionIn la nueva descripción
     */
    public void SetDescripcion( String descripcionIn ) {
        descripcion = descripcionIn;
    }

    /**
     * Cambia la fecha del documento por el valor introducido
     * @param fechaIn la nueva fecha
     */
    public void SetFechaEntrega( String fechaIn ) {
        fechaEntrega = fechaIn;
    }
}