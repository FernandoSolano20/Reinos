package bl.Construccion.Tropa;

import bl.Construccion.Construccion;

public abstract class Tropa extends Construccion {
    private int alcance;
    private int precio;
    private int ataque;

    public Tropa() {
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
}
