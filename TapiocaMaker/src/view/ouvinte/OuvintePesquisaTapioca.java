package view.ouvinte;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.table.DefaultTableModel;

import controller.facade.FacadeCardapio;
import model.Ingrediente;
import model.factoryMethod.Tapioca;
import view.TelaListaDeTapioca;

public class OuvintePesquisaTapioca implements KeyListener{
    private TelaListaDeTapioca tela;
    
    public OuvintePesquisaTapioca(TelaListaDeTapioca tela){
    	this.tela = tela;
    }
	public void keyPressed(KeyEvent arg0) {
		
	}

	public void keyReleased(KeyEvent arg0) {
		FacadeCardapio facade = FacadeCardapio.getInstance();
		String campo = tela.getCampoFiltro().getText().toUpperCase();
				   DefaultTableModel modelo = new DefaultTableModel();
				   modelo.addColumn("Tapiocas");
        	       modelo.addColumn("Preço");
        	       modelo.addColumn("Gramas");
		           for(int cont = 0;cont<facade.getTapiocas().size();cont++){
		        	   Tapioca t = facade.getTapiocas().get(cont);
	        		   Object[] linha = {t.getNome(),t.getPreco(),t.getGramas()};
	        		   String nome = t.getNome().toUpperCase();
	        		   String preco = ""+t.getPreco();
	        		   String grama = ""+t.getGramas();
	        		   boolean teste = true;
	        		   for(Ingrediente ingri: t.getArray()){
	        			   if(ingri.getStatus().equals("Indisponivel")){
	        				   teste = false;
	        				   break;
	        			   }
	        		   }
	        				   if(campo.equals("") && teste){
	        					   modelo.addRow(linha);
	        				   }
	        				   else if(nome.contains(campo) && teste){
	        					   modelo.addRow(linha);
	        				   }else if(preco.contains(campo) && teste){
	        					   modelo.addRow(linha);
	        				   }else if(grama.contains(campo) && teste){
	        					   modelo.addRow(linha);
	        				   }
	        		   	}
		           tela.getTabela().setModel(modelo);
				}

	public void keyTyped(KeyEvent arg0) {
		
	}

}
