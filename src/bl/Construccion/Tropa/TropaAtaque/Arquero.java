package bl.Construccion.Tropa.TropaAtaque;

public class Arquero extends TropaAtaque {
    public Arquero() {
        super(2);
        setPrecio(10);
        setVida(10);
        setCantMovimientos(3);
        setDefensa(3);
        setAtaque(3);
        setAlcance(4);
        setNombre("Arquero");
    }
}
