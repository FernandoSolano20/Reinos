package bl.Construccion.Castillo;

import bl.Construccion.Construccion;

public class Castillo extends Construccion {
    private int oros;
    private int oroTransportable;

    public Castillo() {
        setNombre("Castillo");
        setVida(30);
        setOroTransportable(20);
        oros = 20;
    }

    public int getOros() {
        return oros;
    }

    public void setOros(int pOro) {
        this.oros = pOro;
    }

    public int getOroTransportable() {
        return oroTransportable;
    }

    public void setOroTransportable(int oroTransportable) {
        this.oroTransportable = oroTransportable;
    }
}
