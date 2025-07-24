package V2;

public class ConfiguracionEvento {
    private static ConfiguracionEvento instancia;

    private String versionSistema = "v1.0";
    private String plataforma = "Swing UI";
    private int maxParticipantes = 500;

    private ConfiguracionEvento() {
        System.out.println("🔧 Configuración del sistema inicializada.");
    }

    public static ConfiguracionEvento getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionEvento();
        }
        return instancia;
    }

    public void mostrarConfiguracion() {
        System.out.println("Versión: " + versionSistema);
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Máximo de participantes: " + maxParticipantes);
    }

    public void setMaxParticipantes(int max) {
        this.maxParticipantes = max;
    }
}
