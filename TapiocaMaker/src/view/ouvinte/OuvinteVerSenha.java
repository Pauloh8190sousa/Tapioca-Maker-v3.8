package view.ouvinte;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import view.TelaCadastrarAdministrador;
import view.TelaDeAdministrador;

public class OuvinteVerSenha implements MouseListener{
    private TelaDeAdministrador ta;
    private TelaCadastrarAdministrador tca;
    public OuvinteVerSenha(TelaDeAdministrador ta){
    	this.ta = ta;
    }
    public OuvinteVerSenha(TelaCadastrarAdministrador tca){
    	this.tca = tca;
    }
	public void mouseClicked(MouseEvent arg0) {
		
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
		if(ta!=null){
		ta.getVer().setIcon(new ImageIcon(getClass().getResource("/icons8-visível-30.png")));
		ta.getSenhaCampo().setEchoChar('\u0000');
		}else{
			tca.getVer().setIcon(new ImageIcon(getClass().getResource("/icons8-visível-30.png")));
			tca.getCampoSenha().setEchoChar('\u0000');
		}
	}
	public void mouseReleased(MouseEvent arg0) {
		if(ta!=null){
		ta.getVer().setIcon(new ImageIcon(getClass().getResource("/icons8-invisível-30.png")));
		ta.getSenhaCampo().setEchoChar('\u2022');
		}else{
			tca.getVer().setIcon(new ImageIcon(getClass().getResource("/icons8-invisível-30.png")));
			tca.getCampoSenha().setEchoChar('\u2022');
		}
	}
}