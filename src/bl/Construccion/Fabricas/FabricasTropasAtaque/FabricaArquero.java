package bl.Construccion.Fabricas.FabricasTropasAtaque;

import bl.Construccion.Construccion;
import bl.Construccion.Fabricas.Abstracta.FabricaTropas;
import bl.Construccion.Tropa.TropaAtaque.Arquero;


public class FabricaArquero implements FabricaTropas {
    @Override
    public Construccion crearTropa() {
        Arquero arquero =  new Arquero();
        return arquero;
    }
}
