package bl.Construccion.Tropa.TropaAtaque;

import bl.Construccion.Juego.VisitanteTropas.IVisitante;

public interface ITropaAtaque {
    void movimientoTropa();
    void robarOro();
    void visitaRegeneracion(IVisitante pVisitante);
}
