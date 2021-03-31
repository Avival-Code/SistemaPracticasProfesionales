package Utilities;

public class OutputMessages {
    public String RegistryScreenMissing() {
        return "No se encontró el archivo FXML de pantalla Registro.";
    }

    public String LoginScreenMissing() {
        return "No se encontró el archivo FXML de pantalla Login.";
    }

    public String RegistrationSuccessfull() { return "Registro Exitoso"; }

    public String DatabaseConnectionFailed() { return "No hay conexión a la base de datos. Intente más tarde."; }

    public String StudentAlreadyExists() { return "Ya existe un registro con esa información"; }

    public String InvalidNames() { return "Los nombres no son validos."; }

    public String InvalidLastNames() { return "Los apellidos no son validos."; }

    public String InvalidEmail() { return "El correo electrónico no es valido"; }

    public String InvalidMatricula() { return "La matrícula no es valida."; }

    public String InvalidNRC() { return "El nrc no es vlido."; }

    public String InvalidTelephone() { return "El teléfono no es valido."; }

    public String InvalidPassword() { return "La contraseña no es valida."; }

    public String PasswordsDontMatch() { return "Las contraseñas no coinciden."; }
}
