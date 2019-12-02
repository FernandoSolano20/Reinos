package bl.Construccion.Tropa.TropaAtaque;

import bl.Construccion.Juego.VisitanteTropas.IVisitante;

public class Bersequer extends TropaAtaque {
    public Bersequer() {
        setPrecio(25);
        setVida(15);
        setCantMovimientos(1);
        setDefensa(10);
        setAtaque(10);
        setAlcance(2);
        setOroTransportable(6);
        setNombre("Bersequer");
    }

    @Override
    public void visitaRegeneracion(IVisitante pVisitante) {
        pVisitante.visitarTropaAtaque(this);
    }
}
