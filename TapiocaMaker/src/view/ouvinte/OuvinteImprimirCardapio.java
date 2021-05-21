package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.facade.FacadeRelatorio;

public class OuvinteImprimirCardapio implements ActionListener{
    private JFrame tela;
    public OuvinteImprimirCardapio(JFrame tela) {
    	this.tela = tela;
	}
	public void actionPerformed(ActionEvent arg0) {
		FacadeRelatorio facade = new FacadeRelatorio();
		facade.gerarCardapio("Cardapio.pdf");
		JOptionPane.showMessageDialog(tela, "Cardapio gerado!");
	}

}
