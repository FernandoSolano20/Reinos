package bl.Construccion.Fabricas;

import bl.Construccion.Construccion;
import bl.Construccion.Fabricas.Abstracta.FabricaTropas;
import bl.Construccion.Tropa.Ballesta;

public class FabricaBallesta implements FabricaTropas {
    @Override
    public Construccion crearTropa() {
        Ballesta ballesta=  new Ballesta();
        return ballesta;
    }
}
