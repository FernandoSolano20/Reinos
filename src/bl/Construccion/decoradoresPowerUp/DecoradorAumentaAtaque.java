package bl.Construccion.decoradoresPowerUp;

import bl.Construccion.Juego.VisitanteTropas.IVisitante;
import bl.Construccion.Tropa.Tropa;
import bl.Construccion.decorador.ObjetoDecorado;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;

import java.util.ArrayList;

public class DecoradorAumentaAtaque extends ObjetoDecorado {
    public DecoradorAumentaAtaque(TropaAtaque tropaAtaque) {
        this.cTropaAtaque = tropaAtaque;
        setPrecio(this.cTropaAtaque.getPrecio());
        setVida(this.cTropaAtaque.getVida());
        setCantMovimientos(this.cTropaAtaque.getPrecio());
        setDefensa(this.cTropaAtaque.getDefensa());
        setAtaque(this.cTropaAtaque.getAtaque() + 2);
        setAlcance(this.cTropaAtaque.getAlcance());
        setOroTransportable(this.cTropaAtaque.getOroTransportable());
        setNombre(this.cTropaAtaque.getNombre());
        setJugador(this.cTropaAtaque.getJugador());
        setCasilla(this.cTropaAtaque.getCasilla());
        setNombrePowerUp("Aumenta Ataque");
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
}
