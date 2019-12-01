package bl.Construccion.Tropa.TropaAtaque;

import bl.Construccion.Juego.VisitanteTropas.IVisitante;

public class Asesino extends TropaAtaque {
    public Asesino() {
        setPrecio(5);
        setVida(10);
        setCantMovimientos(4);
        setDefensa(3);
        setAtaque(3);
        setAlcance(2);
        setOroTransportable(2);
        setNombre("Asesino");
    }

    @Override
    public void visitaRegeneracion(IVisitante pVisitante) {
        pVisitante.visitarTropaAtaque(this);
    }
}
