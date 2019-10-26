package bl.Construccion.Tropa.TropaAtaque;

import bl.Oro.Oro;

public class Mago extends TropaAtaque {
    public Mago(int vida, int id, int alcance, int precio, int ataque, int cantMovimientos, int defensa, int oro) {
        super(vida, id, alcance, precio, ataque, cantMovimientos, defensa, oro);
        setNombre("Mago");
    }
}
