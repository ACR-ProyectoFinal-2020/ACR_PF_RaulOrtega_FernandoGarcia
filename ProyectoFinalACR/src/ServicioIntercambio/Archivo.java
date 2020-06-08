/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioIntercambio;

import java.io.File;

/**
 *
 * @author Fernando García
 */
public class Archivo {
    private final File archivo;
    private int permiso;
    
    public Archivo(File file, int permiso){
        this.archivo = file;
        this.permiso = permiso;
    }

    public File getArchivo() {
        return archivo;
    }

    public int getPermiso() {
        return permiso;
    }

    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }
}
