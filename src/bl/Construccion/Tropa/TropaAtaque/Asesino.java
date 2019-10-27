package bl.Construccion.Tropa.TropaAtaque;

public class Asesino extends TropaAtaque {
    public Asesino() {
        super(2);
        setPrecio(5);
        setVida(10);
        setCantMovimientos(4);
        setDefensa(3);
        setAtaque(3);
        setAlcance(2);
        setNombre("Asesino");
    }
}
