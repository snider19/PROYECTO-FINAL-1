package V2;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.io.Serializable;

public class GrupoMusical implements Serializable {
    private static final long serialVersionUID = 1L;

	
	  private String nombre, genero;
	    private double precio;

	    public GrupoMusical(String nombre, String genero, double precio) {
	        this.nombre = nombre;
	        this.genero = genero;
	        this.precio = precio;
	    }

	    public String getNombre() { 
	    	return nombre; 
	    	}
	    public String getGenero() {
	    	return genero; 
	    	}
	    public double getCache() { 
	    	return precio; 
	    	}
	    public String toString() { 
	    	return nombre + " (" + genero + ") - " + precio + " Bs"; 
	    	}

}
