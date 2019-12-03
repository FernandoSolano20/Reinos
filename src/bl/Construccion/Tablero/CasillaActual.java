package bl.Construccion.Tablero;

public class CasillaActual {
    public static Casilla casilla = null;

    public static Casilla getCasilla() {
        return casilla;
    }

    public static void setCasilla(Casilla casilla) {
        CasillaActual.casilla = casilla;
    }
}
