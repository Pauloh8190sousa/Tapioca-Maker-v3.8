package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaListaDeTapioca;
import view.TelaMenuPrincipal;

public class OuvinteListaDeTapioca implements ActionListener{
    private TelaMenuPrincipal st;
    
    public OuvinteListaDeTapioca(TelaMenuPrincipal st){
    	this.st = st;
    }
	public void actionPerformed(ActionEvent e) {
		new TelaListaDeTapioca(st.getNome());
		st.dispose();
	}

}
