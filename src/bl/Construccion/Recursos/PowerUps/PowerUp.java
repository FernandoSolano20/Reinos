package bl.Construccion.Recursos.PowerUps;

import bl.Construccion.Recursos.IRecurso;

public class PowerUp implements IRecurso {
    private String tipo;
    private int poderEspecial;
    private int duracionTurnos;

    public PowerUp(String tipo, int poderEspecial, int duracionTurnos) {
        setTipo(tipo);
        setDuracionTurnos(duracionTurnos);
        setPoderEspecial(poderEspecial);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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
