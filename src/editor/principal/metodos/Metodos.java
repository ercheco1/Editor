package editor.principal.metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Erik Guzman
 * @date 07/07/2018
 */
public class Metodos {

    public String abrir(String ruta) {
        String contenedor = "Hola", cadena;
        try {
            FileReader leer = new FileReader(ruta);
            BufferedReader bufer = new BufferedReader(leer);
            while ((cadena = bufer.readLine()) != null) {
                contenedor += (cadena + "\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return contenedor;
    }

    public boolean limpiar(String ruta) {
        String contenedor = "", cadena;
        try {
            FileWriter escribir = new FileWriter(ruta);
            BufferedWriter bufer = new BufferedWriter(escribir);
            bufer.write("");
            bufer.close();
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }
    public boolean guardar(String ruta,String texto){
        this.limpiar(ruta);
        try {
            FileWriter escribir = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(escribir);
            pw.print(texto);
            escribir.close();
            this.abrir(ruta);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
