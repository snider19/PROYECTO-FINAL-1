package V2;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.io.Serializable;

public class Inscripcion implements Serializable{
	
    private static final long serialVersionUID = 1L;

	
	private Usuario usuario;
    private Evento evento;
    private Entrada entrada;

    public Inscripcion(Usuario usuario, Evento evento, Entrada entrada) {
        if (usuario == null || evento == null || entrada == null) {
            throw new IllegalArgumentException("Ningún dato puede ser nulo para la inscripción.");
        }
        this.usuario = usuario;
        this.evento = evento;
        this.entrada = entrada;
    }

    public String toString() {
        return "Inscripción: " + usuario.getNombre() + " en " + evento.getNombre() + " con entrada " + entrada.getTipo();
    }
}
