package bl.Construccion.Fabricas;

import bl.Construccion.*;
import bl.Construccion.Castillo.*;
import bl.Construccion.Fabricas.Abstracta.FabricaTropas;

public class FabricaCastillo implements FabricaTropas {
    @Override
    public Construccion crearTropa() {
        Castillo castillo =  new Castillo();
        return castillo;
    }
}
