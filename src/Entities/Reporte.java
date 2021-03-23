/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 3 - mar - 2021
 * Descripción:
 * Clase que contiene la información de Reporte
 */
package Entities;

import Enumerations.TipoReporte;

/**
 * Clase que contiene la información de Reporte
 */
public class Reporte extends Documento {
    private int horasReportadas;
    private TipoReporte tipo;

    /**
     * Crea una instancia de la clase con un id = 0, 0 horas reportadas
     * y cadenas vacías.
     */
    public Reporte() {
        super();
        horasReportadas = 0;
        tipo = null;
    }

    /**
     * Crea una instancia de la clase a partir de una instancia existente.
     * @param original la instancia existente
     */
    public Reporte( Reporte original ) {
        this( original.idDocumento, original.titulo, original.descripcion, original.fechaEntrega,
                original.horasReportadas, original.tipo );
    }

    /**
     * Crea una instancia de la clase con los valores introducidos.
     * @param idIn el id del reporte
     * @param tituloIn el título del reporte
     * @param descripcionIn la descripción del reporte
     * @param fechaIn la fecha en la cual fue entregada el reporte
     * @param horasReportadasIn las horas que se reportan en el archivo
     * @param tipoIn el tipo de reporte
     */
    public Reporte( int idIn, String tituloIn, String descripcionIn, String fechaIn, int horasReportadasIn,
                    TipoReporte tipoIn ) {
        super( idIn, tituloIn, descripcionIn, fechaIn );
        horasReportadas = horasReportadasIn;
        tipo = tipoIn;
    }

    /**
     * Regresa las horas reportadas en el reporte
     * @return las horas reportadas
     */
    public int GetHorasReportadas() {
        return horasReportadas;
    }

    /**
     * Regresa el tipo de reporte
     * @return el tipo de reporte
     */
    public TipoReporte GetTipoReporte() {
        return tipo;
    }

    /**
     * Cambia la cantidad de horas que se reportan por el valor introducido
     * @param horasIn la nueva cantidad de horas
     */
    public void SetHorasReportadas( int horasIn ) {
        horasReportadas = horasIn;
    }
}