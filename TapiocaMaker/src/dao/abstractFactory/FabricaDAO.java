package dao.abstractFactory;

import dao.AdminDAO;
import dao.IngredienteDAO;
import dao.PedidoDAO;
import dao.TapiocaDAO;

public interface FabricaDAO {

	public IngredienteDAO criarIngredienteDAO();
	
	public TapiocaDAO criarTapiocaDAO();
	
	public PedidoDAO criarPedidoDAO();
	
	public AdminDAO criarAdminDAO();
}

