package bl.Construccion.Tropa.TropaAtaque;

import bl.Construccion.Tropa.Tropa;

public abstract class TropaAtaque extends Tropa {
    private int cantMovimientos;
    private int oroTransportable;
    private int defensa;
    private int oros;

    public TropaAtaque() {
        oros = 0;
    }

    public int getCantMovimientos() {
        return cantMovimientos;
    }

    public void setCantMovimientos(int cantMovimientos) {
        this.cantMovimientos = cantMovimientos;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getOroTransportable() {
        return oroTransportable;
    }

    public void setOroTransportable(int oroTransportable) {
        this.oroTransportable = oroTransportable;
    }

    public int getOros() {
        return oros;
    }

    public void setOros(int sumOro) {
        if(oros < oroTransportable){
            int resultOro = oros + sumOro;
            if(resultOro > oroTransportable){
                oros = oroTransportable;
            }
            else {
                oros = resultOro;
            }
        }
    }
}
