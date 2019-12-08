package bl.Construccion.Tropa.TropaDefensa;

import bl.Construccion.Tropa.Tropa;

public class Catapulta extends Tropa {
    public Catapulta() {
        setVida(3);
        setAtaque(5);
        setAlcance(2);
        setPrecio(8);
        setNombre("Catapulta");
    }

    @Override
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
}
