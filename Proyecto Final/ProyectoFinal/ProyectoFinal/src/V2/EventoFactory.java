package V2;
import java.time.LocalDate;

public class EventoFactory {
	
	 public static Evento crearEvento(String tipo, String nombre, LocalDate fecha, String lugar) {
	        return switch (tipo.toLowerCase()) {
	            case "feria" -> new Feria(nombre, fecha, lugar);
	            case "festival" -> new Festival(nombre, fecha, lugar);
	            default -> throw new IllegalArgumentException("Tipo de evento inválido");
	        };
	    }

}
