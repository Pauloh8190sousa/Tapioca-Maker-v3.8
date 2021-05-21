package view;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import view.ouvinte.OuvinteAdministrador;
import view.ouvinte.OuvinteEntrar;
import view.ouvinte.OuvinteSair;
import view.templateMethod.TelaPadrao;

public class TelaInicio extends TelaPadrao {

	public TelaInicio(String usuario) {
		construirTela(usuario);
		repaint();
	}
	@Override
	public void adicionarBotoes() {
		OuvinteEntrar ouvinte = new OuvinteEntrar(this);
		JButton botao = new JButton("Entrar",new ImageIcon(getClass().getResource("/icons8-login-filled-23.png")));
		botao.setBounds(200, 300, 98, 30);
		botao.addActionListener(ouvinte);
		add(botao);
		
		OuvinteSair ouvinteSair = new OuvinteSair(this);
		JButton sair = new JButton("Sair");
		sair.setBounds(400, 30, 60, 30);
		sair.addActionListener(ouvinteSair);
		add(sair);
		
		OuvinteAdministrador administrador = new OuvinteAdministrador(this);
		JButton admin = new JButton("Adiministrador",new ImageIcon(getClass().getResource("/icons8-usuário-homem-com-círculo-25.png")));
		admin.setBounds(174, 250, 148, 30);
		admin.addActionListener(administrador);
		add(admin);
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
	public void adicionarTextField() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void adicionarLabel(String usuario) {
		JLabel bemVindo = new JLabel("Bem-Vindo(a)");
		bemVindo.setFont(new Font("Arial", Font.BOLD, 16));
		bemVindo.setBounds(200, 30, 105, 30);
		add(bemVindo);
		
		JLabel nome = new JLabel("Tapioca Maker");
		nome.setFont(new Font("Arial", Font.BOLD, 16));
		nome.setForeground(Color.BLUE);
		nome.setBounds(190, 70, 118, 30);
		add(nome);
		
		JLabel fundo = new JLabel(new ImageIcon(getClass().getResource("/Tapioca.jpg")));
		fundo.setBounds(0, 0, 500, 400);
		add(fundo);
		
	}
	@Override
	public void adicionarTabela() {
		
	}
	@Override
	public void adicionarRadioButton() {
		
	}
	@Override
	public void adicionarJComboBox() {
		
	}
	@Override
	public boolean isBotoes() {
		return true;
	}
	@Override
	public boolean isTextField() {
		return false;
	}
	@Override
	public boolean isLabel() {
		return true;
	}
	@Override
	public boolean isTabela() {
		return false;
	}
	@Override
	public boolean isRadioButton() {
		return false;
	}
	@Override
	public boolean isJComboBox() {
		return false;
	}
	@Override
	public boolean isMenuCliente() {
		return false;
	}
	@Override
	public boolean isMenuAdministrador() {
		return false;
	}
}
