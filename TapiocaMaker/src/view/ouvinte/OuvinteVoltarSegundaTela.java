package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.TelaMenuPrincipal;

public class OuvinteVoltarSegundaTela implements ActionListener{
    private JFrame tp;
    private String usuario;
    public OuvinteVoltarSegundaTela(JFrame tp,String usuario){
    	this.tp = tp;
    	this.usuario = usuario;
    }
	public void actionPerformed(ActionEvent e) {
		new TelaMenuPrincipal(usuario);
		tp.dispose();
	}

}
