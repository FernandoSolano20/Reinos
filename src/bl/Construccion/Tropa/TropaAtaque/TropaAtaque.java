package bl.Construccion.Tropa.TropaAtaque;

import bl.Construccion.Tropa.Tropa;
import bl.Oro.Oro;

import java.util.ArrayList;

public abstract class TropaAtaque extends Tropa {
    private int cantMovimientos;
    private int contador;
    private int defensa;
    private Oro[] oros;

    public TropaAtaque(int vida, int id, int alcance, int precio, int ataque, int cantMovimientos, int defensa, int oro) {
        super(vida, id, alcance, precio, ataque);
        setCantMovimientos(cantMovimientos);
        setDefensa(defensa);
        oros = new Oro[oro];
        contador = 0;
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

    public Oro[] getOros() {
        return oros;
    }

    public void setOros(Oro oro){
        if (contador < 20){
            oros[contador] = oro;
            contador++;
        }
    }

    public int getContador() {
        return contador;
    }

    public void setContador() {
        this.contador++;
    }
}
