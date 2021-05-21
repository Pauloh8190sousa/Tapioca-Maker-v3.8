package view;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.ouvinte.OuvinteAdicionarAdiminitrador;
import view.ouvinte.OuvinteVerSenha;
import view.ouvinte.OuvinteVoltarPrimeiraTela;
import view.templateMethod.TelaPadrao;


public class TelaCadastrarAdministrador extends TelaPadrao{
	private JTextField campoNome;
	private JTextField campoEmail; 
	private JPasswordField campoSenha;
	private JComboBox<String> sexo;
	private JLabel ver;

	public TelaCadastrarAdministrador(String usuario) {
		construirTela(usuario);
		repaint();
	}
	@Override
	public void adicionarBotoes() {
		OuvinteVoltarPrimeiraTela opt = new OuvinteVoltarPrimeiraTela(this);
		JButton botao = new JButton("Voltar");
		botao.setBounds(400, 10, 80, 30);
		botao.addActionListener(opt);
		add(botao);
		
		OuvinteAdicionarAdiminitrador o = new OuvinteAdicionarAdiminitrador(this);
		JButton botaoCadastrar = new JButton("Cadastrar",new ImageIcon(getClass().getResource("/icons8-adicionar-administrador-filled-28.png")));
		botaoCadastrar.setBounds(172, 310, 128, 34);
		botaoCadastrar.addActionListener(o);
		add(botaoCadastrar);
	}
	@Override
	public void adicionarTextField() {
		campoNome = new JTextField();
		campoNome.setBounds(125, 50, 220, 30);
		add(campoNome);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(125, 90, 220, 30);
		add(campoEmail);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(125, 130, 220, 30);
		add(campoSenha);
	}
	@Override
	public void adicionarJComboBox() {
		sexo = new JComboBox<String>();
		sexo.addItem("Masculino");
		sexo.addItem("Feminino");
		sexo.setBounds(280, 180, 90, 30);
		add(sexo);
	}
	
	public JLabel getVer() {
		return ver;
	}
	public JTextField getCampoNome() {
		return campoNome;
	}

	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public JPasswordField getCampoSenha() {
		return campoSenha;
	}

	public JComboBox<String> getSexo() {
		return sexo;
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
		JLabel cadastrar = new JLabel("Cadastrar Administrador");
		cadastrar.setBounds(165, 10, 200, 40);
		cadastrar.setFont(new Font("Arial",Font.BOLD,16));
		add(cadastrar);
		
		JLabel nome = new JLabel("Nome");
		nome.setBounds(80, 50, 40, 30);
		add(nome);
		
		JLabel email = new JLabel("E-mail");
		email.setBounds(80, 90, 50, 30);
		add(email);
		
		JLabel senha = new JLabel("Senha");
		senha.setBounds(80, 130, 50, 30);
		add(senha);
		
		OuvinteVerSenha ovs = new OuvinteVerSenha(this);
		ver = new JLabel();
		ver.setBounds(355, 130, 30, 30);
		ver.setIcon(new ImageIcon(getClass().getResource("/icons8-invisível-30.png")));
		ver.addMouseListener(ovs);
		add(ver);
		
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
		return true;
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