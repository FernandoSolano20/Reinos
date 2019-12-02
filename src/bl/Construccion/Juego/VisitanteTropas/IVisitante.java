package bl.Construccion.Juego.VisitanteTropas;

import bl.Construccion.Tropa.Tropa;
import bl.Construccion.Tropa.TropaAtaque.*;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;

import java.util.ArrayList;

public interface IVisitante {

    void visitarTropaAtaque(Arquero pTropa);

    void visitarTropaAtaque(Asesino pTropa);

    void visitarTropaAtaque(Bersequer pTropa);

    void visitarTropaAtaque(Espadachin pTropa);

    void visitarTropaAtaque(Espia pTropa);

    void visitarTropaAtaque(Jinete pTropa);

    void visitarTropaAtaque(Mago pTropa);

    void visitarGrupoTropas(ArrayList<Tropa> pTropas);
}
