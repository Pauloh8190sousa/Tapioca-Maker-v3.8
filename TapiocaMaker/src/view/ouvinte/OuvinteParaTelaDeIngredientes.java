package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.TelaDeIngredientes;

public class OuvinteParaTelaDeIngredientes implements ActionListener{
	    private JFrame jFrame;
		public OuvinteParaTelaDeIngredientes(JFrame jFrame){
			this.jFrame = jFrame;
		}
		public void actionPerformed(ActionEvent arg0) {
			new TelaDeIngredientes("Administrador");
			jFrame.dispose();
		}

	

}
