package bl.Construccion.Tablero;

import bl.Construccion.IConstruccion;
import bl.Construccion.Recursos.IRecurso;

public class Casilla {
    private IConstruccion pieza;
    private IRecurso recurso;
    private int x;
    private int y;

    public Casilla(int x, int y) {
        setX(x);
        setY(y);
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean tieneRecurso(){
        return recurso == null;
    }

    public boolean tienePieza(){
        return pieza == null;
    }
}
