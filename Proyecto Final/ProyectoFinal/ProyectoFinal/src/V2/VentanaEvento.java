package V2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;

public class VentanaEvento extends JFrame {
    private Evento evento;
    private JTextArea areaSalida;

    public VentanaEvento() {
        setTitle("Gestión de Evento");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Menú de opciones (Interfaz H-M con patrón Singleton)
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem mostrarConfig = new JMenuItem("Mostrar Configuración");
        mostrarConfig.setMnemonic(KeyEvent.VK_M); // Alt + M
        mostrarConfig.addActionListener(ev -> {
            ConfiguracionEvento config = ConfiguracionEvento.getInstancia();
            config.mostrarConfiguracion();
            areaSalida.append("⚙️ Mostrando configuración del sistema en consola.\n");
        });
        menu.add(mostrarConfig);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Área central de salida de texto
        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        add(new JScrollPane(areaSalida), BorderLayout.CENTER);

        // Panel izquierdo con botones
        JPanel panelBotones = new JPanel(new GridLayout(0, 1));
        agregarBoton(panelBotones, "Crear Feria", e -> crearEvento("feria"));
        agregarBoton(panelBotones, "Crear Festival", e -> crearEvento("festival"));
        agregarBoton(panelBotones, "Agregar Entrada", e -> agregarEntrada());
        agregarBoton(panelBotones, "Agregar Organizador", e -> agregarOrganizador());
        agregarBoton(panelBotones, "Agregar Decoración", e -> agregarDecoracion());
        agregarBoton(panelBotones, "Agregar Grupo Musical", e -> agregarGrupo());
        agregarBoton(panelBotones, "Inscribir Usuario", e -> inscribirUsuario());
        agregarBoton(panelBotones, "Mostrar Información", e -> mostrarInformacion());
        agregarBoton(panelBotones, "Guardar Evento", e -> guardarEvento());
        add(panelBotones, BorderLayout.WEST);
    }

    private void agregarBoton(JPanel panel, String texto, ActionListener al) {
        JButton boton = new JButton(texto);
        boton.addActionListener(al);
        panel.add(boton);
    }

    private void crearEvento(String tipo) {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del evento:");
            if (nombre == null || nombre.isEmpty()) return;

            String lugar = JOptionPane.showInputDialog("Lugar del evento:");
            if (lugar == null || lugar.isEmpty()) return;

            int anio = Integer.parseInt(JOptionPane.showInputDialog("Año del evento (ej. 2025):"));
            int mes = Integer.parseInt(JOptionPane.showInputDialog("Mes del evento (1-12):"));
            int dia = Integer.parseInt(JOptionPane.showInputDialog("Día del evento (1-31):"));

            LocalDate fecha = LocalDate.of(anio, mes, dia);
            evento = EventoFactory.crearEvento(tipo, nombre, fecha, lugar);
            areaSalida.append("✅ " + tipo.substring(0, 1).toUpperCase() + tipo.substring(1) + " creado para el " + fecha + "\n");
        } catch (Exception ex) {
            areaSalida.append("❌ Error al crear evento: " + ex.getMessage() + "\n");
        }
    }

    private void agregarEntrada() {
        if (evento == null) {
            areaSalida.append("⚠️ Primero debes crear un evento.\n");
            return;
        }
        try {
            String tipo = JOptionPane.showInputDialog("Tipo de entrada:");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
            evento.agregarEntradaSeguro(tipo, precio);
            areaSalida.append("➕ Entrada agregada.\n");
        } catch (Exception ex) {
            areaSalida.append("❌ Precio inválido.\n");
        }
    }

    private void agregarOrganizador() {
        if (evento == null) {
            areaSalida.append("⚠️ Primero debes crear un evento.\n");
            return;
        }
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del organizador:");
            String telefono = JOptionPane.showInputDialog("Teléfono:");
            evento.agregarOrganizador(new Organizador(nombre, telefono));
            areaSalida.append("👤 Organizador agregado.\n");
        } catch (Exception ex) {
            areaSalida.append("❌ Error al agregar organizador.\n");
        }
    }

    private void agregarDecoracion() {
        if (evento == null) {
            areaSalida.append("⚠️ Primero debes crear un evento.\n");
            return;
        }
        try {
            String tipo = JOptionPane.showInputDialog("Tipo de decoración:");
            double costo = Double.parseDouble(JOptionPane.showInputDialog("Costo:"));
            evento.agregarDecoracion(new Decoracion(tipo, costo));
            areaSalida.append("🎈 Decoración agregada.\n");
        } catch (Exception ex) {
            areaSalida.append("❌ Error al agregar decoración.\n");
        }
    }

    private void agregarGrupo() {
        if (evento == null) {
            areaSalida.append("⚠️ Primero debes crear un evento.\n");
            return;
        }
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del grupo musical:");
            String genero = JOptionPane.showInputDialog("Género musical:");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del grupo:"));
            evento.agregarGrupoMusical(new GrupoMusical(nombre, genero, precio));
            areaSalida.append("🎵 Grupo musical agregado.\n");
        } catch (Exception ex) {
            areaSalida.append("❌ Error al agregar grupo.\n");
        }
    }

    private void inscribirUsuario() {
        if (evento == null || evento.getEntradas().isEmpty()) {
            areaSalida.append("⚠️ Primero debes crear el evento y agregar entradas.\n");
            return;
        }
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del usuario:");
            String email = JOptionPane.showInputDialog("Email:");
            Usuario u = new Usuario(nombre, email);
            Entrada entrada = evento.getEntradas().get(0);
            Inscripcion insc = new Inscripcion(u, evento, entrada);
            areaSalida.append("📝 " + insc + "\n");
        } catch (Exception ex) {
            areaSalida.append("❌ Error al inscribir usuario.\n");
        }
    }

    private void mostrarInformacion() {
        if (evento == null) {
            areaSalida.append("⚠️ No hay evento creado aún.\n");
            return;
        }
        areaSalida.append("\n========= INFORMACIÓN DEL EVENTO =========\n");
        areaSalida.append(evento.getInformacionCompleta());
    }

    private void guardarEvento() {
        if (evento == null) {
            areaSalida.append("⚠️ No hay evento para guardar.\n");
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.home") + "/Escritorio/evento.dat"))) {
            oos.writeObject(evento);
            areaSalida.append("💾 Evento guardado correctamente en el escritorio.\n");
        } catch (IOException ex) {
            areaSalida.append("❌ Error al guardar: " + ex.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaEvento().setVisible(true));
    }
}