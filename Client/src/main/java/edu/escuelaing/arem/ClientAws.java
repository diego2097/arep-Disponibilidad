package edu.escuelaing.arem;

/**
 * Hello world!
 *
 */
public class ClientAws 
{
     public static int clients = 1000;
    public static String url  = "http://54.236.159.234:4567/ordenar?cadena=";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        ClientThread[] threads = new ClientThread[clients];

        for (int i = 0; i < clients; i++) {
            threads[i] = new ClientThread(url);
        }
        for (int i = 0; i < clients; i++) {
            threads[i].start();
        }
        for (int i = 0; i < clients; i++) {
            threads[i].join();
        }
        System.out.println("Request finish");
    }
}
