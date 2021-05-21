package view.ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.TelaDeTapioca;

public class OuvinteTelaTapioca implements ActionListener{
    private JFrame jf;
	public OuvinteTelaTapioca(JFrame jf){
		this.jf = jf;
	}
	public void actionPerformed(ActionEvent arg0) {
		new TelaDeTapioca("Administrador");
		jf.dispose();
	}

}
