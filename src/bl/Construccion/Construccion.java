package bl.Construccion;

public abstract class Construccion {
    private int vida;
    private int id;
    private String Nombre;

    public Construccion(int vida, int id) {
        setVida(vida);
        setId(id);
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
