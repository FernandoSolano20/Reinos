package bl.Construccion.Juego.Dado;

import java.util.Random;

public class Dado implements IDado{
    private int valor;
    private Random generadorRandom;

    public Dado() {
        setValor(0);
        setGeneradorRandom(new Random());
    }

    public int getValor() {
        return valor;
    }

    public Random getGeneradorRandom() {
        return generadorRandom;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setGeneradorRandom(Random generadorRandom) {
        this.generadorRandom = generadorRandom;
    }

    @Override
    public int tirarDado(){
        int valor = 0;
        valor = getGeneradorRandom().nextInt(6) + 1;
        setValor(valor);
        return valor;
    }
}
