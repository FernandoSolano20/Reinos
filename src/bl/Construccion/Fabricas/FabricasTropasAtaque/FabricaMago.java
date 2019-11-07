package bl.Construccion.Fabricas.FabricasTropasAtaque;

import bl.Construccion.Construccion;
import bl.Construccion.Fabricas.Abstracta.FabricaTropas;
import bl.Construccion.Tropa.TropaAtaque.Mago;

public class FabricaMago implements FabricaTropas {
    @Override
    public Construccion crearTropa() {
        Mago mago =  new Mago();
        return mago;
    }
}
