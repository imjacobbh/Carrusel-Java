package galeria;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import misclases.FondoPanel;
import misclases.Habitacion;

public class Ventana extends javax.swing.JFrame implements ActionListener{

    JButton jButtonNext, jButtonPrev;
    JLabel  jLabelNumero,jLabelTipo;
    FondoPanel carrusel;
    ArrayList<Habitacion> disponibles;
    int index=0;
    private void configurarJFrame(){
        
        setSize(360, 300);
        setResizable(false);
        setLocationRelativeTo(null);//centrar
        //setLayout(null);
         super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        

    }
    public Ventana() {
        super("Galeria");
        initComponents();
        configurarJFrame();
    }

    private void initComponents()  {
        disponibles = new ArrayList<Habitacion>();
        //leer del archivo
        Habitacion aux;
        ObjectInputStream ois=null;
        try {
            FileInputStream fis = new FileInputStream("src/imagenesHabitaciones/registroHabitaciones.bin");
            ois = new ObjectInputStream(fis);
            for (;;) {
                aux = (Habitacion) ois.readObject();
                if(!aux.isOcupacion()){
                    disponibles.add(aux);
                }
            }
        } catch (EOFException e) {
            System.out.println("Fin de archivo");
        } catch (ClassNotFoundException e) {
            System.out.println("error");
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(!disponibles.isEmpty()){
        carrusel = new FondoPanel(disponibles.get(index).getRutaImagen());
        this.jLabelNumero = new JLabel(disponibles.get(index).getNumHabitacion());
        
        this.jLabelTipo = new JLabel(disponibles.get(index).getTipo());
        this.jLabelTipo.setForeground(Color.black);
        //this.jLabelTipo.setOpaque(true);
        this.jLabelTipo.setFont(new Font("Agency FB", Font.BOLD, 20));
        this.jLabelTipo.setBounds(200,0,50,20);
        this.jLabelNumero.setBounds(100, 0, 50, 20);
        this.jLabelNumero.setFont(new Font("Agency FB", Font.BOLD, 20));
        carrusel.setLayout(null);
        
        this.jButtonNext = new JButton(">");
        this.jButtonNext.setBounds(275, 135, 60, 30);
        this.jButtonPrev = new JButton("<");
        this.jButtonPrev.setBounds(10, 135, 60, 30);
        this.jButtonNext.addActionListener(this);
        this.jButtonPrev.addActionListener(this);
        carrusel.add(jButtonPrev);
        carrusel.add(jButtonNext);
        carrusel.add(this.jLabelNumero);
        carrusel.add(this.jLabelTipo);
         super.getContentPane().add(this.carrusel);
        }
        else{  
            carrusel = new FondoPanel("/imagenesHabitaciones/error.jpg");
            super.getContentPane().add(this.carrusel);
            JOptionPane.showConfirmDialog(null, "No hay habitaciones disponibles"); 
        }
      
       }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.jButtonNext){
            index++;
            if(index>= disponibles.size())
                index=0;
        }
        if(e.getSource()==this.jButtonPrev){
            if(index == 0){
                index = disponibles.size()-1;
            }
        }
        this.carrusel.setRuta(disponibles.get(index).getRutaImagen());
        
        this.jLabelTipo.setText(disponibles.get(index).getTipo());
        this.jLabelNumero.setText(disponibles.get(index).getNumHabitacion());
    }
}
