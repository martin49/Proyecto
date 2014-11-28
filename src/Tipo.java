/**
 * Created by nacedo on 11-24-14.
 */
public class Tipo {
    public String nombre;
    public String tipo;

    public Tipo(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
