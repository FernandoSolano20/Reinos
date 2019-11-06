package bl.Construccion.Recursos.PowerUps;

import bl.Construccion.Recursos.IRecurso;

public class PowerUp implements IRecurso {
    private int tipo;
    private int multiplicador;
    private int duracionTurnos;

    public PowerUp(int tipo, int multiplicador, int duracionTurnos) {
        this.tipo = tipo;
        this.multiplicador = multiplicador;
        this.duracionTurnos = duracionTurnos;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public int getDuracionTurnos() {
        return duracionTurnos;
    }

    public void setDuracionTurnos(int duracionTurnos) {
        this.duracionTurnos = duracionTurnos;
    }

    @Override
    public void recogerRecurso() {

    }
}
