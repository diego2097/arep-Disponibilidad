/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author USUARIO
 */
public class ClientThread extends Thread{
   
    private String url;
    private String cadena = "Mateo%2CDaniel%2CPablo%2Calvaro%2Cadrian%2Cdavid%2Cdiego%2Cjavier"
            + "%2Cmario%2Csergio%2Cmarcos%2Cjesus%2Cana%2Cbolivar%2Csantiago%2Cjaime%2Cfernando"
            + "%2Czeus%2Cxiomara%2Ctorres%2Cpablomarcos%2Cmartin%2Cnicolas%2Civan%2Cjorge%2Ccarlos"
            + "%2Cfelipe%2Candres%2Ctomas%2Cjeronimo%2Cisabelle%2Candrea%2Cmichelle%2Cjulieta%2Cvenegas"
            + "%2Cjulian%2Coscar%2Cesteban%2Cjuan%2Cpepito%2Cperez%2Cmiguel%2Clucas%2Cabdel%2Cadib"
            + "%2Cakram%2Cbahir%2Cfarid%2Chabid%2Chakim%2Chasan%2Cjuanpablo%2Cibrahim%2Cjamal"
            + "%2Comar%2Cnader%2Crayan%2Cwalid%2Czaid%2Cangel%2Cgabriel%2Csimon%2Cthiago%2Cvalentin"
            + "%2Cbenjamin%2Cerick%2Cdante%2Cenzo%2Csilas%2Cariel%2Csantino%2Calonzo%2Cadriano%2Ccarlo"
            + "%2Cdonato%2Clorenzo%2Cguido%2Cluigi%2Cflavio%2Cleonardo%2Cluciano%2Cmaurizio%2Cpiero%2Cromeo";
    
    public ClientThread(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        String inputLine = null;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new URL(url + cadena).openStream()))) {
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine) ;
            }
            
        } catch (IOException x) {
            System.err.println(x);
        } 
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    } 
}
