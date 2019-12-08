package bl.Construccion.Tropa.TropaAtaque;

import bl.Construccion.Juego.VisitanteTropas.IVisitante;

public class Arquero extends TropaAtaque {
    public Arquero() {
        setPrecio(10);
        setVida(10);
        setCantMovimientos(3);
        setDefensa(3);
        setAtaque(3);
        setAlcance(4);
        setOroTransportable(2);
        setNombre("Arquero");
    }

    @Override
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    @Override
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public void visitaRegeneracion(IVisitante pVisitante) {
        pVisitante.visitarTropaAtaque(this);
    }
}
