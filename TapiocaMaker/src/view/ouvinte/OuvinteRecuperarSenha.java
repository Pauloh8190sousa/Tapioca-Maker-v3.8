package view.ouvinte;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import controller.facade.FacadeAdministracao;
import view.TelaDeAdministrador;

public class OuvinteRecuperarSenha implements MouseListener{

	private TelaDeAdministrador ta;
	public OuvinteRecuperarSenha(TelaDeAdministrador ta){
		this.ta = ta;
	}
	public void mouseClicked(MouseEvent arg0) {
		
	}
	public void mouseEntered(MouseEvent arg0) {
		ta.getRecuperarSenha().setForeground(Color.BLUE);
		ta.getRecuperarSenha().setFont(new Font("Times new roman",Font.ITALIC,14));
	}
	public void mouseExited(MouseEvent arg0) {
		ta.getRecuperarSenha().setForeground(Color.BLACK);
		ta.getRecuperarSenha().setFont(new Font("Times new roman",Font.BOLD,12));
	}
	public void mousePressed(MouseEvent arg0) {
		String email = JOptionPane.showInputDialog(null, "Informe seu e-mail");
		FacadeAdministracao facade = new FacadeAdministracao();
			if(facade.getAdministrador().getEmail().equals(email)){
				boolean teste = facade.enviarEmail(email,"Tapioca Maker-Recupera��o de Senha", "Ol� "+facade.getAdministrador().getNome()+" , essa � sua senha: "+facade.getAdministrador().getSenha());
				if(teste==true){
					JOptionPane.showMessageDialog(ta, "Cheque seus e-mails");
				}else{
					JOptionPane.showMessageDialog(ta, "Sem internet!");
				}
			}else if(email!=null){
				JOptionPane.showMessageDialog(ta, "Esse e-mail n�o est� cadastrado!");
			}
		}
	public void mouseReleased(MouseEvent arg0) {
	}
}