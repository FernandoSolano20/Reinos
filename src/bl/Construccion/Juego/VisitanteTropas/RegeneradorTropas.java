package bl.Construccion.Juego.VisitanteTropas;

import bl.Construccion.Tropa.Tropa;
import bl.Construccion.Tropa.TropaAtaque.*;

import java.util.ArrayList;

public class RegeneradorTropas implements IVisitante {


    public RegeneradorTropas() {
    }

    @Override
    public void visitarTropaAtaque(Arquero pTropa) {
        pTropa.setDefensa(3);
        pTropa.setCantMovimientos(3);
    }

    @Override
    public void visitarTropaAtaque(Asesino pTropa){
        pTropa.setDefensa(3);
        pTropa.setCantMovimientos(4);
    }

    @Override
    public void visitarTropaAtaque(Bersequer pTropa) {
        pTropa.setDefensa(10);
        pTropa.setCantMovimientos(1);
    }

    @Override
    public void visitarTropaAtaque(Espadachin pTropa) {
        pTropa.setDefensa(5);
        pTropa.setCantMovimientos(2);
    }

    @Override
    public void visitarTropaAtaque(Espia pTropa) {
        pTropa.setDefensa(1);
        pTropa.setCantMovimientos(5);
    }

    @Override
    public void visitarTropaAtaque(Jinete pTropa) {
        pTropa.setDefensa(4);
        pTropa.setCantMovimientos(6);
    }

    @Override
    public void visitarTropaAtaque(Mago pTropa) {
        pTropa.setDefensa(3);
        pTropa.setCantMovimientos(2);
    }

    @Override
    public void visitarGrupoTropas(ArrayList<Tropa> pTropas) {

        for(Tropa tropa:  pTropas){
            if( tropa instanceof TropaAtaque){
                ((TropaAtaque) tropa).visitaRegeneracion(this);
            }
        }
    }
}
