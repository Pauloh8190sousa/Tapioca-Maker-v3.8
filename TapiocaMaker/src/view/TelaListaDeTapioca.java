package view;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.facade.FacadeCardapio;
import model.Ingrediente;
import view.ouvinte.OuvintePesquisaTapioca;
import view.ouvinte.OuvinteSelecionarTabelaTapioca;
import view.ouvinte.OuvinteVoltarSegundaTela;
import view.templateMethod.TelaPadrao;

public class TelaListaDeTapioca extends TelaPadrao{
    private JTable tabela;
    private JTextField campoFiltro;
    private String nome;
	
    public TelaListaDeTapioca(String usuario){
    	construirTela(usuario);
		nome = usuario;
		voltar(usuario);
		repaint();
	}
	
	public void voltar(String usuario){
		OuvinteVoltarSegundaTela ouvinte = new OuvinteVoltarSegundaTela(this, usuario);
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(400, 1, 92, 30);
		voltar.addActionListener(ouvinte);
		add(voltar);
	}
	
	@Override
	public void adicionarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		tabela = new JTable(modelo);
		OuvinteSelecionarTabelaTapioca ost = new OuvinteSelecionarTabelaTapioca(this, tabela);
        tabela.addMouseListener(ost);
		modelo.addColumn("Tapiocas");
        modelo.addColumn("Preço");
        modelo.addColumn("Gramas");
        boolean teste = true;
        FacadeCardapio facade = FacadeCardapio.getInstance();
        for(int cont = 0;cont<facade.getTapiocas().size();cont++){
         for(Ingrediente e: facade.getTapiocas().get(cont).getArray()){
        	 if(e.getStatus().equals("Indisponivel")){
        		teste = false;
        		break;
        	 }
         }
         if(teste==true){
        	 Object[] linha = {facade.getTapiocas().get(cont).getNome(),facade.getTapiocas().get(cont).getPreco(),facade.getTapiocas().get(cont).getGramas()};
        	 modelo.addRow(linha);
         }
        }
        tabela.setToolTipText("Aperte para adicionar no carrinho");
        JScrollPane painel = new JScrollPane(tabela);
        painel.setBounds(1, 31, 495, 341);
        add(painel);
	}
	
	public String getNome() {
		return nome;
	}
	
	public JTextField getCampoFiltro() {
		return campoFiltro;
	}
	
	public JTable getTabela() {
		return tabela;
	}
	@Override
	public void adicionarTextField() {
		OuvintePesquisaTapioca ouvinte = new OuvintePesquisaTapioca(this);
		campoFiltro = new JTextField();
		campoFiltro.setBounds(1, 1, 400, 30);
		campoFiltro.addKeyListener(ouvinte);
		add(campoFiltro);
	}
	
	@Override
	public void adicionarBotoes() {
		// TODO Auto-generated method stub
		
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
		return false;
	}

	@Override
	public boolean isTextField() {
		return true;
	}

	@Override
	public boolean isLabel() {
		return false;
	}

	@Override
	public boolean isTabela() {
		return true;
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
