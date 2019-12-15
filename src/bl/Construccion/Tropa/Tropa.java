package bl.Construccion.Tropa;

import bl.Construccion.Castillo.Castillo;
import bl.Construccion.Construccion;
import bl.Construccion.Coordenadas.CoordenasAtaque;
import bl.Construccion.Juego.Juego;
import bl.Construccion.Tablero.Casilla;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;

import java.util.ArrayList;

public abstract class Tropa extends Construccion {
    private int alcance;
    private int precio;
    protected int ataque;
    private boolean ataqueRealizado;
    private boolean enJuego;
    private boolean movimientoRealizado;

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

    public boolean isEnJuego() {
        return enJuego;
    }

    public void setEnJuego(boolean enJuego) {
        this.enJuego = enJuego;
    }

    public abstract void setAtaque(int ataque);

    public boolean isAtaqueRealizado() {
        return ataqueRealizado;
    }

    public void setAtaqueRealizado(boolean ataqueRealizado) {
        this.ataqueRealizado = ataqueRealizado;
    }

    public boolean isMovimientoRealizado() {
        return movimientoRealizado;
    }

    public void setMovimientoRealizado(boolean movimientoRealizado) {
        this.movimientoRealizado = movimientoRealizado;
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

    public String atacar(Construccion construccion){
        String msg = "No se pudo atacar";
        Casilla casillaAtacante = this.getCasilla();
        Casilla casillaAtacado = construccion.getCasilla();
        if(validarAtaque(casillaAtacante.getX(),casillaAtacante.getY(),casillaAtacado.getX(),casillaAtacado.getY())){
            this.setAtaqueRealizado(true);
            if(construccion instanceof TropaAtaque){
                TropaAtaque tropaAtaque = (TropaAtaque) construccion;
                tropaAtaque.setDefensa(tropaAtaque.getDefensa() - this.getAtaque());
                if (tropaAtaque.getDefensa() < 0){
                    tropaAtaque.setVida(tropaAtaque.getVida() + tropaAtaque.getDefensa());
                    tropaAtaque.setDefensa(0);
                }
                msg = "Tropa: " + tropaAtaque.getNombre() + " es atacada por" + this.getNombre() +
                        "\nEstadísticas de " + tropaAtaque.getNombre()  +
                        "\nDefensa: " + tropaAtaque.getDefensa() +
                        "\nVida: " + tropaAtaque.getVida();
            }
            else {
                construccion.setVida(construccion.getVida() - this.getAtaque());
                msg = "Tropa: " + construccion.getNombre() + " es atacada por" + this.getNombre() +
                        "\nEstadísticas de " + construccion.getNombre()  +
                        "\nVida: " + construccion.getVida();
            }
            if (construccion.getVida() <= 0){
                if (construccion instanceof Castillo){
                    Juego juego = Juego.juegoActual;
                    juego.getJugadores().remove(construccion.getJugador());
                    construccion.getCasilla().setPieza(null);
                    msg = "Jugador " + construccion.getJugador().getNombreJugador() + " perdió";
                    juego.finalizarPartida();
                }
                else {
                    ArrayList<Tropa> tropas = construccion.getJugador().getTropas();
                    tropas.remove(construccion);
                    construccion.getCasilla().setPieza(null);
                    msg = "Jugador " + construccion.getJugador().getNombreJugador() + " " +
                            "perdió la tropa: " + construccion.getNombre();
                }
            }
        }
        return msg;
    }
}
