package view.ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.facade.FacadeAdministracao;
import model.Administrador;
import model.ValidarEmail.ValidacaoEmail;
import model.decorator.Validacao;
import model.decorator.ValidacaoDeLetras;
import model.decorator.ValidacaoDeNumeros;
import model.decorator.ValidacaoPadraoDeEntrada;
import view.TelaCadastrarAdministrador;
import view.TelaMenuPrincipal;

public class OuvinteAdicionarAdiminitrador implements ActionListener{
    private TelaCadastrarAdministrador tca;
	public OuvinteAdicionarAdiminitrador(TelaCadastrarAdministrador tca){
		this.tca = tca;
	}
	public void actionPerformed(ActionEvent arg0) {
		FacadeAdministracao facade = new FacadeAdministracao();
		String nome = tca.getCampoNome().getText();
		String email = tca.getCampoEmail().getText();
		String senha = new String(tca.getCampoSenha().getPassword());
	    try {
	    	String sexo = (String) tca.getSexo().getSelectedItem();
	    	Validacao validacaoPadrao = new ValidacaoPadraoDeEntrada();
			Validacao validacaoCompleta = new ValidacaoDeNumeros(new ValidacaoDeLetras(validacaoPadrao));
			if(validacaoPadrao.validacao(nome)==false||validacaoPadrao.validacao(email)==false||validacaoPadrao.validacao(senha)==false){
				JOptionPane.showMessageDialog(tca, "Campo vazio");
			}else{
				validacaoCompleta.validacao(senha);
				ValidacaoEmail validarEmail = new ValidacaoEmail();
				validarEmail.validarEmail(email);
			    Administrador a = new Administrador(nome, email, senha, sexo);
			    facade.adicionarAdministrador(a);
				JOptionPane.showMessageDialog(null, "Foi cadastrado");
				//facade.salvarDados();
				new TelaMenuPrincipal(nome);
				tca.dispose();
		   }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(tca, e.getMessage());
		}
	
		tca.getCampoEmail().setText("");
		tca.getCampoNome().setText("");
		tca.getCampoSenha().setText("");
	}
}