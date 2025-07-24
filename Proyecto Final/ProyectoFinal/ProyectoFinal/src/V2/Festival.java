package V2;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.io.Serializable;

public class Festival extends Evento implements Serializable{
    private static final long serialVersionUID = 1L;

	
	public Festival(String nombre, LocalDate fecha, String lugar) {
        super(nombre, fecha, lugar);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("\n====== FESTIVAL ======");
        super.mostrarInfo();
    }
	
	

}
