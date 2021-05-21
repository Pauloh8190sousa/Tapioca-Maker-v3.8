package view;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controller.facade.FacadeAdministracao;
import view.ouvinte.OuvinteEnviarAviso;
import view.ouvinte.OuvinteVoltarSegundaTela;
import view.templateMethod.TelaPadrao;

public class TelaEnviarPromocoes extends TelaPadrao{
    private JTextArea descricao;
 
    public TelaEnviarPromocoes(String usuario) {
    	construirTela(usuario);
    	repaint();
	}
	@Override
	public void adicionarBotoes() {
		FacadeAdministracao facadeAdmin = new FacadeAdministracao();
		OuvinteVoltarSegundaTela ouvinte = new OuvinteVoltarSegundaTela(this, facadeAdmin.getAdministrador().getNome());
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(400, 30, 80, 30);
		voltar.addActionListener(ouvinte);
		add(voltar);
		
		OuvinteEnviarAviso ouvinteEnviarAviso = new OuvinteEnviarAviso(this);
		JButton enviar = new JButton("Enviar");
		enviar.setBounds(210, 300, 80, 30);
		enviar.addActionListener(ouvinteEnviarAviso);
		add(enviar);
		
	}
	
	@Override
	public void adicionarTextField() {
		descricao = new JTextArea();
		descricao.setBounds(70, 90, 380, 200);
		descricao.setLineWrap(true);
		descricao.setWrapStyleWord(true);
		add(descricao);
	}

	public JTextArea getDescricao() {
		return descricao;
	}
	@Override
	public void menuAdministrador() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuCliente() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void adicionarLabel(String usuario) {
		JLabel promocoes = new JLabel("Enviar Promoções Para Clientes");
		promocoes.setBounds(130, 30, 280, 30);
		promocoes.setFont(new Font("Times new roman",Font.BOLD,18));
		add(promocoes);
		
	}
	@Override
	public void adicionarTabela() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void adicionarRadioButton() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void adicionarJComboBox() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isBotoes() {
		return true;
	}
	@Override
	public boolean isTextField() {
		return true;
	}
	@Override
	public boolean isLabel() {
		return true;
	}
	@Override
	public boolean isTabela() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isRadioButton() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isJComboBox() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isMenuCliente() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isMenuAdministrador() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
