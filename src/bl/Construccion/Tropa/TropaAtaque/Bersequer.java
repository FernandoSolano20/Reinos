package bl.Construccion.Tropa.TropaAtaque;

public class Bersequer extends TropaAtaque {
    public Bersequer(int vida, int id, int alcance, int precio, int ataque, int cantMovimientos, int defensa, int oro) {
        super(vida, id, alcance, precio, ataque, cantMovimientos, defensa, oro);
        setNombre("Bersequer");
    }
}
