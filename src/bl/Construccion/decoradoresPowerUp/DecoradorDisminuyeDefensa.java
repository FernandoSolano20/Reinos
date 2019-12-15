package bl.Construccion.decoradoresPowerUp;

import bl.Construccion.Juego.VisitanteTropas.IVisitante;
import bl.Construccion.Tropa.Tropa;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;
import bl.Construccion.decorador.ObjetoDecorado;

import java.util.ArrayList;

public class DecoradorDisminuyeDefensa extends ObjetoDecorado {
    private String nombrePowerUp;
    public DecoradorDisminuyeDefensa(TropaAtaque tropaAtaque) {
        this.cTropaAtaque = tropaAtaque;
        setPrecio(this.cTropaAtaque.getPrecio());
        setVida(this.cTropaAtaque.getVida());
        setCantMovimientos(this.cTropaAtaque.getPrecio());
        setDefensa(this.cTropaAtaque.getDefensa() - 2);
        setAtaque(this.cTropaAtaque.getAtaque());
        setAlcance(this.cTropaAtaque.getAlcance());
        setOroTransportable(this.cTropaAtaque.getOroTransportable());
        setNombre(this.cTropaAtaque.getNombre());
        setJugador(this.cTropaAtaque.getJugador());
        setCasilla(this.cTropaAtaque.getCasilla());
        setNombrePowerUp("Disminuye defensa");
    }

    @Override
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public void visitaRegeneracion(IVisitante pVisitante) {
        ArrayList<Tropa> tropas = this.getJugador().getTropas();
        tropas.remove(this);
        pVisitante.visitarTropaAtaque(cTropaAtaque);
        getCasilla().setPieza(cTropaAtaque);
        tropas.add(cTropaAtaque);
    }

    @Override
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public String getNombrePowerUp() {
        return nombrePowerUp;
    }

    public void setNombrePowerUp(String nombrePowerUp) {
        this.nombrePowerUp = nombrePowerUp;
    }
}
