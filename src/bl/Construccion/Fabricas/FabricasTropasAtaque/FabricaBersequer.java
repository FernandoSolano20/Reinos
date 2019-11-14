package bl.Construccion.Fabricas.FabricasTropasAtaque;

import bl.Construccion.Construccion;
import bl.Construccion.Fabricas.Abstracta.FabricaTropas;
import bl.Construccion.Tropa.TropaAtaque.Bersequer;

public class FabricaBersequer implements FabricaTropas {
    @Override
    public Construccion crearTropa() {
        Bersequer bersequer =  new Bersequer();
        return bersequer;
    }
}
