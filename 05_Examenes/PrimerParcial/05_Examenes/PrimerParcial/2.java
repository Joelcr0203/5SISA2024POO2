import java.io.Serializable;

public abstract class Prendas implements Serializable {
    
    int talla;
    String  modelo;

    public Prendas(){

    }
    public Prendas( int modelo){
        this.modelo = modelo;
    }
    abstract String tipoPrendas(); 
}