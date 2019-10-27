package bl.Construccion.Castillo;

import bl.Construccion.Construccion;
import bl.Oro.Oro;

import java.util.ArrayList;

public class Castillo extends Construccion {
    private Oro[] oros;
    private int contador;

    public Castillo() {
        setNombre("Castillo");
        setVida(30);
        oros = new Oro[20];
        contador = 0;
    }

    public Oro[] getOros() {
        return oros;
    }

    public void setOros(Oro oro) {
        if(contador < 20){
            this.oros[contador] = oro;
        }
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
