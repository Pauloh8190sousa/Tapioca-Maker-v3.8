package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaDePedidos;
import view.TelaMenuPrincipal;

public class OuvinteTelaPedido implements ActionListener{
    private TelaMenuPrincipal st;
    public OuvinteTelaPedido(TelaMenuPrincipal st){
    	this.st = st;
    }
	public void actionPerformed(ActionEvent e) {
		new TelaDePedidos("Administrador");
		st.dispose();
	}

}
