package view.state;

import java.text.SimpleDateFormat;

import model.Pedido;

public interface EstadoDoPedido {

	public void statusPedido();
	public String getStatus();
	public String getDataInicial();
	public String situacaoDataStatus();
	
}
