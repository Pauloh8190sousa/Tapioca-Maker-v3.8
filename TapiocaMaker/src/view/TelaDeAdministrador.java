package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.ouvinte.OuvinteAcessarAdministrador;
import view.ouvinte.OuvinteExcluirAdministrador;
import view.ouvinte.OuvinteRecuperarSenha;
import view.ouvinte.OuvinteVerSenha;
import view.ouvinte.OuvinteVoltarPrimeiraTela;
import view.templateMethod.TelaPadrao;

public class TelaDeAdministrador extends TelaPadrao{
    private JPasswordField senhaCampo;
    private JTextField campoEmail;
    private JLabel recuperarSenha;
    private JLabel ver;

    public TelaDeAdministrador(String usuario) {
    	construirTela(usuario);
    	repaint();
	}
	@Override
	public void adicionarBotoes() {
    	OuvinteVoltarPrimeiraTela opt = new OuvinteVoltarPrimeiraTela(this);
		JButton botao = new JButton("Voltar",new ImageIcon(getClass().getResource("/icons8-undo-20.png")));
		botao.setBounds(380, 8, 105, 30);
		botao.addActionListener(opt);
		add(botao);
		
		OuvinteExcluirAdministrador oea = new OuvinteExcluirAdministrador(this);
		JButton excluir = new JButton("Excluir conta",new ImageIcon(getClass().getResource("/icons8-lixo-25.png")));
		excluir.setBounds(250, 180, 140, 30);
		excluir.addActionListener(oea);
		add(excluir);
		
		OuvinteAcessarAdministrador ouvinte = new OuvinteAcessarAdministrador(this);
		JButton acessar = new JButton("Acessar",new ImageIcon(getClass().getResource("/icons8-login-filled-23.png")));
		acessar.setBounds(210, 280, 110, 30);
		acessar.addActionListener(ouvinte);
		add(acessar);
	}
	@Override
	public void adicionarTextField() {
		OuvinteCampoBrancoAdmin adminOuvinte = new OuvinteCampoBrancoAdmin();
		campoEmail = new JTextField();
		campoEmail.setBounds(170, 100, 220, 30);
		campoEmail.addMouseListener(adminOuvinte);
		add(campoEmail);
		
		OuvinteCampoBrancoAdmin ouvinte = new OuvinteCampoBrancoAdmin();
		senhaCampo = new JPasswordField();
		senhaCampo.setBounds(170, 138, 220, 30);
		senhaCampo.addMouseListener(ouvinte);
		add(senhaCampo);
	}
	public JPasswordField getSenhaCampo() {
		return senhaCampo;
	}
	public void setSenhaCampo(JPasswordField senhaCampo) {
		this.senhaCampo = senhaCampo;
	}
	public JTextField getCampoEmail() {
		return campoEmail;
	}
	public void setCampoEmail(JTextField campoEmail) {
		this.campoEmail = campoEmail;
	}
	public JLabel getVer() {
		return ver;
	}
	public void setVer(JLabel ver) {
		this.ver = ver;
	}
	public JLabel getRecuperarSenha() {
		return recuperarSenha;
	}
	public void setRecuperarSenha(JLabel recuperarSenha) {
		this.recuperarSenha = recuperarSenha;
	}
	
	public class OuvinteCampoBrancoAdmin implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
		}
		public void mouseEntered(MouseEvent arg0) {
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
			campoEmail.setBackground(Color.WHITE);
			senhaCampo.setBackground(Color.WHITE);
		}
		public void mouseReleased(MouseEvent arg0) {
		}
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
		JLabel admin = new JLabel("Administrador");
		admin.setFont(new Font("Arial",Font.BOLD,16));
		admin.setBounds(210, 40, 110, 30);
		add(admin);
		
		JLabel email = new JLabel("E-mail");
		email.setBounds(120, 100, 50, 30);
		add(email);
		
		JLabel senha = new JLabel("Senha");
		senha.setBounds(120, 138, 50, 30);
		add(senha);
		
		OuvinteVerSenha ovs = new OuvinteVerSenha(this);
		ver = new JLabel();
		ver.setBounds(400, 138, 30, 30);
		ver.setIcon(new ImageIcon(getClass().getResource("/icons8-invisível-30.png")));
		ver.addMouseListener(ovs);
		add(ver);
		
		OuvinteRecuperarSenha ors = new OuvinteRecuperarSenha(this);
		recuperarSenha = new JLabel("Recuperar senha");
		recuperarSenha.setBounds(350, 40, 100, 30);
		recuperarSenha.addMouseListener(ors);
		add(recuperarSenha);
		
	}
	@Override
	public void adicionarTabela() {
		
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