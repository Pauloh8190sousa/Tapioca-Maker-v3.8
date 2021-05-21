package view.ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import controller.facade.FacadeCardapio;
import view.TelaInicio;

public class OuvinteVoltarPrimeiraTela implements ActionListener{
    private JFrame tp;
	public OuvinteVoltarPrimeiraTela(JFrame tp){
		this.tp = tp;
	}
	public void actionPerformed(ActionEvent e) {
		FacadeCardapio facade = FacadeCardapio.getInstance();
		if(facade.getPedidos().size()!=0){
			if(facade.getPedidos().get(facade.getPedidos().size()-1).getCliente().getEmail()==null){
				facade.getPedidos().remove(facade.getPedidos().size()-1);	
			}
	   }
		//facade.salvarDados();
		new TelaInicio("Administrador");
		tp.dispose();
	}
}
