package view.ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.facade.FacadeCardapio;
import model.Ingrediente;
import view.AdicionarIngredientesTela;
import view.exception.IngredienteDuplicadoException;

public class OuvinteCadastrarIngredientes implements ActionListener{
    private  AdicionarIngredientesTela ait;
	public OuvinteCadastrarIngredientes(AdicionarIngredientesTela ait){
		this.ait = ait;
	}
	public void actionPerformed(ActionEvent arg0) {
		Ingrediente i = new Ingrediente();
		if(ait.getCampo().getText().equals("")||ait.getPreco().getText().equals("")){
			JOptionPane.showMessageDialog(ait, "Campo vazio!");
		}else{
			String status = "";
		   if(ait.getRadio1().isSelected()){
			   status = ait.getRadio1().getText();
		   }else if(ait.getRadio2().isSelected()){
			   status = ait.getRadio2().getText();
		   }
		  if(status.equals("")){
			  JOptionPane.showMessageDialog(ait, "Seleciona um status!");
		  }else{
	    try{
		i.setNome(ait.getCampo().getText());
		i.setPreco(Float.parseFloat(ait.getPreco().getText()));
		i.setCalorias((float) ait.getGrama().getSelectedItem());
		i.setStatus(status);
		FacadeCardapio facade = FacadeCardapio.getInstance();
		facade.adicionarIngrediente(i);
		//facade.salvarDados();
		JOptionPane.showMessageDialog(null,"Operação feita" );
	    }catch(IngredienteDuplicadoException e){
	    	JOptionPane.showMessageDialog(ait, e.getMessage());
	    }catch(Exception e){
	    	JOptionPane.showMessageDialog(ait, "Entrada inválida");
	    }
		 }
		}
		ait.getCampo().setText("");
		ait.getPreco().setText("");
	}
	}