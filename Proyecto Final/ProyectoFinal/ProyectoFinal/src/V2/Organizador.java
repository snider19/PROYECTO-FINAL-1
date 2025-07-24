package V2;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.io.Serializable;

public class Organizador implements Serializable{
    private static final long serialVersionUID = 1L;

	
	private String nombre, telefono;

    public Organizador(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() { 
    	return nombre; 
    	}
    public String getTelefono() { 
    	return telefono; 
    	}
    public String toString() { 
    	return nombre + " - " + telefono; 
    	}

}
