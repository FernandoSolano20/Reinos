package bl.Construccion.Fabricas.FabricasTropasDefensa;

import bl.Construccion.Construccion;
import bl.Construccion.Fabricas.Abstracta.FabricaTropas;
import bl.Construccion.Tropa.TropaDefensa.Ballesta;

public class FabricaBallesta implements FabricaTropas {
    @Override
    public Construccion crearTropa() {
        Ballesta ballesta=  new Ballesta();
        return ballesta;
    }
}
