package bl.Construccion.Fabricas;

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
