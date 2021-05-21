package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.AdicionarIngredientesTela;

public class OuvinteVoltarTelaIngrediente implements ActionListener{
    private JFrame jFrame;
    public OuvinteVoltarTelaIngrediente(JFrame jFrame){
    	this.jFrame = jFrame;
    }
	public void actionPerformed(ActionEvent arg0) {
          new AdicionarIngredientesTela("Administrador");
          jFrame.dispose();
	}

}
