package bl.Construccion.MetodoFabrica;

import bl.Construccion.Recursos.IRecurso;

public interface MetodoFabrica {
    public IRecurso crearRecurso (int pLadoA, int pLadoB, int pLadoC);
}
