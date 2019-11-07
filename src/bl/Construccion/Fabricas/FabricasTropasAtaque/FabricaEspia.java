package bl.Construccion.Fabricas.FabricasTropasAtaque;

import bl.Construccion.Construccion;
import bl.Construccion.Fabricas.Abstracta.FabricaTropas;
import bl.Construccion.Tropa.TropaAtaque.Espia;

public class FabricaEspia implements FabricaTropas {
    @Override
    public Construccion crearTropa() {
        Espia espia=  new Espia();
        return espia;
    }
}
