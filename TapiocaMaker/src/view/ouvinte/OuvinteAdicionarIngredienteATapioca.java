package view.ouvinte;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import view.TelaDeTapioca;

public class OuvinteAdicionarIngredienteATapioca implements MouseListener{
    private TelaDeTapioca tela;
    public OuvinteAdicionarIngredienteATapioca(TelaDeTapioca tela) {
		this.tela = tela;
	}
	public void mouseClicked(MouseEvent arg0) {
		Object obj = tela.getTabela().getValueAt(tela.getTabela().getSelectedRow(), 0);
		String linha = String.valueOf(obj);
		tela.getIngredientes().add(linha);
		JOptionPane.showMessageDialog(tela, "Ingrediente inserido na Tapioca");
		tela.getTabela().getSelectionModel().clearSelection();
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
