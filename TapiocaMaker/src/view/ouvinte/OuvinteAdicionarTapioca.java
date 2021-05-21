package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.facade.FacadeCardapio;
import model.Ingrediente;
import model.factoryMethod.FabricaTapioca;
import model.factoryMethod.FabricaTapiocaMaker;
import model.factoryMethod.Tapioca;
import view.TelaDeTapioca;
import view.exception.TapiocaDuplicadaException;

public class OuvinteAdicionarTapioca implements ActionListener{
    private TelaDeTapioca tp;
    
    public OuvinteAdicionarTapioca(TelaDeTapioca tp){
    	this.tp = tp;
    }
	public void actionPerformed(ActionEvent arg0) {
		FacadeCardapio facade = FacadeCardapio.getInstance();
		if(tp.getCampo().getText().equals("")){
			JOptionPane.showMessageDialog(tp, "Campo vazio");
		}else{
			FabricaTapiocaMaker fabrica = new FabricaTapioca();
		
		Tapioca t = fabrica.criarTapioca(tp.getCampo().getText());
		for(int x = 0;x<tp.getIngredientes().size();x++){
			for(Ingrediente i:facade.getIngredientes()){
			   if(tp.getIngredientes().get(x).equals(i.getNome())){
				 t.getArray().add(i);
			   }
			}
		}
		if(t.getArray().size()==0){
			JOptionPane.showMessageDialog(tp, "ADICIONE PELO MENOS UM INGREDIENTE!","AVISO!",JOptionPane.WARNING_MESSAGE);
		}else{
		    try {
				facade.adicionarTapioca(t);
			    //facade.salvarDados();
			    JOptionPane.showMessageDialog(tp, "Foi adicionado");
			} catch (TapiocaDuplicadaException e) {
				JOptionPane.showMessageDialog(tp, e.getMessage());
			}
	   }
		tp.getCampo().setText("");
	}
		tp.getTabela().getSelectionModel().clearSelection();
		tp.setIngredientes(new ArrayList<String>());
	}
}
