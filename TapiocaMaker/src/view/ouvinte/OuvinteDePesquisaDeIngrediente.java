package view.ouvinte;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.table.DefaultTableModel;

import controller.facade.FacadeCardapio;
import model.Ingrediente;
import view.TelaDeIngredientes;

public class OuvinteDePesquisaDeIngrediente implements KeyListener{
    private TelaDeIngredientes ti;
    
    public OuvinteDePesquisaDeIngrediente(TelaDeIngredientes ti){
    	this.ti = ti;
		
	}
	public void keyPressed(KeyEvent arg0) {
		
	}
	public void keyReleased(KeyEvent arg0) {
		FacadeCardapio facade = FacadeCardapio.getInstance();
		String campo = ti.getCampo().getText().toUpperCase();
				   DefaultTableModel modelo = new DefaultTableModel();
				   modelo.addColumn("Ingredientes");
        	       modelo.addColumn("Preço");
        	       modelo.addColumn("Gramas");
		           for(int cont = 0;cont<facade.getIngredientes().size();cont++){
		        	   Ingrediente i = facade.getIngredientes().get(cont);
	        		   Object[] linha = {i.getNome(),i.getPreco(),i.getCalorias()};
	        		   String nome;
	        		   String gramas;
	        		   String preco;
		        	   nome = i.getNome().toUpperCase();
		        	   preco = ""+i.getPreco();
		        	   gramas = ""+i.getCalorias();
		        	   if( i.getStatus().equals("Disponivel")){
		        	       if(campo.equals("")){
		        		        modelo.addRow(linha);
		        	      }
		        	       else if(nome.contains(campo)){
		        		        modelo.addRow(linha);
		        	       }else if(preco.contains(campo)){
		        		        modelo.addRow(linha);
		        	       }else if(gramas.contains(campo)){
		        		        modelo.addRow(linha);
		        	     }
		        	   }
		           }
		           ti.getTabela().setModel(modelo);
				}

	public void keyTyped(KeyEvent arg0) {

	}
    
}