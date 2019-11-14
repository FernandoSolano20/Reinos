package bl.Construccion.Recursos.PowerUps;

import bl.Construccion.Recursos.IRecurso;

public class PowerUp implements IRecurso {
    private int tipo;
    private int poderEspecial;
    private int duracionTurnos;

    public PowerUp(int tipo, int poderEspecial, int duracionTurnos) {
        setTipo(tipo);
        setDuracionTurnos(duracionTurnos);
        setPoderEspecial(poderEspecial);
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getDuracionTurnos() {
        return duracionTurnos;
    }

    public void setDuracionTurnos(int duracionTurnos) {
        this.duracionTurnos = duracionTurnos;
    }

    public int getPoderEspecial() {
        return poderEspecial;
    }

    public void setPoderEspecial(int poderEspecial) {
        this.poderEspecial = poderEspecial;
    }

    @Override
    public void recogerRecurso() {

    }
}
