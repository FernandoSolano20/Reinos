package bl.Construccion.Fabricas;

import bl.Construccion.Fabricas.Abstracta.FabricaTropas;
import bl.Construccion.Fabricas.FabricasTropasAtaque.*;
import bl.Construccion.Fabricas.FabricasTropasDefensa.FabricaBallesta;
import bl.Construccion.Fabricas.FabricasTropasDefensa.FabricaCatapulta;
import bl.Construccion.Tropa.Tropa;
import bl.Construccion.Tropa.TropaAtaque.Arquero;

public class FabricadorDeTropas {

    public static Tropa procesarFuncion(int pOpc) {
        FabricaTropas fabricaTropa;
        Tropa tropa = new Arquero();

        try{

            switch (pOpc) {

                case 1:
                {
                    fabricaTropa = new FabricaBallesta();
                    tropa = CrearTropa(fabricaTropa);
                    break;
                }

                case 2:
                {
                    fabricaTropa = new FabricaCatapulta();
                    tropa = CrearTropa(fabricaTropa);
                    break;
                }

                case 3:
                {
                    fabricaTropa = new FabricaArquero();
                    tropa = CrearTropa(fabricaTropa);
                    break;
                }

                case 4:
                {
                    fabricaTropa = new FabricaEspadachin();
                    tropa = CrearTropa(fabricaTropa);
                    break;
                }

                case 5:
                {
                    fabricaTropa = new FabricaBersequer();
                    tropa = CrearTropa(fabricaTropa);
                    break;
                }

                case 6:
                {
                    fabricaTropa = new FabricaMago();
                    tropa = CrearTropa(fabricaTropa);
                    break;
                }

                case 7:
                {
                    fabricaTropa = new FabricaAsesino();
                    tropa = CrearTropa(fabricaTropa);
                    break;
                }

                case 8:
                {
                    fabricaTropa = new FabricaJinete();
                    tropa = CrearTropa(fabricaTropa);
                    break;
                }

                case 9:
                {
                    fabricaTropa = new FabricaEspia();
                    tropa = CrearTropa(fabricaTropa);
                    break;
                }

            }
        }catch (Exception e){
            System.out.println("Error al fabricar la pieza: " + e);
        }


        return tropa;
    }

    private static Tropa CrearTropa(FabricaTropas pFabrica) {
        Tropa tropa = (Tropa) pFabrica.crearTropa();
        return tropa;
    }
}
