package edu.escuelaing.arem;

import java.util.ArrayList;
import java.util.Collections;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

/**
 * API REST
 *
 */
public class App {

    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> index(req, res));
        get("/ordenar", (req, res) -> ordenar(req, res));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    private static String index(Request rq, Response rp) {
        String pagina = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<body>\n"
                + "<h1>Ordenador de cadenas</h1>\n"
                + "<p>Dada una lista de cadenas, el programa las ordena en orden alfabetico.</p>\n"
                + "<form action=\"/ordenar\">"
                + "Ingrese la lista separada por comas:<br>\n"
                + "<input type=\"text\" name=\"cadena\" placeholder=\"cadena\"><br>\n"
                + "<input type=\"submit\" value=\"Ordenar\">\n"
                + "</form>\n"
                + "</body>\n"
                + "</html>\n";
        return pagina;
    }

    private static String ordenar(Request rq, Response rp) {
        String response = rq.queryParams("cadena");
        String[] parts = response.split(",");
        ArrayList<String> lista = new ArrayList<String>();
        for (int i = 0; i < parts.length; i++) {
            lista.add(parts[i]);
        }
        Collections.sort(lista);
       
        String cad = lista.get(0);
        for (int i = 1; i < lista.size(); i++) {
            cad = cad + "," + lista.get(i);
        }
         String pagina = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<body>\n"
                + "<h2>lista ordenada en orden alfabetico </h2>\n"
                + cad 
                + "<form action=\"/\">"
                + "<input type=\"submit\" value=\"volver\">\n"
                + "</form>\n"
                + "</body>\n"
                + "</html>\n";
        return pagina;
    }
}
