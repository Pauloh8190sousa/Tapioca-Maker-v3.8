package view.ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaMenuPrincipal;
import view.TelaMeuCarrinho;

public class OuvinteTelaCarrinho implements ActionListener{

	private TelaMenuPrincipal st;
	public OuvinteTelaCarrinho(TelaMenuPrincipal st){
		this.st = st;
	}
	public void actionPerformed(ActionEvent arg0) {
		new TelaMeuCarrinho("Cliente");
		st.dispose();
		
	}

}
