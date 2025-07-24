package V2;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.io.Serializable;

public class Entrada implements Serializable{

	private static final long serialVersionUID = 1L;


    private String tipo;
    private double precio;

    public Entrada(String tipo, double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio de la entrada no puede ser negativo.");
        }
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }
    public String toString() { return tipo + ": " + precio + " Bs"; }
	

}
