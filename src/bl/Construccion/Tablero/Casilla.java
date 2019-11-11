package bl.Construccion.Tablero;

import bl.Construccion.Construccion;
import bl.Construccion.IConstruccion;
import bl.Construccion.Recursos.IRecurso;

public class Casilla {
    private Construccion pieza;
    private IRecurso recurso;

    public Casilla() {
        setPieza(null);
        setRecurso(null);
    }

    public Construccion getPieza() {
        return pieza;
    }

    public void setPieza(Construccion pieza) {
        this.pieza = pieza;
    }

    public IRecurso getRecurso() {
        return recurso;
    }

    public void setRecurso(IRecurso recurso) {
        this.recurso = recurso;
    }
}
