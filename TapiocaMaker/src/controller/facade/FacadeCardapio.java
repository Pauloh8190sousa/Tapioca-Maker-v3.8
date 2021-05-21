package controller.facade;

import java.util.ArrayList;

import dao.IngredienteDAO;
import dao.PedidoDAO;
import dao.TapiocaDAO;
import dao.abstractFactory.FabricaDAO;
import dao.abstractFactory.FabricaDAOXML;
import model.Ingrediente;
import model.Pedido;
import model.factoryMethod.Tapioca;
import view.exception.IngredienteDuplicadoException;
import view.exception.IngredienteNaoPodeSerExcluidoException;
import view.exception.TapiocaDuplicadaException;

public class FacadeCardapio {

	private static FacadeCardapio facadeCardapio;
	
	private FabricaDAO fabricaDAO = new FabricaDAOXML();
	private TapiocaDAO tapiocaDAO = fabricaDAO.criarTapiocaDAO();
	private IngredienteDAO ingredienteDAO = fabricaDAO.criarIngredienteDAO();
	private PedidoDAO pedidoDAO = fabricaDAO.criarPedidoDAO();

	private FacadeCardapio() {}
	
	public void savePedido(){
		pedidoDAO.save();
	}
	public void saveIngrediente(){
		ingredienteDAO.save();
	}
	public static FacadeCardapio getInstance() {

		if (facadeCardapio == null) {
			synchronized (FacadeCardapio.class) {
				if (facadeCardapio == null) {
					facadeCardapio = new FacadeCardapio();
				}
			}
		}

		return facadeCardapio;
	}

	public void adicionarTapioca(Tapioca tapioca) throws TapiocaDuplicadaException{
		tapiocaDAO.createTapioca(tapioca);
	}
	public void excluirTapioca(Tapioca tapioca){
		tapiocaDAO.deleteTapioca(tapioca);;
	}

	public ArrayList<Tapioca> getTapiocas(){
		return tapiocaDAO.readTapioca();
	}

	public ArrayList<Tapioca> getTapiocasExcluidas(){
		return tapiocaDAO.readTapiocaExcluidas();
	}

	public void adicionarIngrediente(Ingrediente ingrediente) throws IngredienteDuplicadoException{
		ingredienteDAO.createIngrediente(ingrediente);
	}

	public void excluirIngrediente(Ingrediente ingrediente) throws IngredienteNaoPodeSerExcluidoException {
		ingredienteDAO.deleteIngrediente(ingrediente);
	}

	public ArrayList<Ingrediente> getIngredientes(){
		return ingredienteDAO.readIngrediente();
	}

	public void adicionarPedido(Pedido pedido){
		pedidoDAO.createPedido(pedido);
	}
	public void excluirPedido(){
		pedidoDAO.deletePedido();
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidoDAO.readPedido();
	}

}
