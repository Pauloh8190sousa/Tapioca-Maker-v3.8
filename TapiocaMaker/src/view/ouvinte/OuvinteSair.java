package view.ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.TelaInicio;

public class OuvinteSair implements ActionListener{
    private TelaInicio ti;
	public OuvinteSair(TelaInicio ti){
		this.ti = ti;
	}
	public void actionPerformed(ActionEvent arg0) {
		int res = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Atenção", JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "Obrigado por ficar");
		}else if(res == JOptionPane.YES_OPTION){
			ti.dispose();
		}
	}

}
