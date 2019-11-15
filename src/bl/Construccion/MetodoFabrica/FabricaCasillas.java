package bl.Construccion.MetodoFabrica;

import bl.Construccion.Recursos.Gemas.Tipo.Azul;
import bl.Construccion.Recursos.Gemas.Tipo.Blanca;
import bl.Construccion.Recursos.Gemas.Tipo.Verde;
import bl.Construccion.Recursos.IRecurso;
import bl.Construccion.Recursos.PowerUps.Tipo.AumentaAtaque;
import bl.Construccion.Recursos.PowerUps.Tipo.AumentoDefensa;
import bl.Construccion.Recursos.PowerUps.Tipo.TrampaAtaque;
import bl.Construccion.Recursos.PowerUps.Tipo.TrampaDefensa;

public class FabricaCasillas implements MetodoFabrica{

    @Override
    public IRecurso crearGemas(int cantGema) {
        if(cantGema == 1){
            return new Blanca();
        }
        else if(cantGema == 2){
            return new  Azul();
        }
        else {
            return new Verde();
        }
    }

    @Override
    public IRecurso crearPowerUp(int powerUp) {
        if(powerUp == 1){
            return new AumentaAtaque();
        }
        else if(powerUp == 2){
            return new AumentoDefensa();
        }
        else if(powerUp == 3){
            return new TrampaAtaque();
        }
        else {
            return new TrampaDefensa();
        }
    }
}
