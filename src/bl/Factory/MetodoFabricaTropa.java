package bl.Factory;

import bl.Construccion.Construccion;

public interface MetodoFabricaTropa {
    public Construccion crearTropa(int vida, int id, int alcance, int precio, int ataque, int cantMovimientos, int defensa, int oro);
    public Construccion crearTropa(int vida, int id, int oro);
    public Construccion crearTropa(int vida, int id, int alcance, int precio, int ataque);
}
