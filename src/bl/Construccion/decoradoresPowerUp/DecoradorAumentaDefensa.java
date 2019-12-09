package bl.Construccion.decoradoresPowerUp;

import bl.Construccion.Juego.VisitanteTropas.IVisitante;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;
import bl.Construccion.decorador.ObjetoDecorado;

public class DecoradorAumentaDefensa extends ObjetoDecorado {
    public DecoradorAumentaDefensa(TropaAtaque tropaAtaque) {
        this.cTropaAtaque = tropaAtaque;
        setPrecio(this.cTropaAtaque.getPrecio());
        setVida(this.cTropaAtaque.getVida());
        setCantMovimientos(this.cTropaAtaque.getPrecio());
        setDefensa(this.cTropaAtaque.getDefensa() + 2);
        setAtaque(this.cTropaAtaque.getAtaque());
        setAlcance(this.cTropaAtaque.getAlcance());
        setOroTransportable(this.cTropaAtaque.getOroTransportable());
        setNombre(this.cTropaAtaque.getNombre());
        setJugador(this.cTropaAtaque.getJugador());
        setCasilla(this.cTropaAtaque.getCasilla());
    }

    @Override
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public void visitaRegeneracion(IVisitante pVisitante) {
        pVisitante.visitarTropaAtaque(cTropaAtaque);
        getCasilla().setPieza(cTropaAtaque);
    }

    @Override
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
}
