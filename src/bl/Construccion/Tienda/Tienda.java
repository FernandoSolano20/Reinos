package bl.Construccion.Tienda;

import bl.Construccion.Excepciones.ExcepcionJuego;
import bl.Construccion.Fabricas.FabricadorDeTropas;
import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.Tropa.Tropa;

public class Tienda implements ITienda {
    @Override
        public String comprarTropa(Jugador pJugador, int pTipoTropa) throws Exception{
        String informacion = "";
        try{

            Tropa tropa = FabricadorDeTropas.procesarFuncion(pTipoTropa);

            if(tropa != null){
                acreditarTropa(pJugador,tropa);
                informacion = "La tropa ha sido comprada para "  + pJugador.getNombreJugador();
            }
            else{
                throw new ExcepcionJuego("La tropa obtenida de la fabrica es invalida");
            }

        }catch (Exception e){
            System.out.println("Error al comprar la tropa: " + e);
            informacion = "Error al comprar la tropa del " + pJugador.getNombreJugador();
        }

        return informacion;
    }

    private void acreditarTropa(Jugador pJugador, Tropa pTropa) throws Exception{

        int cantidadTropasActualesJugador = pJugador.getTropas().size();
        int cantidadOroJugador = pJugador.getCastillo().getOros();
        int precioTropa = pTropa.getPrecio();

        if(! validarCantidadTropas(cantidadTropasActualesJugador)){
            throw new ExcepcionJuego("El jugador se encuentra sobre el limite de tropas. Maximo 7");
        }

        else if(! validarOroDisponible(precioTropa, cantidadOroJugador)){
            throw new Exception("El " + pJugador.getNombreJugador() + " no posee suficiente oro");
        }
        else{
            pJugador.getTropas().add(pTropa);
            descontarOro(pJugador,precioTropa);
        }

    }


    private boolean validarCantidadTropas(int pCantidadTropas) {
        return pCantidadTropas < 7;
    }


    private boolean validarOroDisponible(int pValorTropa, int pOroDisponible) {
        return pValorTropa <= pOroDisponible;
    }


    private void descontarOro(Jugador pJugador, int pValorTropa) {
        int cantidadOro = pJugador.getCastillo().getOros();
        pJugador.getCastillo().setOros( cantidadOro - pValorTropa);
    }
}
