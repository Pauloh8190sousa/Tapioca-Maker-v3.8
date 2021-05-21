package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.TelaFazerPedido;
import view.TelaMeuCarrinho;


public class OuvinteTelaFazerPedido implements ActionListener{
    private TelaMeuCarrinho jf;
    public OuvinteTelaFazerPedido(TelaMeuCarrinho jf){
    	this.jf = jf;
    }
	public void actionPerformed(ActionEvent arg0) {
		if(jf.getTabela().getRowCount()==0){
			JOptionPane.showMessageDialog(jf, "Não tem tapiocas no seu carrinho");
	}else{
		new TelaFazerPedido("Cliente");
		jf.dispose();
	   }
	}
}