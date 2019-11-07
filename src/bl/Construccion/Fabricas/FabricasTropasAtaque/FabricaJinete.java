package bl.Construccion.Fabricas.FabricasTropasAtaque;

import bl.Construccion.Construccion;
import bl.Construccion.Fabricas.Abstracta.FabricaTropas;
import bl.Construccion.Tropa.TropaAtaque.Jinete;

public class FabricaJinete implements FabricaTropas {
    @Override
    public Construccion crearTropa() {
        Jinete jinete =  new Jinete();
        return jinete;
    }
}
