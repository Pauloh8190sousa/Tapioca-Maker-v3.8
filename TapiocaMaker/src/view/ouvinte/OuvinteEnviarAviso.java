package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.facade.FacadeAdministracao;
import view.TelaEnviarPromocoes;

public class OuvinteEnviarAviso implements ActionListener{
    private TelaEnviarPromocoes tela;
    public OuvinteEnviarAviso(TelaEnviarPromocoes tela) {
        this.tela = tela;    	
	}
	public void actionPerformed(ActionEvent arg0) {
		FacadeAdministracao facadeAdmin = new FacadeAdministracao();
		String descricao = tela.getDescricao().getText();
		if(facadeAdmin.enviarEmailATodosOsClientes(descricao)==true){
			
			JOptionPane.showMessageDialog(tela, "E-mails enviados");
			JOptionPane.showMessageDialog(tela, "Foi enviada a mala direta para os clientes");
		
		}else{
			JOptionPane.showMessageDialog(tela, "Sem internet!");
		}
		tela.getDescricao().setText("");
	}

}