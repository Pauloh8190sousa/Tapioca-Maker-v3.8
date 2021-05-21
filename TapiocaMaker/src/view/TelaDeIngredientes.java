package view;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.facade.FacadeAdministracao;
import controller.facade.FacadeCardapio;
import model.Ingrediente;
import view.ouvinte.OuvinteDePesquisaDeIngrediente;
import view.ouvinte.OuvinteSelecionarTabela;
import view.ouvinte.OuvinteVoltarSegundaTela;
import view.templateMethod.TelaPadrao;


public class TelaDeIngredientes extends TelaPadrao{
    private JTextField campo;
    private JTable tabela;
 
    public TelaDeIngredientes(String usuario) {
    	construirTela(usuario);
    	repaint();
	}
	@Override
	public void adicionarBotoes() {
		FacadeAdministracao facadeAdmin = new FacadeAdministracao();
		OuvinteVoltarSegundaTela ouvinte = new OuvinteVoltarSegundaTela(this, facadeAdmin.getAdministrador().getNome());
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(387, 2, 105, 30);
		voltar.addActionListener(ouvinte);
		add(voltar);
		
	}
	@Override
	public void adicionarTextField() {
		OuvinteDePesquisaDeIngrediente op = new OuvinteDePesquisaDeIngrediente(this);
		campo = new JTextField();
		campo.setBounds(0, 2, 387, 30);
		campo.addKeyListener(op);
		campo.setToolTipText("Pesquise por tapiocas, ingredientes ou por preço");
		add(campo);
	}
	@Override
	public void adicionarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		tabela = new JTable(modelo);
		OuvinteSelecionarTabela os = new OuvinteSelecionarTabela(this);
        modelo.addColumn("Ingredientes");
        modelo.addColumn("Preço");
        modelo.addColumn("Gramas");
        tabela.addMouseListener(os);
        FacadeCardapio facade = FacadeCardapio.getInstance();
        ArrayList<Ingrediente> a = facade.getIngredientes();
        for(int cont = 0;cont<a.size();cont++){
        if(a.get(cont).getStatus().equals("Disponivel")){
         Object[] linha = {a.get(cont).getNome(),a.get(cont).getPreco(),a.get(cont).getCalorias()};
         modelo.addRow(linha);
        }
        }
        tabela.setToolTipText("Click para ver detalhes");
        JScrollPane painel = new JScrollPane(tabela);
        painel.setBounds(1, 31, 495, 341);
        add(painel);
	}
	
	public JTable getTabela() {
		return tabela;
	}
	public JTextField getCampo() {
		return campo;
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
		// TODO Auto-generated method stub
		return false;
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