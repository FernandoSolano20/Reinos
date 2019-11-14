package bl.Construccion.Fabricas.FabricasTropasAtaque;

import bl.Construccion.Construccion;
import bl.Construccion.Fabricas.Abstracta.FabricaTropas;
import bl.Construccion.Tropa.TropaAtaque.Espadachin;

public class FabricaEspadachin implements FabricaTropas {

    @Override
    public Construccion crearTropa() {
        Espadachin espadachin=  new Espadachin();
        return espadachin;
    }
}
