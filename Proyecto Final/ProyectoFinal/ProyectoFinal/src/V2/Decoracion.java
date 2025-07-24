package V2;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.io.Serializable;

public class Decoracion implements Serializable{
	
    private static final long serialVersionUID = 1L;


	private String tipo;
    private double costo;

    public Decoracion(String tipo, double costo) {
        this.tipo = tipo;
        this.costo = costo;
    }

    public String getTipo() { return tipo; }
    public double getCosto() { return costo; }
    public String toString() { return tipo + " - " + costo + " Bs"; }
}
