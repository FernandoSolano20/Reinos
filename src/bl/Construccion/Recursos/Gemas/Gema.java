package bl.Construccion.Recursos.Gemas;

import bl.Construccion.Recursos.IRecurso;
import bl.Construccion.Recursos.Oro.Oro;

public class Gema implements IRecurso {
    private String color;
    private Oro valor;

    public Gema(String color, int valor) {
        setColor(color);
        setValor(valor);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Oro getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = new Oro(valor);
    }

    @Override
    public void recogerRecurso() {

    }
}
