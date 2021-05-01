package galeria;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import misclases.Habitacion;

public class main {


    public static void main(String[] args) {
        ArrayList<Habitacion> hab = new ArrayList<Habitacion>();
        hab.add(new Habitacion(true,"sencilla","112", "/imagenesHabitaciones/sencilla.jpg"));
        hab.add(new Habitacion(false,"doble","114", "/imagenesHabitaciones/doble.jpg"));
        hab.add(new Habitacion(false,"triple","116", "/imagenesHabitaciones/triple.jpg"));
        hab.add(new Habitacion(true,"triple","111", "/imagenesHabitaciones/triple2.jpg"));
          hab.add(new Habitacion(false,"sencilla","10", "/imagenesHabitaciones/sencilla.jpg"));
        FileOutputStream fs;
        ObjectOutputStream os = null;
        try {
            fs = new FileOutputStream("src/imagenesHabitaciones/registroHabitaciones.bin");
            os = new ObjectOutputStream(fs);
            for (int i = 0; i < hab.size(); i++) {
                os.writeObject(hab.get(i));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } finally{ 
            try {
                os.close();
            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  
        Ventana v= new Ventana();
        v.setVisible(true);
    }
    
}
