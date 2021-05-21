package view.ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.AdicionarIngredientesTela;

public class OuvinteAdicionarIngredientes implements ActionListener{

	private JFrame jf;
	public OuvinteAdicionarIngredientes(JFrame jf){
		this.jf = jf;
	}
	public void actionPerformed(ActionEvent arg0) {
		new AdicionarIngredientesTela("Administrador");
		jf.dispose();
	}

}
