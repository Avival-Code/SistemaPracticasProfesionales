/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 3 - mar - 2021
 * Descripción:
 * Clase que contiene la información de Estudiante. Hereda
 * de la superclase UsuarioUV.
 */
package Entities;

import Enumerations.EstadoEstudiante;

/**
 * Clase que contiene la información de Estudiante. Hereda
 * de la superclase UsuarioUV.
 */
public class Estudiante extends UsuarioUV {
    private String matricula;
    private String nrc;
    private EstadoEstudiante estado;

    /**
     * Constructor sin parametros de Estudiante. Crea una instancia
     * con un ID = 0, cadenas vacías y un estado nulo.
     */
    public Estudiante() {
        super();
        matricula = "";
        nrc = "";
        estado = null;
    }

    /**
     * Constructor de la clase Estudiante. Crea una insancia con
     * los valores introducidos.
     * @param idIn el ID del Estudiante asignado por el SMBDR.
     * @param nombresIn los nombres del Estudiante.
     * @param apellidosIn los apellidos del Estudiante.
     * @param usuarioIn utilizado para iniciar sesión al SPP.
     * @param contrasenaIn utilizada para iniciar sesión al SPP.
     * @param correoElectronicoIn correo electrónico del Estudiante.
     * @param telefonoIn teléfono del Estudiante.
     * @param matriculaIn matrícula del Estudiante.
     * @param nrcIn nrc de la materia del Estudiante.
     * @param estadoIn estado actual del Estudiante.
     */
    public Estudiante( int idIn, String nombresIn, String apellidosIn, String usuarioIn, String contrasenaIn, String correoElectronicoIn,
                       String telefonoIn, String matriculaIn, String nrcIn, EstadoEstudiante estadoIn) {
        super( idIn, nombresIn, apellidosIn, usuarioIn, contrasenaIn, correoElectronicoIn, telefonoIn );
        matricula = matriculaIn;
        nrc = nrcIn;
        estado = estadoIn;
    }

    /**
     * Constructor de la clase Estudiante. Crea una nueva
     * instancia de Estudiante a partir de una instancia existente.
     * @param original instancia existente de Estudiante.
     */
    public Estudiante( Estudiante original ) {
        super( original.idUsuario, original.nombres, original.apellidos, original.usuario, original.contrasena,
                original.correoElectronico, original.telefono );
        matricula = original.matricula;
        nrc = original.nrc;
        estado = original.estado;
    }

    /**
     * Regresa la matrícula del Estudiante
     * @return
     */
    public String GetMatricula() {
        return matricula;
    }

    /**
     * Regresa el nrc del Estudiante
     * @return
     */
    public String GetNrc() {
        return nrc;
    }

    /**
     * Regresa el estado actual del Estudiante
     * @return
     */
    public EstadoEstudiante GetEstado() {
        return estado;
    }

    /**
     * Cambia el valor del nrc del Estudiante al valor introducido
     * @param nrcIn
     */
    public void SetNrc( String nrcIn ) {
        nrc = nrcIn;
    }

    /**
     * Cambia el estado actual del Estudiante al valor introducido
     * @param estadoIn
     */
    public void SetEstadoEstudiante( EstadoEstudiante estadoIn ) {
        estado = estadoIn;
    }
}