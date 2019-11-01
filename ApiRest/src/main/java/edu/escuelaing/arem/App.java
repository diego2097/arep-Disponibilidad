package edu.escuelaing.arem;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

/**
 * API REST
 *
 */
public class App {

    public static void main(String[] args) {
       // secure("deploy/keystore.jks", "password", null, null);

        port(getPort());
        get("/multiplicar", (req, res) -> multiplicar(req, res));
        get("/dividir", (req, res) -> dividir(req, res));
        get("/sumar", (req, res) -> sumar(req, res));
        get("/restar", (req, res) -> restar(req, res));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    private static String multiplicar(Request rq, Response rp) {
        String response = Integer.toString(Integer.parseInt(rq.queryParams("num1")) * Integer.parseInt(rq.queryParams("num2")));
        return response;
    }

    private static String dividir(Request rq, Response rp) {
        String response = Integer.toString(Integer.parseInt(rq.queryParams("num1")) / Integer.parseInt(rq.queryParams("num2")));
        return response;
    }

    private static String sumar(Request rq, Response rp) {
        String response = Integer.toString(Integer.parseInt(rq.queryParams("num1")) + Integer.parseInt(rq.queryParams("num2")));
        return response;
    }

    private static String restar(Request rq, Response rp) {
        String response = Integer.toString(Integer.parseInt(rq.queryParams("num1")) - Integer.parseInt(rq.queryParams("num2")));
        return response;
    }
}
