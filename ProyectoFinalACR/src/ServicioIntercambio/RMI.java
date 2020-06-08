/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioIntercambio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Fernando García
 */
public class RMI extends UnicastRemoteObject implements Interfaz{
    public static String PATH = "Servidor/";
    private boolean conexion = false;

    public RMI() throws RemoteException {
        super();
    }
    
    @Override
    public  boolean conexion() throws RemoteException{
        this.conexion = true;
        return this.conexion;
    }

    @Override
    public File[] listarArchivos() throws RemoteException {
        File file = new File(PATH);
        File[] archivos = file.listFiles();
        return archivos;
    }

    @Override
    public byte[] obtenerArchivo(String name, String ruta) throws RemoteException {
        byte[] filebytes = null;
        String path = ruta + name;
        FileInputStream fileInput = null;
        BufferedInputStream bufferedInput = null;
        try {
            File file = new File(path);
            fileInput = new FileInputStream(file);
            bufferedInput = new BufferedInputStream(fileInput);
            filebytes = new byte[(int) file.length()];
            bufferedInput.read(filebytes, 0, filebytes.length);
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException ex) {
            return null;
        }
        return filebytes;
    }
}
