package bl.Construccion.Tropa.TropaAtaque;

import bl.Construccion.Castillo.Castillo;
import bl.Construccion.Cordenadas.CoordenasAtaque;
import bl.Construccion.Juego.VisitanteTropas.IVisitante;
import bl.Construccion.Recursos.Gemas.Gema;
import bl.Construccion.Recursos.PowerUps.PowerUp;
import bl.Construccion.Recursos.PowerUps.Tipo.AumentaAtaque;
import bl.Construccion.Recursos.PowerUps.Tipo.AumentoDefensa;
import bl.Construccion.Recursos.PowerUps.Tipo.TrampaAtaque;
import bl.Construccion.Recursos.PowerUps.Tipo.TrampaDefensa;
import bl.Construccion.Tablero.Casilla;
import bl.Construccion.Tropa.Tropa;
import bl.Construccion.decoradoresPowerUp.*;

public abstract class TropaAtaque extends Tropa implements ITropaAtaque{
    private int cantMovimientos;
    private int oroTransportable;
    protected int defensa;
    private int oros;
    private PowerUp powerUp;

    public TropaAtaque() {
        oros = 0;
    }

    public int getCantMovimientos() {
        return cantMovimientos;
    }

    public void setCantMovimientos(int cantMovimientos) {
        this.cantMovimientos = cantMovimientos;
    }

    public int getDefensa() {
        return defensa;
    }

    public abstract void setDefensa(int defensa);

    public int getOroTransportable() {
        return oroTransportable;
    }

    public void setOroTransportable(int oroTransportable) {
        this.oroTransportable = oroTransportable;
    }

    public int getOros() {
        return oros;
    }

    public void setOros(int sumOro) {
        if(oros < oroTransportable){
            int resultOro = oros + sumOro;
            if(resultOro > oroTransportable){
                oros = oroTransportable;
            }
            else {
                oros = resultOro;
            }
        }
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    @Override
    public void movimientoTropa() {

    }

    @Override
    public void robarOro() {

    }

    @Override
    public abstract void visitaRegeneracion(IVisitante pVisitante);

    public void recogerPowerUp(Casilla casilla){
        setPowerUp((PowerUp)casilla.getRecurso());
        casilla.removerRecurso();
    }

    public void recogerOro(Casilla casilla){
        Gema gema = (Gema) casilla.getRecurso();
        setOros(gema.getValor());
        casilla.removerRecurso();
    }

    public TropaAtaque usarPowerUp(TropaAtaque tropaAtaque){
        if (powerUp != null){
            if(powerUp instanceof AumentaAtaque){
                tropaAtaque = new DecoradorAumentaAtaque(tropaAtaque);
            }
            else if (powerUp instanceof AumentoDefensa){
                tropaAtaque = new DecoradorAumentaDefensa(tropaAtaque);
            }
            else if (powerUp instanceof TrampaDefensa){
                tropaAtaque = new DecoradorDisminuyeDefensa(tropaAtaque);
            }
            else if (powerUp instanceof TrampaAtaque){
                tropaAtaque = new DecoradorDisminuyeAtaque(tropaAtaque);
            }
        }
        return tropaAtaque;
    }

    public String tranferirOroCastillo(){
        Castillo castillo = this.getJugador().getCastillo();
        if (CoordenasAtaque.validarAtaqueAlcanze1(getCasilla().getX() - castillo.getCasilla().getX() ,getCasilla().getY() - castillo.getCasilla().getY())){
            castillo.setOros(castillo.getOros() + this.getOros());
            this.setOros(0);
            return "Oro asigando";
        }
        return "No esta lo suficientemente cerca del castillo";
    }
}
