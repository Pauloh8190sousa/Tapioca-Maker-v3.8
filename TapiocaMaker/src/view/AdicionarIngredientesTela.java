package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.facade.FacadeAdministracao;
import view.ouvinte.OuvinteCadastrarIngredientes;
import view.ouvinte.OuvinteVoltarSegundaTela;
import view.templateMethod.TelaPadrao;

public class AdicionarIngredientesTela extends TelaPadrao{
    private JTextField campo;
    private JTextField preco;
    private JComboBox<Float> grama;
    private JRadioButton radio1;
    private JRadioButton radio2;

    public AdicionarIngredientesTela(String usuario) {
    	construirTela(usuario);
    	repaint();
	}
	@Override
	public void adicionarBotoes() {
		FacadeAdministracao facadeAdmin = new FacadeAdministracao();
		OuvinteVoltarSegundaTela ovs = new OuvinteVoltarSegundaTela(this, facadeAdmin.getAdministrador().getNome());
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(400, 10, 80, 30);
		voltar.addActionListener(ovs);
		add(voltar);
		
		OuvinteCadastrarIngredientes o = new OuvinteCadastrarIngredientes(this);
		JButton adi = new JButton("Adicionar",new ImageIcon(getClass().getResource("/icons8-mais-25.png")));
		adi.setBounds(200, 300, 120, 30);
		adi.addActionListener(o);
		add(adi);
		
		OuvinteTelaEditarIngrediente oei = new OuvinteTelaEditarIngrediente(this);
		JButton botaoEditar = new JButton("Editar Ingrediente");
		botaoEditar.setBounds(320, 220, 135, 30);
		botaoEditar.addActionListener(oei);
		add(botaoEditar);
	}

	@Override
	public void adicionarTextField() {
		campo = new JTextField();
		campo.setBounds(200, 50, 220, 30);
		add(campo);
		
		preco = new JTextField();
		preco.setBounds(200, 88, 220, 30);
		add(preco);
	}
	@Override
	public void adicionarJComboBox() {
		grama = new JComboBox<>();
		grama.addItem((float) 100);
		grama.addItem((float) 200);
		grama.addItem((float) 300);
		grama.setBounds(350, 170, 70, 30);
		add(grama);
	}
	@Override
	public void adicionarRadioButton() {
		ButtonGroup grupo = new ButtonGroup();
		radio1 = new JRadioButton("Disponivel");
		radio2 = new JRadioButton("Indisponivel");
		radio1.setBounds(80, 220, 100, 30);
		radio2.setBounds(190, 220, 100, 30);
		grupo.add(radio1);
		grupo.add(radio2);
		add(radio1);
		add(radio2);
	}
	
	public class OuvinteTelaEditarIngrediente implements ActionListener{
		private AdicionarIngredientesTela ait;
		public OuvinteTelaEditarIngrediente(AdicionarIngredientesTela ait){
			this.ait = ait;
		}
		public void actionPerformed(ActionEvent e) {
			new TelaEditarIngredinte("Administrador");
		    ait.dispose();
		}
	}
	
	public JRadioButton getRadio1() {
		return radio1;
	}
	public JRadioButton getRadio2() {
		return radio2;
	}
	public JComboBox<Float> getGrama() {
		return grama;
	}
	public void setGrama(JComboBox<Float> grama) {
		this.grama = grama;
	}
	public JTextField getCampo() {
		return campo;
	}
	public void setCampo(JTextField campo) {
		this.campo = campo;
	}
	public JTextField getPreco() {
		return preco;
	}
	public void setPreco(JTextField preco) {
		this.preco = preco;
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
		JLabel adicionar = new JLabel("Adicionar ingredientes");
		adicionar.setBounds(60,50,130,30);
		add(adicionar);
		
		JLabel nomePreco = new JLabel("Preço");
		nomePreco.setBounds(152, 88, 48, 30);
		add(nomePreco);
		
	}
	@Override
	public void adicionarTabela() {
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
		return true;
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