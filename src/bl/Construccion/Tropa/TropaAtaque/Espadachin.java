package bl.Construccion.Tropa.TropaAtaque;

import bl.Construccion.Juego.VisitanteTropas.IVisitante;

public class Espadachin extends TropaAtaque {
    public Espadachin() {
        setPrecio(15);
        setVida(10);
        setCantMovimientos(2);
        setDefensa(5);
        setAtaque(6);
        setAlcance(1);
        setOroTransportable(2);
        setNombre("Espadachin");
    }

    @Override
    public void visitaRegeneracion(IVisitante pVisitante) {
        pVisitante.visitarTropaAtaque(this);
    }
}
