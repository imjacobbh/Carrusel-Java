
package misclases;

import java.io.Serializable;


public class Habitacion implements Serializable{
    private boolean ocupacion;
    private String tipo;
    private String numHabitacion;
    private String rutaImagen;

    public Habitacion(boolean ocupacion, String tipo, String numHabitacion, String rutaImagen){
        this.ocupacion = ocupacion;
        this.tipo = tipo;
        this.numHabitacion = numHabitacion;
        this.rutaImagen = rutaImagen;
    }

    public boolean isOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(boolean ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(String numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
}
