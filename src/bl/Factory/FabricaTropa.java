package bl.Factory;

import bl.Construccion.Castillo;
import bl.Construccion.Construccion;
import bl.Construccion.Tropa.Ballesta;
import bl.Construccion.Tropa.Catapulta;
import bl.Construccion.Tropa.TropaAtaque.*;

public class FabricaTropa implements MetodoFabricaTropa {
    @Override
    public Construccion crearTropa(int vida, int id, int alcance, int precio, int ataque, int cantMovimientos, int defensa, int oro) {

        if (vida == 10 && ataque == 3 && alcance == 4 && precio == 10 && cantMovimientos == 3 && defensa == 3 && oro == 2){
            return new Arquero(vida, id, alcance, precio, ataque, cantMovimientos, defensa, oro);
        }
        else if (vida == 10 && ataque == 6 && alcance == 1 && precio == 15 && cantMovimientos == 2 && defensa == 5 && oro == 2){
            return new Espadachin(vida, id, alcance, precio, ataque, cantMovimientos, defensa, oro);
        }
        else if (vida == 15 && ataque == 10 && alcance == 2 && precio == 25 && cantMovimientos == 1 && defensa == 10 && oro == 6){
            return new Bersequer(vida, id, alcance, precio, ataque, cantMovimientos, defensa, oro);
        }
        else if (vida == 10 && ataque == 6 && alcance == 3 && precio == 10 && cantMovimientos == 2 && defensa == 3 && oro == 2){
            return new Mago(vida, id, alcance, precio, ataque, cantMovimientos, defensa, oro);
        }
        else if (vida == 10 && ataque == 3 && alcance == 2 && precio == 5 && cantMovimientos == 4 && defensa == 3 && oro == 2){
            return new Asesino(vida, id, alcance, precio, ataque, cantMovimientos, defensa, oro);
        }
        else if (vida == 10 && ataque == 4 && alcance == 1 && precio == 15 && cantMovimientos == 6 && defensa == 4 && oro == 6){
            return new Jinete(vida, id, alcance, precio, ataque, cantMovimientos, defensa, oro);
        }
        else if (vida == 2 && ataque == 1 && alcance == 3 && precio == 5 && cantMovimientos == 5 && defensa == 1 && oro == 10){
            return new Espia(vida, id, alcance, precio, ataque, cantMovimientos, defensa, oro);
        }
        return null;
    }

    @Override
    public Construccion crearTropa(int vida, int id, int oro) {
        if(vida == 30 && oro == 20){
            return new Castillo(vida, id, oro);
        }
        return  null;
    }

    @Override
    public Construccion crearTropa(int vida, int id, int alcance, int precio, int ataque) {
        if (vida == 3 && ataque == 2 && alcance == 2 && precio == 5){
            return new Ballesta(vida, id, alcance, precio, ataque);
        }
        else if (vida == 3 && ataque == 5 && alcance == 2 && precio == 8) {
            return new Catapulta(vida, id, alcance, precio, ataque);
        }
        return  null;
    }


}
