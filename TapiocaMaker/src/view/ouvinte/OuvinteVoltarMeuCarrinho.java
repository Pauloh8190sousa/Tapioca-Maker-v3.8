package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.TelaMeuCarrinho;

public class OuvinteVoltarMeuCarrinho implements ActionListener{
    private JFrame jf;
    public OuvinteVoltarMeuCarrinho(JFrame jf){
    	this.jf = jf;
    }
	public void actionPerformed(ActionEvent arg0) {
		new TelaMeuCarrinho("Cliente");
		jf.dispose();
	}

}
