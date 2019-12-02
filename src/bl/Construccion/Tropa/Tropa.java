package bl.Construccion.Tropa;

import bl.Construccion.Construccion;
import bl.Construccion.Cordenadas.CoordenasAtaque;
import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.Tablero.Casilla;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;

public abstract class Tropa extends Construccion {
    private int alcance;
    private int precio;
    private int ataque;
    private Jugador jugador;

    public Tropa() {
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }


    public boolean validarAtaque(int x1, int y1, int x2, int y2){
        int x = x1 - x2;
        int y = y1 - y2;
        boolean response = false;
        if(getAlcance() == 4){
            response = CoordenasAtaque.validarAtaqueAlcanze4(x,y);
        }
        else if(getAlcance() == 3){
            response = CoordenasAtaque.validarAtaqueAlcanze3(x,y);
        }
        else if(getAlcance() == 2) {
            response = CoordenasAtaque.validarAtaqueAlcanze2(x,y);
        }
        else if(getAlcance() == 1){
            response = CoordenasAtaque.validarAtaqueAlcanze1(x,y);
        }
        return response;
    }

    public void atacar(Tropa tropa){
        Casilla casillaAtacante = this.getCasilla();
        Casilla casillaAtacado = tropa.getCasilla();
        if(validarAtaque(casillaAtacante.getX(),casillaAtacante.getY(),casillaAtacado.getX(),casillaAtacado.getY())){
            if(tropa instanceof TropaAtaque){
                TropaAtaque tropaAtaque = (TropaAtaque) tropa;
                tropaAtaque.setDefensa(tropaAtaque.getDefensa() - this.getAtaque());
                if (tropaAtaque.getDefensa() < 0){
                    tropaAtaque.setVida(tropaAtaque.getVida() + tropaAtaque.getDefensa());
                    tropaAtaque.setDefensa(0);
                }
            }
            else {
                tropa.setVida(tropa.getVida() - this.getAtaque());
            }
        }
    }
}
