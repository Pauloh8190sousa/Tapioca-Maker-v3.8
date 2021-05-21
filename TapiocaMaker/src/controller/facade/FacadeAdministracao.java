package controller.facade;

import java.util.ArrayList;

import dao.AdminDAO;
import dao.abstractFactory.FabricaDAO;
import dao.abstractFactory.FabricaDAOXML;
import model.Administrador;
import model.Email;
import model.Pedido;

public class FacadeAdministracao {
	
	private FabricaDAO fabricaDAO = new FabricaDAOXML();
	private AdminDAO adminDAO = fabricaDAO.criarAdminDAO();
	private Email email = new Email();
	
	public boolean adicionarAdministrador(Administrador admin){
	   //return central.adicionarAdministrador(admin);
		return adminDAO.createAdmin(admin);
	}
	
	public void excluirAdministrador(){
		//central.excluirAdministrador();	 
		adminDAO.deleteAdmin();
	}
	
	public Administrador getAdministrador(){
	    //return central.getAdministrador();
		return adminDAO.readAdmin();
	}
	
    public boolean enviarEmailComAnexo(String nome,String destino,String assunto,String msg,String arquivo){
    	return email.enviarComAnexo(nome, destino, assunto, msg, arquivo); 
    }
    
    public boolean enviarEmailATodosOsClientes(String descricao){
    	FacadeCardapio cardapio = FacadeCardapio.getInstance();
    	ArrayList<String> emails = new ArrayList<>();
    	for(Pedido x: cardapio.getPedidos()){
		      if(emails.size()!=0){
		    	  boolean teste = true;
		    	  for(String e: emails){
		    		  if(e.equals(x.getCliente().getEmail())){
		    			  teste = false;
		    			  break;
		    		  }
		    	  }
		    	  if(teste==true){
		    		  emails.add(x.getCliente().getEmail());
		    	  }
		      }else{
		    	  emails.add(x.getCliente().getEmail());
		      }
		}
		
		boolean confirmacao = false;
		for(String e: emails){
			confirmacao = enviarEmail(e, "Avisos Tapioca Maker",descricao);
		}
		return confirmacao;
    }
    
    public boolean enviarEmail(String destino,String assunto,String msg){
    	return email.enviarEmail(destino, assunto, msg);
    }
  
}
