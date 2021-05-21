package view.ouvinte;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.table.DefaultTableModel;

import controller.facade.FacadeCardapio;
import model.Pedido;
import view.TelaDePedidos;

public class OuvintePesquisaDePedidos implements KeyListener{
    private TelaDePedidos tela;
    public OuvintePesquisaDePedidos(TelaDePedidos tela) {
    	this.tela = tela;
	}
	public void keyPressed(KeyEvent arg0) {
		
	}

	public void keyReleased(KeyEvent arg0) {
		FacadeCardapio facade = FacadeCardapio.getInstance();
		String campo = tela.getFiltro().getText().toUpperCase();
				   DefaultTableModel modelo = new DefaultTableModel();
				   modelo.addColumn("ID");
        	       modelo.addColumn("Cliente");
        	       modelo.addColumn("Status");
        	       modelo.addColumn("Data de Inicio do pedido");
        	       modelo.addColumn("Data Final do Pedido");
		           for(int cont = 0;cont<facade.getPedidos().size();cont++){
		        	   Pedido pedido = facade.getPedidos().get(cont);
	        		   Object[] linha = {pedido.getId(),
	        				   pedido.getCliente().getNome(),
	        				   pedido.getStatus(),
	        				   pedido.dataInicial(),
	        	        	   pedido.situacaoDataStatus()};
	        		   String nome;
	        		   String status;
	        		   String id;
	        		   String dataInicio;
	        		   String dataFinal;
		        	   nome = pedido.getCliente().getNome().toUpperCase();
		        	   status = pedido.getStatus().toUpperCase();
		        	   id = ""+pedido.getId();
		        	   dataInicio = pedido.dataInicial();
		        	   dataFinal = pedido.situacaoDataStatus();
		        	   if(campo.equals("")){
		        		  modelo.addRow(linha);
		        	   }
		        	   else if(nome.contains(campo)){
		        		   modelo.addRow(linha);
		        	   }else if(status.contains(campo)){
		        		   modelo.addRow(linha);
		        	   }else if(id.contains(campo)){
		        		   modelo.addRow(linha);
		        	   }else if(dataInicio.contains(campo)){
		        		   modelo.addRow(linha);
		        	   }else if(dataFinal.contains(campo)){
		        		   modelo.addRow(linha);
		        	   }
		           }
		           tela.getTabela().setModel(modelo);
	}

	public void keyTyped(KeyEvent arg0) {
		
	}

}
