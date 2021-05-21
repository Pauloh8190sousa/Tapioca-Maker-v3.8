package view;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.facade.FacadeCardapio;
import model.Cliente;
import view.ouvinte.OuvinteRemoverTapiocasDoCarrinho;
import view.ouvinte.OuvinteTelaFazerPedido;
import view.ouvinte.OuvinteVoltarSegundaTela;
import view.templateMethod.TelaPadrao;

public class TelaMeuCarrinho extends TelaPadrao{
	private JTable tabela;
	
	public TelaMeuCarrinho(String usuario) {
		construirTela(usuario);
		repaint();
	}
	public JTable getTabela() {
		return tabela;
	}
	
	public void adicionarBotoes() {
		OuvinteVoltarSegundaTela ovs = new OuvinteVoltarSegundaTela(this, "Cliente");
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(400, 10, 80, 30);
		voltar.addActionListener(ovs);
		add(voltar);
		
		OuvinteTelaFazerPedido ofp = new OuvinteTelaFazerPedido(this);
		JButton fazerPedido = new JButton("Fazer Pedido");
		fazerPedido.setBounds(300, 330, 110, 30);
		fazerPedido.addActionListener(ofp);
		add(fazerPedido);
		
		OuvinteRemoverTapiocasDoCarrinho ouvinte = new OuvinteRemoverTapiocasDoCarrinho(this);
		JButton removerPedido = new JButton("Remover Pedido");
		removerPedido.setBounds(100, 330, 130, 30);
		removerPedido.addActionListener(ouvinte);
		add(removerPedido);
	}
	
	@Override
	public void adicionarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		FacadeCardapio facade = FacadeCardapio.getInstance();
		tabela = new JTable(modelo);
        modelo.addColumn("Tapiocas");
        modelo.addColumn("Preço");
        Cliente cliente = null;
        if(facade.getPedidos().size()!=0){
        	if(facade.getPedidos().get(facade.getPedidos().size()-1).getCliente().getEmail()==null){
        		cliente = facade.getPedidos().get(facade.getPedidos().size()-1).getCliente();
        for(int cont = 0;cont<cliente.getCarrinho().size();cont++){
            Object[] linha = {cliente.getCarrinho().get(cont).getNome(),cliente.getCarrinho().get(cont).getPreco()};
            modelo.addRow(linha);
           }
          }
        }
        tabela.setToolTipText("Click para ver detalhes");
        JScrollPane painel = new JScrollPane(tabela);
        painel.setBounds(1, 41, 495, 280);
        add(painel);
	}
	@Override
	public void adicionarTextField() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void adicionarLabel(String usuario) {
		JLabel carrinho = new JLabel("Meu Carrinho");
		carrinho.setBounds(210, 10, 120, 30);
		carrinho.setFont(new Font("Times new roman",Font.BOLD,16));
		add(carrinho);
		
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
	public void menuAdministrador() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuCliente() {
		// TODO Auto-generated method stub
		
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
