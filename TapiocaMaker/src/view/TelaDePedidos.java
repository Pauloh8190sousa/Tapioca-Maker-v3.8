package view;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.facade.FacadeAdministracao;
import controller.facade.FacadeCardapio;
import model.Pedido;
import view.ouvinte.OuvintePesquisaDePedidos;
import view.ouvinte.OuvinteSelecionarPedido;
import view.ouvinte.OuvinteVoltarSegundaTela;
import view.templateMethod.TelaPadrao;

public class TelaDePedidos extends TelaPadrao{
    private JTable tabela;
    private JTextField filtro;

    public TelaDePedidos(String usuario) {
    	construirTela(usuario);
    	setSize(800, 500);
    	setLocationRelativeTo(null);
    	repaint();
	}
	@Override
	public void adicionarBotoes() {
		FacadeAdministracao facadeAdmin = new FacadeAdministracao();
		OuvinteVoltarSegundaTela ouvinte = new OuvinteVoltarSegundaTela(this, facadeAdmin.getAdministrador().getNome());
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(700, 1, 92, 30);
		voltar.addActionListener(ouvinte);
		add(voltar);
		
	}
	@Override
	public void adicionarTextField() {
		OuvintePesquisaDePedidos ouvinte = new OuvintePesquisaDePedidos(this);
		filtro = new JTextField();
		filtro.setBounds(1, 1, 700, 30);
		filtro.addKeyListener(ouvinte);
		add(filtro);
	}
	
	@Override
	public void adicionarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		OuvinteSelecionarPedido ovuinte = new OuvinteSelecionarPedido(this);
		tabela = new JTable(modelo);
		tabela.addMouseListener(ovuinte);
		modelo.addColumn("ID");
        modelo.addColumn("Cliente");
        modelo.addColumn("Status");
        modelo.addColumn("Data de Inicio do pedido");
        modelo.addColumn("Data Final do Pedido");
        FacadeCardapio facade = FacadeCardapio.getInstance();
        ArrayList<Pedido> pedido = facade.getPedidos();
        for(int cont = 0;cont<pedido.size();cont++){
         Object[] linha = {pedido.get(cont).getId(),
        		 pedido.get(cont).getCliente().getNome(),
        		 pedido.get(cont).getStatus(),
        		 pedido.get(cont).dataInicial(),
        		 pedido.get(cont).situacaoDataStatus()};
         modelo.addRow(linha);
        }
        tabela.setToolTipText("Click para fechar pedido");
        JScrollPane painel = new JScrollPane(tabela);
        painel.setBounds(2, 31, 791, 450);
        add(painel);
	}
	
	public JTextField getFiltro() {
		return filtro;
	}
	public JTable getTabela() {
		return tabela;
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
