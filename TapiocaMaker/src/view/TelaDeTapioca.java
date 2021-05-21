package view;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.facade.FacadeAdministracao;
import controller.facade.FacadeCardapio;
import model.Ingrediente;
import view.ouvinte.OuvinteAdicionarIngredienteATapioca;
import view.ouvinte.OuvinteAdicionarTapioca;
import view.ouvinte.OuvinteVoltarSegundaTela;
import view.templateMethod.TelaPadrao;


public class TelaDeTapioca extends TelaPadrao{
	private JTextField campo;
	private JTable tabela;
	private ArrayList<String> ingredientes = new ArrayList<>();
	
	public TelaDeTapioca(String usuario) {
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
		
		OuvinteAdicionarTapioca oat = new OuvinteAdicionarTapioca(this);
		JButton botao = new JButton("Adicionar Tapioca",new ImageIcon(getClass().getResource("/icons8-mais-25.png")));
		botao.setBounds(190, 310, 165, 30);
		botao.addActionListener(oat);
		add(botao);
	}
	@Override
	public void adicionarTabela() {
		FacadeCardapio facade = FacadeCardapio.getInstance();
		DefaultTableModel modelo = new DefaultTableModel();
		OuvinteAdicionarIngredienteATapioca ouvinte = new OuvinteAdicionarIngredienteATapioca(this);
		tabela = new JTable(modelo);
		tabela.addMouseListener(ouvinte);
        modelo.addColumn("Ingredientes");
        modelo.addColumn("Preço");
        modelo.addColumn("Gramas");
        ArrayList<Ingrediente> a = facade.getIngredientes();
        for(int cont = 0;cont<a.size();cont++){
         if(a.get(cont).getStatus().equals("Disponivel")){
         Object[] linha = {a.get(cont).getNome(),a.get(cont).getPreco(),a.get(cont).getCalorias()};
         modelo.addRow(linha);
         }
        }
        tabela.setToolTipText("Selecione para adicionar a tapioca");
        JScrollPane painel = new JScrollPane(tabela);
        painel.setBounds(80, 150, 400, 150);
        add(painel);
	}
	
	@Override
	public void adicionarTextField() {
		campo = new JTextField();
		campo.setBounds(200, 110, 250, 30);
		add(campo);
	}
	
	public JTable getTabela() {
		return tabela;
	}
	public void setIngredientes(ArrayList<String> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public ArrayList<String> getIngredientes() {
		return ingredientes;
	}
	public JTextField getCampo() {
		return campo;
	}
	@Override
	public void menuAdministrador() {
		
	}
	@Override
	public void menuCliente() {
		
	}
	@Override
	public void adicionarLabel(String usuario) {
		JLabel tapioca = new JLabel("Cadastrar Tapioca");
		tapioca.setBounds(210, 30, 120, 30);
		tapioca.setFont(new Font("Times new roman",Font.BOLD,14));
		add(tapioca);
		
		JLabel nome = new JLabel("Nome da tapioca");
		nome.setBounds(90, 110, 100, 30);
		add(nome);
		
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
		return true;
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