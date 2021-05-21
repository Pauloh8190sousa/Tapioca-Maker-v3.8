package view;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.ouvinte.OuvinteFecharPedido;
import view.ouvinte.OuvinteVoltarMeuCarrinho;
import view.templateMethod.TelaPadrao;

public class TelaFazerPedido extends TelaPadrao{
    private JTextField campoNome;
    private JTextField campoEmail;
    private JTextField campoEndereco;

    public TelaFazerPedido(String usuario) {
    	construirTela(usuario);
    	repaint();
	}
	@Override
	public void adicionarBotoes() {
		OuvinteVoltarMeuCarrinho ovmc = new OuvinteVoltarMeuCarrinho(this);
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(400, 10, 80, 30);
		voltar.addActionListener(ovmc);
		add(voltar);
		
		OuvinteFecharPedido ofp = new OuvinteFecharPedido(this);
		JButton pedido = new JButton("Fechar Pedido");
		pedido.setBounds(190, 300, 120, 30);
		pedido.addActionListener(ofp);
		add(pedido);
	}

	@Override
	public void adicionarTextField() {
		campoNome = new JTextField();
		campoNome.setBounds(140, 80, 220, 30);
		add(campoNome);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(140, 120, 220, 30);
		add(campoEmail);
		
		campoEndereco = new JTextField();
		campoEndereco.setBounds(140, 160, 220, 30);
		add(campoEndereco);
	}
	
	public JTextField getCampoNome() {
		return campoNome;
	}
	
	public void setCampoNome(JTextField campoNome) {
		this.campoNome = campoNome;
	}
	
	public JTextField getCampoEmail() {
		return campoEmail;
	}
	
	public void setCampoEmail(JTextField campoEmail) {
		this.campoEmail = campoEmail;
	}
	
	public JTextField getCampoEndereco() {
		return campoEndereco;
	}
	
	public void setCampoEndereco(JTextField campoEndereco) {
		this.campoEndereco = campoEndereco;
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
		JLabel nome = new JLabel("Nome");
		nome.setBounds(80, 80, 50, 30);
		add(nome);
		
		JLabel email = new JLabel("E-mail");
		email.setBounds(80, 120, 50, 30);
		add(email);
		
		JLabel endereco = new JLabel("Endereço");
		endereco.setBounds(80, 160, 70, 30);
		add(endereco);
		
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