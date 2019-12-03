package bl.Construccion.Excepciones;

import javax.swing.*;

public class ExcepcionJuego extends Exception {

    public ExcepcionJuego(String pMensaje){
        super(pMensaje);
        JOptionPane.showMessageDialog(new JPanel(), pMensaje, "Error en el proceso", JOptionPane.ERROR_MESSAGE);
    }

}
