package bl.Construccion.Tropa.TropaAtaque;

import bl.Construccion.Juego.VisitanteTropas.IVisitante;

public class Espia extends TropaAtaque {
    public Espia() {
        setPrecio(5);
        setVida(2);
        setCantMovimientos(5);
        setDefensa(1);
        setAtaque(1);
        setAlcance(3);
        setOroTransportable(10);
        setNombre("Espia");
    }

    @Override
    public void visitaRegeneracion(IVisitante pVisitante) {
        pVisitante.visitarTropaAtaque(this);
    }
}
