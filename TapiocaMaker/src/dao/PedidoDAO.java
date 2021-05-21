package dao;

import java.util.ArrayList;

import model.Pedido;

public interface PedidoDAO {

	public void save();

	public ArrayList<Pedido> load();

	public void createPedido(Pedido pedido);

	public ArrayList<Pedido> readPedido();

	public void deletePedido();
}
