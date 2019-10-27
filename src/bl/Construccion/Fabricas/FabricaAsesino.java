package bl.Construccion.Fabricas;

import bl.Construccion.Construccion;
import bl.Construccion.Fabricas.Abstracta.FabricaTropas;
import bl.Construccion.Tropa.TropaAtaque.Asesino;

public class FabricaAsesino implements FabricaTropas {
    @Override
    public Construccion crearTropa() {
        Asesino asesino=  new Asesino();
        return asesino;
    }
}
