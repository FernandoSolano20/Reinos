package bl.Construccion.Tienda;

import bl.Construccion.Excepciones.ExcepcionJuego;
import bl.Construccion.Fabricas.FabricadorDeTropas;
import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.Tropa.Tropa;

public class Tienda implements ITienda {
    @Override
        public boolean comprarTropa(Jugador pJugador, int pTipoTropa) throws Exception{
        boolean compraRealizada = false;
        try{

            Tropa tropa = FabricadorDeTropas.procesarFuncion(pTipoTropa);

            if(tropa != null){
                acreditarTropa(pJugador,tropa);
                compraRealizada = true;
            }
            else{
                throw new ExcepcionJuego("La tropa obtenida de la fabrica es invalida");
            }

        }catch (Exception e){
            System.out.println("Error al comprar la tropa: " + e);
        }

        return compraRealizada;
    }

    private void acreditarTropa(Jugador pJugador, Tropa pTropa) throws Exception{

        int cantidadTropasActualesJugador = pJugador.getTropas().size();
        int cantidadOroJugador = pJugador.getCastillo().getOros();
        int precioTropa = pTropa.getPrecio();

        if(! validarCantidadTropas(cantidadTropasActualesJugador)){
            throw new ExcepcionJuego("El jugador se encuentra sobre el limite de tropas. Maximo 7");
        }

        else if(! validarOroDisponible(precioTropa, cantidadOroJugador)){
            throw new ExcepcionJuego("El " + pJugador.getNombreJugador() + " no posee suficiente oro");
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
