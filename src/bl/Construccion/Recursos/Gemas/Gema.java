package bl.Construccion.Recursos.Gemas;

import bl.Construccion.Recursos.IRecurso;

public class Gema implements IRecurso {
    private String color;
    private int valor;

    public Gema(String color, int valor) {
        this.color = color;
        this.valor = valor;
    }

    public Gema() {
        this.color = "";
        this.valor = 0;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public void recogerRecurso() {

    }
}
