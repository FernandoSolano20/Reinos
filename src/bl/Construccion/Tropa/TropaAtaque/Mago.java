package bl.Construccion.Tropa.TropaAtaque;

import bl.Construccion.Juego.VisitanteTropas.IVisitante;

public class Mago extends TropaAtaque {
    public Mago() {
        setPrecio(10);
        setVida(10);
        setCantMovimientos(2);
        setDefensa(3);
        setAtaque(6);
        setAlcance(3);
        setOroTransportable(2);
        setNombre("Mago");
    }

    @Override
    public void visitaRegeneracion(IVisitante pVisitante) {
        pVisitante.visitarTropaAtaque(this);
    }
}
