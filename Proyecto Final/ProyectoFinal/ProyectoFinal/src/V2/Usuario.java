package V2;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.io.Serializable;

public class Usuario implements Serializable{
	
    private static final long serialVersionUID = 1L;


	   private String nombre, email;

	    public Usuario(String nombre, String email) {
	        this.nombre = nombre;
	        this.email = email;
	    }

	    public String getNombre() { 
	    	return nombre; 
	    	}
	    public String getEmail() { 
	    	return email; 
	    	}
	    public String toString() { 
	    	return nombre + " (" + email + ")"; 
	    	}
}
