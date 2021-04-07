/*
 * Autor: Dan Javier Olvera Villeda
 * Versión: 1.0
 * Fecha Creación: 06 - mar - 2021
 * Descripción:
 * Singleton encargado de almacenar la información de las elecciones hechas por los usuarios en una ventana,
 * para que se pueda pasar esa informacion a la siguiente pantalla
 */
package Utilities;

import Entities.Estudiante;
import Entities.Proyecto;

public final class SelectionContainer {
    private static SelectionContainer loginInstance;
    private Proyecto proyectoElegido;
    private Estudiante estudianteElegido;

    private SelectionContainer() {
        this.estudianteElegido = null;
        this.proyectoElegido = null;
    }

    public static SelectionContainer GetInstance() {
        if( loginInstance == null ) {
            loginInstance = new SelectionContainer();
        }
        return loginInstance;
    }

    public Proyecto getProyectoElegido() {
        return proyectoElegido;
    }

    public Estudiante getEstudianteElegido() {
        return estudianteElegido;
    }

    public void setProyectoElegido(Proyecto proyectoElegido) {
        this.proyectoElegido = proyectoElegido;
    }

    public void setEstudianteElegido(Estudiante estudianteElegido) {
        this.estudianteElegido = estudianteElegido;
    }
}