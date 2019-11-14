package bl.Construccion.Recursos.Oro;

import bl.Construccion.Recursos.IRecurso;

public class Oro implements IRecurso {
    private int cantidad;

    public Oro(int cantidad) {
        setCantidad(cantidad);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public void recogerRecurso() {

    }
}
