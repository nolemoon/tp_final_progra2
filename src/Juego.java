public final class Juego extends AbstractProducto{

    // Atributos
    private String requisitosMinimos; // Y si usamos un array de requisitos por separado?
    private boolean multiplayer;

    // Constructor
    // TODO: añadir llamado al constructor super + sus atributos.
    public Juego() {
    }

    public Juego(String requisitosMinimos, boolean multiplayer) {
        this.requisitosMinimos = requisitosMinimos;
        this.multiplayer = multiplayer;
    }

    // Getter y Setter
    public String getRequisitosMinimos() {
        return requisitosMinimos;
    }

    public void setRequisitosMinimos(String requisitosMinimos) {
        this.requisitosMinimos = requisitosMinimos;
    }

    public boolean isMultiplayer() {
        return multiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        this.multiplayer = multiplayer;
    }

    // To String
    // TODO: Invocar al Super To String
    @Override
    public String toString() {
        return "Juego{" +
                "requisitosMinimos='" + requisitosMinimos + '\'' +
                ", multiplayer=" + multiplayer +
                '}';
    }

}
