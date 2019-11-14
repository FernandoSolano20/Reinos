package bl.Construccion.Fabricas.FabricasTropasDefensa;

import bl.Construccion.Construccion;
import bl.Construccion.Fabricas.Abstracta.FabricaTropas;
import bl.Construccion.Tropa.TropaDefensa.Catapulta;

public class FabricaCatapulta implements FabricaTropas {
    @Override
    public Construccion crearTropa() {
        Catapulta catapulta =  new Catapulta();
        return catapulta;
    }
}
