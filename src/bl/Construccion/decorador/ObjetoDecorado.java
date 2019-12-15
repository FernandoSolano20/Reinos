package bl.Construccion.decorador;

import bl.Construccion.Tropa.TropaAtaque.TropaAtaque;

public abstract class ObjetoDecorado extends TropaAtaque {
    private String nombrePowerUp;
    protected TropaAtaque cTropaAtaque;
    public String getNombrePowerUp() {
        return nombrePowerUp;
    }

    public void setNombrePowerUp(String nombrePowerUp) {
        this.nombrePowerUp = nombrePowerUp;
    }
}
