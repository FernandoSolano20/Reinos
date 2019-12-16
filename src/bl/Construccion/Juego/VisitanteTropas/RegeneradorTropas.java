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
        pTropa.setAtaqueRealizado(false);
        pTropa.setMovimientoRealizado(false);
    }

    @Override
    public void visitarTropaAtaque(Asesino pTropa){
        pTropa.setDefensa(3);
        pTropa.setCantMovimientos(4);
        pTropa.setAtaqueRealizado(false);
        pTropa.setMovimientoRealizado(false);
    }

    @Override
    public void visitarTropaAtaque(Bersequer pTropa) {
        pTropa.setDefensa(10);
        pTropa.setCantMovimientos(1);
        pTropa.setAtaqueRealizado(false);
        pTropa.setMovimientoRealizado(false);
    }

    @Override
    public void visitarTropaAtaque(Espadachin pTropa) {
        pTropa.setDefensa(5);
        pTropa.setCantMovimientos(2);
        pTropa.setAtaqueRealizado(false);
        pTropa.setMovimientoRealizado(false);
    }

    @Override
    public void visitarTropaAtaque(Espia pTropa) {
        pTropa.setDefensa(1);
        pTropa.setCantMovimientos(5);
        pTropa.setAtaqueRealizado(false);
        pTropa.setMovimientoRealizado(false);
    }

    @Override
    public void visitarTropaAtaque(Jinete pTropa) {
        pTropa.setDefensa(4);
        pTropa.setCantMovimientos(6);
        pTropa.setAtaqueRealizado(false);
        pTropa.setMovimientoRealizado(false);
    }

    @Override
    public void visitarTropaAtaque(Mago pTropa) {
        pTropa.setDefensa(3);
        pTropa.setCantMovimientos(2);
        pTropa.setAtaqueRealizado(false);
        pTropa.setMovimientoRealizado(false);
    }

    @Override
    public void visitarTropaAtaque(TropaAtaque tropa) {
        if(tropa instanceof Arquero){
            visitarTropaAtaque((Arquero)tropa);
        }
        else if(tropa instanceof Asesino){
            visitarTropaAtaque((Asesino)tropa);
        }
        else if(tropa instanceof Bersequer){
            visitarTropaAtaque((Bersequer)tropa);
        }
        else if(tropa instanceof Espadachin){
            visitarTropaAtaque((Espadachin)tropa);
        }
        else if(tropa instanceof Espia){
            visitarTropaAtaque((Espia)tropa);
        }
        else if(tropa instanceof Jinete){
            visitarTropaAtaque((Jinete)tropa);
        }
        else if(tropa instanceof Mago){
            visitarTropaAtaque((Mago)tropa);
        }
    }

    @Override
    public void visitarGrupoTropas(ArrayList<Tropa> pTropas) {

        for(Tropa tropa:  pTropas){
            if( tropa instanceof TropaAtaque){
                ((TropaAtaque) tropa).visitaRegeneracion(this);
                ((TropaAtaque) tropa).setAtaqueRealizado(false);
            }
        }
    }
}
