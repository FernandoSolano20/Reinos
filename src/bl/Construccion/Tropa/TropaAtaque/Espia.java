package bl.Construccion.Tropa.TropaAtaque;

public class Espia extends TropaAtaque {
    public Espia() {
        super(10);
        setPrecio(5);
        setVida(2);
        setCantMovimientos(5);
        setDefensa(1);
        setAtaque(1);
        setAlcance(3);
        setNombre("Espia");
    }
}
