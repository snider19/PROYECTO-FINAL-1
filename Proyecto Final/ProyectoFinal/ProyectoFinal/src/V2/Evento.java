package V2;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.io.Serializable;

public class Evento implements Serializable {	
	private static final long serialVersionUID = 1L;

	
	private String nombre, lugar;
    private LocalDate fecha;
    private List<Entrada> entradas = new ArrayList<>();
    private List<Organizador> organizadores = new ArrayList<>();
    private List<Decoracion> decoraciones = new ArrayList<>();
    private List<GrupoMusical> gruposMusicales = new ArrayList<>();

    public Evento(String nombre, LocalDate fecha, String lugar) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public String getNombre() { 
    	return nombre; 
    	}
    public LocalDate getFecha() { 
    	return fecha; 
    	}
    public String getLugar() { 
    	return lugar; 
    	}

    public void agregarEntrada(Entrada e) {
        entradas.add(e);
    }

    // Método seguro para agregar entrada
    public void agregarEntradaSeguro(String tipo, double precio) {
        try {
            Entrada e = new Entrada(tipo, precio);
            entradas.add(e);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error al agregar entrada: " + ex.getMessage());
        }
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void agregarOrganizador(Organizador o) {
        organizadores.add(o);
    }

    public void agregarDecoracion(Decoracion d) {
        decoraciones.add(d);
    }

    public void agregarGrupoMusical(GrupoMusical g) {
        gruposMusicales.add(g);
    }

    public void mostrarInfo() {
        System.out.println("Evento: " + nombre);
        System.out.println("Fecha: " + fecha);
        System.out.println("Lugar: " + lugar);
        System.out.println("\n--- Entradas ---");
        for (Entrada e : entradas) {
            System.out.println(e);
        }
        System.out.println("\n--- Organizadores ---");
        for (Organizador o : organizadores) {
            System.out.println(o);
        }
        System.out.println("\n--- Decoraciones ---");
        for (Decoracion d : decoraciones) {
            System.out.println(d);
        }
        System.out.println("\n--- Grupos Musicales ---");
        for (GrupoMusical g : gruposMusicales) {
            System.out.println(g);
        }
    }
    public String getInformacionCompleta() {
        StringBuilder sb = new StringBuilder();
        sb.append("Evento: ").append(nombre).append("\n");
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("Lugar: ").append(lugar).append("\n");

        sb.append("\n--- Entradas ---\n");
        for (Entrada e : entradas) sb.append(e).append("\n");

        sb.append("\n--- Organizadores ---\n");
        for (Organizador o : organizadores) sb.append(o).append("\n");

        sb.append("\n--- Decoraciones ---\n");
        for (Decoracion d : decoraciones) sb.append(d).append("\n");

        sb.append("\n--- Grupos Musicales ---\n");
        for (GrupoMusical g : gruposMusicales) sb.append(g).append("\n");

        return sb.toString();
    }


}
