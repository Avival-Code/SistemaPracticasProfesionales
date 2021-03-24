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
     * Constructor de la clase Estudiante. Crea una nueva
     * instancia de Estudiante a partir de una instancia existente.
     * @param original instancia existente de Estudiante.
     */
    public Estudiante( Estudiante original ) {
        this( original.idUsuario, original.nombres, original.apellidos, original.usuario, original.contrasena,
                original.correoElectronico, original.telefono, original.matricula, original.nrc, original.estado );
    }

    /**
     * Crea una instancia de Estudiante a partir de un UsuarioUV, una
     * matrícula, un nrc y un EstadoEstudiante.
     * @param usuario el usuario que será utilizado para crear el estudiante
     * @param matriculaIn la matrícula del estudiante
     * @param nrcIn el nrc al que pertenece el estudiante
     * @param estadoIn el estado actual del estudiante
     */
    public Estudiante( UsuarioUV usuario, String matriculaIn, String nrcIn, EstadoEstudiante estadoIn ) {
        this( usuario.idUsuario, usuario.nombres, usuario.apellidos, usuario.usuario, usuario.contrasena, usuario.correoElectronico,
              usuario.telefono, matriculaIn, nrcIn, estadoIn );
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