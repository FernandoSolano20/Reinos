package ui;

import bl.Construccion.Construccion;
import bl.Construccion.FabricadorDeTropas;
import bl.Construccion.Fachada.Fachada;
import bl.Construccion.IConstruccion;
import bl.Construccion.Juego.Juego;
import bl.Construccion.Jugadores.Jugador;
import bl.Construccion.Tropa.TropaAtaque.Arquero;
import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;
import ui.FORMS.Form;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println(FabricadorDeTropas.procesarFuncion(1));
        System.out.println(FabricadorDeTropas.procesarFuncion(2));
        System.out.println(FabricadorDeTropas.procesarFuncion(3));
        System.out.println(FabricadorDeTropas.procesarFuncion(4));
        System.out.println(FabricadorDeTropas.procesarFuncion(5));
        System.out.println(FabricadorDeTropas.procesarFuncion(6));
        System.out.println(FabricadorDeTropas.procesarFuncion(7));
        System.out.println(FabricadorDeTropas.procesarFuncion(8));
        System.out.println(FabricadorDeTropas.procesarFuncion(9));
        System.out.println(FabricadorDeTropas.procesarFuncion(10));

        System.out.print("Cantidad de jugadores: ");
        int cantidad = Integer.parseInt(leer.readLine());

        Fachada fachada = new Fachada();

        Juego juego = fachada.construirJuego(cantidad);

        Construccion pieza = new Arquero();
        juego.getTablero().getCasillas()[0][1].setPieza(pieza);
        System.out.println(juego.getTablero().recorrerTablero());

       try{
           juego.getTablero().moverPieza(0,1,0,0);
       }catch (Exception e){
           System.out.println(e);
       }
        System.out.println(juego.getTablero().recorrerTablero());

        for(Jugador jugador : juego.getJugadores()){
            System.out.println(jugador.getNombreJugador());
        }


        /*JFrame inicio = new JFrame("App");
        inicio.setContentPane(new Form().getPanelInicio());
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.pack();
        inicio.setVisible(true);*/
    }
}
