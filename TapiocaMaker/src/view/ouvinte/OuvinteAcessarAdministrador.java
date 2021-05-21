package view.ouvinte;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.facade.FacadeAdministracao;
import controller.facade.FacadeCardapio;
import model.Administrador;
import view.TelaDeAdministrador;
import view.TelaMenuPrincipal;

public class OuvinteAcessarAdministrador implements ActionListener{
    private TelaDeAdministrador ta;
    public OuvinteAcessarAdministrador(TelaDeAdministrador ta){
    	this.ta = ta;
    }
	public void actionPerformed(ActionEvent arg0) {
           String senha = new String (ta.getSenhaCampo().getPassword());
           Administrador a = new Administrador("Administrador", ta.getCampoEmail().getText(), senha, "Masculino");
           FacadeCardapio Cardapio = FacadeCardapio.getInstance();
           FacadeAdministracao facadeAdmin = new FacadeAdministracao();
           
           if (ta.getCampoEmail().getText().equals("")|| senha.equals("")){
        	   ta.getCampoEmail().setBackground(Color.RED);
        	   ta.getSenhaCampo().setBackground(Color.RED);
        	   JOptionPane.showMessageDialog(null, "Algum campo vazio");
           }else{
        	   if(facadeAdmin.getAdministrador().getEmail().equals(a.getEmail())&& facadeAdmin.getAdministrador().getSenha().equals(a.getSenha())){
        		   ta.getCampoEmail().setBackground(Color.GREEN);
            	   ta.getSenhaCampo().setBackground(Color.GREEN);
            	   JOptionPane.showMessageDialog(null, "Campos preenchidos");
            	   JOptionPane.showMessageDialog(null, "Olá "+facadeAdmin.getAdministrador().getNome()+" Bem vindo(a)");
            	   if(Cardapio.getPedidos().size()>0 && Cardapio.getPedidos().get(Cardapio.getPedidos().size()-1).getCliente().getEmail()==null){
            		   Cardapio.getPedidos().remove(Cardapio.getPedidos().size()-1);
            		   //Cardapio.salvarDados();
            	   }
            	   new TelaMenuPrincipal(facadeAdmin.getAdministrador().getNome());
            	   ta.dispose();
            	   }
        	   else{
        		   JOptionPane.showMessageDialog(null, "Não existe esse administrador","ALERTA!",JOptionPane.ERROR_MESSAGE);
        	   }
              }
    	       ta.getCampoEmail().setText("");
		       ta.getSenhaCampo().setText("");
           }
	    }