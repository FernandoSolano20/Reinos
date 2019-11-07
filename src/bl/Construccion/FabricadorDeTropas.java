package bl.Construccion;

import bl.Construccion.Fabricas.*;
import bl.Construccion.Fabricas.Abstracta.FabricaTropas;
import bl.Construccion.Fabricas.FabricasTropasAtaque.*;
import bl.Construccion.Fabricas.FabricasTropasDefensa.FabricaBallesta;
import bl.Construccion.Fabricas.FabricasTropasDefensa.FabricaCatapulta;

public class FabricadorDeTropas {

    public static String procesarFuncion(int pOpc) {
        String sMensaje ="";
        FabricaTropas fabricaTropa;

        switch (pOpc) {

            case 1:
                fabricaTropa = new FabricaCastillo();
                sMensaje = CrearFabricaDeTropas(fabricaTropa);
                break;

            case 2:
                fabricaTropa = new FabricaBallesta();
                sMensaje = CrearFabricaDeTropas(fabricaTropa);
                break;

            case 3:
                fabricaTropa = new FabricaCatapulta();
                sMensaje = CrearFabricaDeTropas(fabricaTropa);
                break;

            case 4:
                fabricaTropa = new FabricaArquero();
                sMensaje = CrearFabricaDeTropas(fabricaTropa);
                break;

            case 5:
                fabricaTropa = new FabricaEspadachin();
                sMensaje = CrearFabricaDeTropas(fabricaTropa);
                break;

            case 6:
                fabricaTropa = new FabricaBersequer();
                sMensaje = CrearFabricaDeTropas(fabricaTropa);
                break;

            case 7:
                fabricaTropa = new FabricaMago();
                sMensaje = CrearFabricaDeTropas(fabricaTropa);
                break;

            case 8:
                fabricaTropa = new FabricaAsesino();
                sMensaje = CrearFabricaDeTropas(fabricaTropa);
                break;

            case 9:
                fabricaTropa = new FabricaJinete();
                sMensaje = CrearFabricaDeTropas(fabricaTropa);
                break;

            case 10:
                fabricaTropa = new FabricaEspia();
                sMensaje = CrearFabricaDeTropas(fabricaTropa);
                break;
        }

        return sMensaje ;

    }

    private static String CrearFabricaDeTropas(FabricaTropas pFabrica) {
        Construccion construccion = pFabrica.crearTropa();
        return construccion.getNombre();
    }
}
