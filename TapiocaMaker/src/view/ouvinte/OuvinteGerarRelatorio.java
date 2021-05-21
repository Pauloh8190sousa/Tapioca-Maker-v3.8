package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.facade.FacadeCardapio;
import controller.facade.FacadeRelatorio;
import model.Pedido;
import model.factoryMethod.Tapioca;

public class OuvinteGerarRelatorio implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		FacadeCardapio facade = FacadeCardapio.getInstance();
		FacadeRelatorio relatorio = new FacadeRelatorio();
		
         for(int i = 0;i<facade.getTapiocas().size();i++){
        	 for(int x = 0;x<facade.getPedidos().size();x++){
        		 for(int cont = 0;cont<facade.getPedidos().get(x).getCliente().getCarrinho().size();cont++){
        			 if(facade.getTapiocas().get(i).getNome().equals(facade.getPedidos().get(x).getCliente().getCarrinho().get(cont).getNome())){
        				 facade.getTapiocas().get(i).aumentarQuandidadesDeTapiocasCompradas();
        			 }
        		 }
        	 }
         }
         for(Tapioca t:facade.getTapiocasExcluidas()){
        	 for(Pedido pe:facade.getPedidos()){
        		 for(Tapioca ta: pe.getCliente().getCarrinho()){
        			 if(t.getNome().equals(ta.getNome())){
        				 t.aumentarQuandidadesDeTapiocasCompradas();
        			 }
        		 }
        	 }
         }
         relatorio.gerarRelatorio("Relatorio.pdf");
        JOptionPane.showMessageDialog(null, "Gerado o relatório");
	}

}
