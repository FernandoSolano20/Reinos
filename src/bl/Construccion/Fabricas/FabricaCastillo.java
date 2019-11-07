package bl.Construccion.Fabricas;

import bl.Construccion.Castillo;
import bl.Construccion.Construccion;
import bl.Construccion.Fabricas.Abstracta.FabricaTropas;

public class FabricaCastillo implements FabricaTropas {
    @Override
    public Construccion crearTropa() {
        Castillo castillo =  new Castillo();
        return castillo;
    }
}
