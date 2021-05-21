package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.facade.FacadeCardapio;
import model.factoryMethod.Tapioca;
import view.TelaMeuCarrinho;

public class OuvinteRemoverTapiocasDoCarrinho implements ActionListener{
    private TelaMeuCarrinho tela;
    public OuvinteRemoverTapiocasDoCarrinho(TelaMeuCarrinho tela) {
    	this.tela = tela;
	}
	public void actionPerformed(ActionEvent arg0) {
		FacadeCardapio facade = FacadeCardapio.getInstance();
		if(tela.getTabela().getRowCount()==0){
			JOptionPane.showMessageDialog(tela, "Não tem tapiocas para remover");
		}else{
		    facade.getPedidos().get(facade.getPedidos().size()-1).getCliente().setCarrinho(new ArrayList<Tapioca>());
			DefaultTableModel modelo = new DefaultTableModel();
			modelo.addColumn("Tapiocas");
			modelo.addColumn("Preço");
			for(Tapioca t:facade.getPedidos().get(facade.getPedidos().size()-1).getCliente().getCarrinho()){
				Object[] linha = {t.getNome(),t.getPreco()};
				modelo.addRow(linha);
			}
			tela.getTabela().setModel(modelo);
			//facade.salvarDados();
		}
	}

}
