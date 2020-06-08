/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioIntercambio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Fernando García
 */
public final class User {

    private final int userID;
    private final String password;
    private final String pass;

    public User(int uID, String pass) {
        this.pass = pass;
        this.userID = uID;
        this.password = setPasswordEncripted(this.pass);
    }

    public String setPasswordEncripted(String password) {
        MessageDigest md;
        md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }

        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

    public void printHashedPass() {
        System.out.println(this.password);
    }

    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public boolean compareHash(String externo, String interno) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] hash = md.digest(interno.getBytes());
        StringBuffer sb = new StringBuffer();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        String cadena = sb.toString();

        if (cadena.equals(externo)) {
            return true;
        } else {
            return false;
        }
    }
}
