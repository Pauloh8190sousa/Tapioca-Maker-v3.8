package view.ouvinte;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.facade.FacadeCardapio;
import model.Ingrediente;
import view.TelaDeIngredientes;
import view.exception.IngredienteNaoPodeSerExcluidoException;

public class OuvinteSelecionarTabela implements MouseListener{
    private TelaDeIngredientes ti;
    public OuvinteSelecionarTabela(TelaDeIngredientes ti){
    	this.ti = ti;
    }
	public void mouseClicked(MouseEvent e) {
		Object obj = ti.getTabela().getValueAt(ti.getTabela().getSelectedRow(), 0);
		String linha = String.valueOf(obj);
		FacadeCardapio facade = FacadeCardapio.getInstance();
		Ingrediente i = null;
		for(int cont = 0;cont<facade.getIngredientes().size();cont++){
			if(facade.getIngredientes().get(cont).getNome().equals(linha)){
				i = facade.getIngredientes().get(cont);
				break;
			}
		}
		String[] opcoes = {"Ver detalhes","Excluir ingrediente"};
		int opcao = JOptionPane.showOptionDialog(ti, "O que Deseja?", "Ingrediente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	    if(opcao==0){
	    	JOptionPane.showMessageDialog(ti, i.toString());
	    }else if(opcao==1){
			
	    	try {
				facade.excluirIngrediente(i);
				//facade.salvarDados();
				DefaultTableModel modelo = (DefaultTableModel) ti.getTabela().getModel();
				modelo.removeRow(ti.getTabela().getSelectedRow());
				JOptionPane.showMessageDialog(ti, "Ingrediente excluido");
			} catch (IngredienteNaoPodeSerExcluidoException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(ti, "UMA TAPIOCA POSSUI ESSE INGREDIENTE", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
			}
			
		  }
	    ti.getTabela().getSelectionModel().clearSelection();
	   }

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

}
