package bl.Construccion.MetodoFabrica;

import bl.Construccion.Recursos.IRecurso;

public interface MetodoFabrica {
    public IRecurso crearGemas(int cantGema);
    public IRecurso crearPowerUp(int powerUp);
}
