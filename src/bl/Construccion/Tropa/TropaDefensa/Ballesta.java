package bl.Construccion.Tropa.TropaDefensa;

import bl.Construccion.Tropa.Tropa;

public class Ballesta extends Tropa {
    public Ballesta() {
        setVida(3);
        setAtaque(2);
        setAlcance(2);
        setPrecio(5);
        setNombre("Ballesta");
    }

    @Override
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
}
