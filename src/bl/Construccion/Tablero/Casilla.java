package bl.Construccion.Tablero;

import bl.Construccion.IConstruccion;
import bl.Construccion.Recursos.IRecurso;

public class Casilla {
    IConstruccion pieza;
    IRecurso recurso;

    public Casilla() {
        pieza = null;
        recurso = null;
    }

    public IConstruccion getPieza() {
        return pieza;
    }

    public void setPieza(IConstruccion pieza) {
        this.pieza = pieza;
    }

    public IRecurso getRecurso() {
        return recurso;
    }

    public void setRecurso(IRecurso recurso) {
        this.recurso = recurso;
    }
}
