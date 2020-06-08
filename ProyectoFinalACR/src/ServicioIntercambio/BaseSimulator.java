/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioIntercambio;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Fernando García
 */
public class BaseSimulator {
    private ArrayList<User> usuarios = new ArrayList<>();

    public BaseSimulator() {
        User user = new User(21221,"password");
        usuarios.add(user);
        user = new User(66606,"secure_pass");
        usuarios.add(user);
        user = new User(110797,"1@s7_us3r");
        usuarios.add(user);
    }

    public boolean UserExist(User user) {
        int ID = user.getUserID();
        int contador = 0;
        for(int i = 0; i < usuarios.size(); i++){
            if(ID == usuarios.get(i).getUserID()){
                //se encontró el usuario
                String passUser = usuarios.get(i).getPassword();
                if(user.getPassword().equals(passUser)){
                    contador += 1;
                }
            }
        }
        return contador != 0 && contador > 0;
    }
}
