package dao.abstractFactory;

import dao.AdminDAO;
import dao.AdminDAOXML;
import dao.IngredienteDAO;
import dao.IngredienteDAOXML;
import dao.PedidoDAO;
import dao.PedidoDAOXML;
import dao.TapiocaDAO;
import dao.TapiocaDAOXML;

public class FabricaDAOXML implements FabricaDAO {

	@Override
	public IngredienteDAO criarIngredienteDAO() {
		// TODO Auto-generated method stub
		return new IngredienteDAOXML();
	}

	@Override
	public TapiocaDAO criarTapiocaDAO() {
		// TODO Auto-generated method stub
		return new TapiocaDAOXML();
	}

	@Override
	public PedidoDAO criarPedidoDAO() {
		// TODO Auto-generated method stub
		return new PedidoDAOXML();
	}

	@Override
	public AdminDAO criarAdminDAO() {
		// TODO Auto-generated method stub
		return new AdminDAOXML();
	}

	
}
