package model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Persona {

    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty apellidos = new SimpleStringProperty();
    private String imagenPath;

    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }

    public String getImagenPath() {
        return imagenPath;
    }

    public Persona(String nombre, String apellidos, String imagenPath)
    {
        this.nombre.setValue(nombre);
        this.apellidos.setValue(apellidos);
        this.imagenPath = imagenPath;
    }

    public  StringProperty NombreProperty() {
            return this.nombre;
    }
    public String getNombre() {
            return this.NombreProperty().get();
    }
    public final void setNombre(String Nombre) {
            this.NombreProperty().set(Nombre);
    }
    public  StringProperty ApellidosProperty() {
            return this.apellidos;
    }
    public String getApellidos() {
            return this.ApellidosProperty().get();
    }
    public  void setApellidos(String Apellidos) {
            this.ApellidosProperty().set(Apellidos);
    }
}