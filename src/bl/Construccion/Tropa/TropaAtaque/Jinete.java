package bl.Construccion.Tropa.TropaAtaque;

public class Jinete extends TropaAtaque {
    public Jinete() {
        super(6);
        setPrecio(15);
        setVida(10);
        setCantMovimientos(6);
        setDefensa(4);
        setAtaque(4);
        setAlcance(1);
        setNombre("Jinete");
    }
}
