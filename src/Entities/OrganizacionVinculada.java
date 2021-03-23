/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 3 - mar - 2021
 * Descripción:
 * Clase que contiene la información de Organización Vinculada
 */
package Entities;

import Enumerations.TipoSector;

/**
 * Clase que contiene la información de Organización Vinculada
 */
public class OrganizacionVinculada {
    private String nombre;
    private String direccion;
    private TipoSector sector;
    private String telefono;
    private String correoElectronico;

    /**
     * Constructor sin parámetros de la clase OrganizaciónVinculada.
     * Crea una instancia con valores nulos y cadenas vacias.
     */
    public OrganizacionVinculada() {
        nombre = "";
        direccion = "";
        sector = null;
        telefono = "";
        correoElectronico = "";
    }

    /**
     * Crea una nueva instancia de la clase OrganizaciónVinculada a partir
     * de una instancia existente.
     * @param original la instancia que se desea duplicar
     */
    public OrganizacionVinculada( OrganizacionVinculada original ) {
        this( original.nombre, original.direccion, original.sector, original.telefono, original.correoElectronico);
    }

    /**
     * Constructor de la clase OrganizaciónVinculada. Crea una instancia
     * con los valores introducidos.
     * @param nombreIn el nombre del organización
     * @param direccionIn la dirección de la organización
     * @param sectorIn el sector al que pertenece la organización
     * @param telefonoIn el telefono de la organización
     * @param correoIn el correo electronico de la organización
     */
    public OrganizacionVinculada( String nombreIn, String direccionIn, TipoSector sectorIn, String telefonoIn,
                                  String correoIn ) {
        nombre = nombreIn;
        direccion = direccionIn;
        sector = sectorIn;
        telefono = telefonoIn;
        correoElectronico = correoIn;
    }

    /**
     * Regresa el nombre de la organización vinculada
     * @return el nombre de la organización
     */
    public String GetNombre() {
        return nombre;
    }

    /**
     * Regresa la dirección de la organización vinculada
     * @return la dirección de la organización
     */
    public String GetDireccion() {
        return direccion;
    }

    /**
     * Regresa el sector de la organización vinculada
     * @return el sector de la organización
     */
    public TipoSector GetSector() {
        return sector;
    }

    /**
     * Regresa el telefono de la organización vinculada
     * @return el telefono de la organización
     */
    public String GetTelefono() {
        return telefono;
    }

    /**
     * Regresa el correo electrónico de la organización vinculada
     * @return el correo de la organización
     */
    public String GetCorreo() {
        return correoElectronico;
    }

    /**
     * Cambia el nombre de la organización al valor introducido
     * @param nombreIn el nuevo nombre
     */
    public void SetNombre( String nombreIn ) {
        nombre = nombreIn;
    }

    /**
     * Cambia la dirección de la organización vinculada al valor introducido
     * @param direccionIn la nueva dirección
     */
    public void SetDireccion( String direccionIn ) {
        direccion = direccionIn;
    }

    /**
     * Cambia el sector de la organización vinculada al valor introducido
     * @param sectorIn el nuevo sector
     */
    public void SetSector( TipoSector sectorIn ) {
        sector = sectorIn;
    }

    /**
     *Cambia el teléfono de la organización vinculada al valor introducido
     * @param telefonoIn el nuevo teléfono
     */
    public void SetTelefono( String telefonoIn ) {
        telefono = telefonoIn;
    }

    /**
     * Cambia el correo electrónico de la organización vonculada al valor
     * introducido
     * @param correoIn el nuevo correo electrónico
     */
    public void SetCorreo( String correoIn ) {
        correoElectronico = correoIn;
    }
}