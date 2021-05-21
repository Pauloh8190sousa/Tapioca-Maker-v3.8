package view.ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.facade.FacadeAdministracao;
import view.TelaDeAdministrador;
import view.TelaInicio;

public class OuvinteExcluirAdministrador implements ActionListener{
    private TelaDeAdministrador ta;
    
    public OuvinteExcluirAdministrador(TelaDeAdministrador ta){
    	this.ta = ta;
    }
	public void actionPerformed(ActionEvent arg0) {
		FacadeAdministracao facade = new FacadeAdministracao();
		int res = JOptionPane.showConfirmDialog(ta, "Tem certeza?", "Aviso", JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION){
			facade.excluirAdministrador();
			//facade.salvarDados();
			JOptionPane.showMessageDialog(ta,"Operação feita");
			JOptionPane.showMessageDialog(ta, "Você irá voltar para tela inicial", "Atenção", JOptionPane.WARNING_MESSAGE);
			new TelaInicio("Administrador");
			ta.dispose();
		}else{
			JOptionPane.showMessageDialog(ta, "Operação cancelada");
		}
	}

}
