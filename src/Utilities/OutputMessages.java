/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 31 - mar - 2021
 * Descripción:
 * Clase que contiene todos los mensajes dirigidos al usuario
 * por el sistema.
 */
package Utilities;

/**
 * Clase que contiene todos los mensajes dirigidos al usuario
 * por el sistema.
 */
public class OutputMessages {
    /**
     * Mensaje mostrado en caso de no encontrar el archivo FXML de la pantalla
     * Registro_Estudiante
     * @return una cadena con el mensaje de error
     */
    public String RegistryScreenMissing() { return "No se encontró el archivo FXML de pantalla Registro."; }

    /**
     * Mensaje mostrado en caso de no encontrar el archivo FXML de la pantalla
     * IniciarSesión
     * @return una cadena con el mensaje de error
     */
    public String LoginScreenMissing() { return "No se encontró el archivo FXML de pantalla Login."; }

    /**
     * Mensaje mostrado cuando se registra un nuevo Estudiante a la
     * base de datos de manera exitosa.
     * @return una cadena con el mensaje de éxito
     */
    public String RegistrationSuccessfull() { return "Registro Exitoso"; }

    /**
     * Mensaje mostrado cuando ocurre un error en la base de datos
     * @return una cadena con el mensaje de error
     */
    public String DatabaseConnectionFailed() { return "No hay conexión a la base de datos. Intente más tarde."; }

    /**
     * Mensaje mostrado cuando ya existe un Estudiante en base de datos
     * @return una cadena con el mensaje de error
     */
    public String StudentAlreadyExists() { return "Ya existe un registro con esa información"; }

    /**
     * mensaje mostrado cuando se introduce información de login que no
     * existe en la base de datos
     * @return una cadena con el mensaje de error
     */
    public String InvalidLoginInformation() { return "El usuario o contraseña es incorrecta."; }

    /**
     * Mensaje mostrado cuando los nombres introducidos por el usuario
     * son inválidos
     * @return una cadena con el mensaje de error
     */
    public String InvalidNames() { return "Los nombres no son validos."; }

    /**
     * Mensaje mostrado cuando los apellidos introducidos por el usuario
     * son inválidos
     * @return una cadena con el mensaje de error
     */
    public String InvalidLastNames() { return "Los apellidos no son validos."; }

    /**
     * Mensaje mostrado cuando el correo electrónico introducido por el usuario
     * es inválido
     * @return una cadena con el mensaje de error
     */
    public String InvalidEmail() { return "El correo electrónico no es valido"; }

    /**
     * Mensaje mostrado cuando la matrícula introducida por el usuario
     * es inválida
     * @return una cadena con el mensaje de error
     */
    public String InvalidMatricula() { return "La matrícula no es valida."; }

    /**
     * Mensaje mostrado cuando el NRC introducido por el usuario
     * es inválido
     * @return una cadena con el mensaje de error
     */
    public String InvalidNRC() { return "El nrc no es vlido."; }

    /**
     * Mensaje mostrado cuando el teléfono introducido por el usuario
     * es inválido
     * @return una cadena con el mensaje de error
     */
    public String InvalidTelephone() { return "El teléfono no es valido."; }

    /**
     * Mensaje mostrado cuando la contraseña introducida por el usuario
     * es inválida
     * @return una cadena con el mensaje de error
     */
    public String InvalidPassword() { return "La contraseña no es valida."; }

    /**
     * Mensaje mostrado el nombre de usuario introducido en la pantalla InicioSesión
     * no es valido.
     * @return una cadena con el mensaje de error
     */
    public String InvalidUsername() { return "El número personal o matrícula no es valida."; }

    /**
     * Mensaje mostrado cuando las contraseñas introducidas por el usuario
     * son inválidas
     * @return una cadena con el mensaje de error
     */
    public String PasswordsDontMatch() { return "Las contraseñas no coinciden."; }
}