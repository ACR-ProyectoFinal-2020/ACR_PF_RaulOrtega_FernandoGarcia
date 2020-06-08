/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioIntercambio;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando García
 */
public class Servidor implements Runnable{    
    public static void main(String[] args){
        (new Thread(new Servidor())).start();
    }
    
    @Override
    public void run() {
        try {
            Interfaz fileManager = new RMI();
            Registry registro = LocateRegistry.createRegistry(1099);
            Naming.bind("rmi://localhost:1099/servicio", fileManager);
            System.out.println("Servidor RMI activo en localhost:1099/servicio...");
        } catch (RemoteException | AlreadyBoundException ex) {
        } catch (MalformedURLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
