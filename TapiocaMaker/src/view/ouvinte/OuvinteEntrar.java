package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.facade.FacadeAdministracao;
import controller.facade.FacadeCardapio;
import view.TelaInicio;
import view.TelaMenuPrincipal;

public class OuvinteEntrar implements ActionListener{

	private TelaInicio ti;
	public OuvinteEntrar(TelaInicio ti){
		this.ti = ti;
	}
	public void actionPerformed(ActionEvent arg0) {
		FacadeAdministracao facade = new FacadeAdministracao();
		FacadeCardapio cardapio = FacadeCardapio.getInstance();
		if(facade.getAdministrador()==null){
			JOptionPane.showMessageDialog(ti, "NÃO PODE ENTRAR, NÃO EXISTE ADMINISTRADOR AINDA!", "ATENÇÂO!",JOptionPane.WARNING_MESSAGE);
		}
		else{
			new TelaMenuPrincipal("Cliente");
			ti.dispose();
		   }
		if(cardapio.getPedidos().size()!=0){
			if(cardapio.getPedidos().get(cardapio.getPedidos().size()-1).getCliente().getEmail()==null){
				cardapio.getPedidos().remove(cardapio.getPedidos().size()-1);	
			}
			//cardapio.salvarDados();
	   }
	}
}
