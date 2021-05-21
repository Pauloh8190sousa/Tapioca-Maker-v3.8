package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.TelaEnviarPromocoes;

public class OuvinteTelaEnviarPromocao implements ActionListener{
    private JFrame jFrame;
    public OuvinteTelaEnviarPromocao(JFrame jFrame) {
    	this.jFrame = jFrame;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		new TelaEnviarPromocoes("Administrador");
		jFrame.dispose();
	}

}
