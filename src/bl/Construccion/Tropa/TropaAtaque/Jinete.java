package bl.Construccion.Tropa.TropaAtaque;

import bl.Construccion.Juego.VisitanteTropas.IVisitante;

public class Jinete extends TropaAtaque {
    public Jinete() {
        setPrecio(15);
        setVida(10);
        setCantMovimientos(6);
        setDefensa(4);
        setAtaque(4);
        setAlcance(1);
        setOroTransportable(6);
        setNombre("Jinete");
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
