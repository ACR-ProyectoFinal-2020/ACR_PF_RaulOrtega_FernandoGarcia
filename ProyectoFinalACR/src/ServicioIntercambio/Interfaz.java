/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioIntercambio;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Fernando García
 */
public interface Interfaz extends Remote{
    File[] listarArchivos() throws RemoteException;
    byte[] obtenerArchivo(String nombre, String ruta) throws RemoteException;
    boolean conexion() throws RemoteException;
}
