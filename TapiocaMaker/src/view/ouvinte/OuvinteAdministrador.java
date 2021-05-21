package view.ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.facade.FacadeAdministracao;
import view.TelaCadastrarAdministrador;
import view.TelaDeAdministrador;
import view.TelaInicio;

public class OuvinteAdministrador implements ActionListener{
    private TelaInicio ti;
    public OuvinteAdministrador(TelaInicio ti){
    	this.ti = ti;
    }
	public void actionPerformed(ActionEvent arg0) {
		FacadeAdministracao facade = new FacadeAdministracao();
		if(facade.getAdministrador()!=null){
		    new TelaDeAdministrador("Administrador");
		}else{
			new TelaCadastrarAdministrador("Administrador");
		}
		ti.dispose();
	}

}
