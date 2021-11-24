package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Utilidades {

    private static String CARPETA = "data";
    private static String FILE = CARPETA + File.separatorChar + "lexico1.properties";
    private Properties properties;

    public Utilidades() {
        cargarLoad();
    }

    public void cargarLoad() {
        try {
            Properties prop = new Properties();
            InputStream in = new FileInputStream(FILE);
            prop.load(in);
            properties = prop;

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en cargar datos " + e);
        }
    }

    public String[] operadoresAritmeticos() {
        return properties.getProperty("aritmeticos").split(",");
    }

    public boolean verificarChar(String[] data, String character) {
        return Arrays.asList(data).contains(character);
    }

    /*
     * private static void main(String[] args) { Utilidades u = new Utilidades();
     * System.out.println(u.operadoresAritmeticos().length);
     * System.out.println(u.verificarChar(u.operadoresAritmeticos(), "+")); }
     */

}