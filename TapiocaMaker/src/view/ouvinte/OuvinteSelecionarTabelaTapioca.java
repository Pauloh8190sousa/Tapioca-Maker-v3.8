package view.ouvinte;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.facade.FacadeCardapio;
import model.Cliente;
import model.Pedido;
import model.factoryMethod.Tapioca;
import view.TelaListaDeTapioca;

public class OuvinteSelecionarTabelaTapioca implements MouseListener{
    private TelaListaDeTapioca tlt;
    private JTable jt;
    
    public OuvinteSelecionarTabelaTapioca(TelaListaDeTapioca tlt,JTable jt){
    	this.tlt = tlt;
    	this.jt = jt;
    }
	public void mouseClicked(MouseEvent arg0) {
		Object obj = jt.getValueAt(jt.getSelectedRow(), 0);
		String linha = String.valueOf(obj);
		FacadeCardapio facade = FacadeCardapio.getInstance();
		Tapioca t = null;
		for(int cont = 0;cont<facade.getTapiocas().size();cont++){
			if(facade.getTapiocas().get(cont).getNome().equals(linha)){
				t = facade.getTapiocas().get(cont);
			}
		}
		if(tlt.getNome().equals("Cliente")){
		Pedido pedido;
		Cliente cliente;
		int res = JOptionPane.showConfirmDialog(tlt,"Adicionar ao carrinho?","Meu Carrinho",JOptionPane.YES_NO_OPTION);
	    if(res == JOptionPane.YES_OPTION){
	    	JOptionPane.showMessageDialog(tlt, "Foi adicionado ao carrinho");
	    	if(facade.getPedidos().size()==0 || facade.getPedidos().get(facade.getPedidos().size()-1).getCliente().getEmail()!=null){
	    	    pedido = new Pedido();
	    		cliente = new Cliente();
	    		cliente.AdicionarAoCarrinho(t);
	    		pedido.adicionarCliente(cliente);
	    		facade.adicionarPedido(pedido);
	    	}else{
	    		pedido = facade.getPedidos().get(facade.getPedidos().size()-1);
	    		pedido.getCliente().AdicionarAoCarrinho(t);
	    	}
	    }
		}else{
			Object[] opcoes = {"Ver detalhes da tapioca","Excluir tapioca"};
			int escolha = JOptionPane.showOptionDialog(tlt, "O que deseja?", "Escolha uma opção", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
			if(escolha==0){
				JOptionPane.showMessageDialog(tlt, t.toString());
			}else if(escolha==1){
				facade.excluirTapioca(t);
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.addColumn("Tapiocas");
				modelo.addColumn("Preço");
				for(Tapioca x: facade.getTapiocas()){
					Object[] linhaNova = {x.getNome(),x.getPreco()};
					modelo.addRow(linhaNova);
				}
				jt.setModel(modelo);
				JOptionPane.showMessageDialog(tlt, "Tapioca excluida");
			}
		}
	   //facade.salvarDados();
	    jt.getSelectionModel().clearSelection();
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
