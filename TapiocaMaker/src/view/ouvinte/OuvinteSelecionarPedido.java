package view.ouvinte;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.facade.FacadeCardapio;
import model.Pedido;
import view.TelaDePedidos;
import view.state.EstadoDoPedidoFechado;

public class OuvinteSelecionarPedido implements MouseListener{
    private TelaDePedidos tela;
    
    public OuvinteSelecionarPedido(TelaDePedidos tela){
    	this.tela = tela;
    }
	public void mouseClicked(MouseEvent arg0) {
		Object obj = tela.getTabela().getValueAt(tela.getTabela().getSelectedRow(), 0);
		String linha = String.valueOf(obj);
		long id = Long.parseLong(linha);
		FacadeCardapio facade = FacadeCardapio.getInstance();
		Pedido pedido = null;
		for(int cont = 0;cont<facade.getPedidos().size();cont++){
			if(facade.getPedidos().get(cont).getId()==id){
				pedido = facade.getPedidos().get(cont);
				break;
			}
		}
		String[] opcoes = {"Ver detalhes","Fechar Pedido"};
		int opcao = JOptionPane.showOptionDialog(tela, "O que Deseja?", "Ingrediente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	    if(opcao==0){
	    	JOptionPane.showMessageDialog(tela, pedido.toString());
	    }else if(opcao==1){
			pedido.setEstadoDoPedido(new EstadoDoPedidoFechado());
			facade.savePedido();
			DefaultTableModel modelo = new DefaultTableModel();
			modelo.addColumn("ID");
			modelo.addColumn("Cliente");
			modelo.addColumn("Status");
			modelo.addColumn("Data de Inicio do pedido");
	        modelo.addColumn("Data Final do Pedido");
			for(int x = 0;x<facade.getPedidos().size();x++){
				Object[] linhaNova = {facade.getPedidos().get(x).getId(),
						facade.getPedidos().get(x).getCliente().getNome(),
						facade.getPedidos().get(x).getStatus(),
						facade.getPedidos().get(x).dataInicial(),
						facade.getPedidos().get(x).situacaoDataStatus()};
				modelo.addRow(linhaNova);
			}
			tela.getTabela().setModel(modelo);
	        JOptionPane.showMessageDialog(tela, pedido.getStatus());
			
			JOptionPane.showMessageDialog(tela, "Pedido fechado");
			}
		   tela.getTabela().getSelectionModel().clearSelection();
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}

}
