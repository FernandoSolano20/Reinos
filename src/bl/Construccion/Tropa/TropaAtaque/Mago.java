package bl.Construccion.Tropa.TropaAtaque;

import bl.Oro.Oro;

public class Mago extends TropaAtaque {
    public Mago() {
        super(2);
        setPrecio(10);
        setVida(10);
        setCantMovimientos(2);
        setDefensa(3);
        setAtaque(6);
        setAlcance(3);
        setNombre("Mago");
    }
}
