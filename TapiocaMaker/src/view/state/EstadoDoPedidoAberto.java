package view.state;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Pedido;

public class EstadoDoPedidoAberto implements EstadoDoPedido{

    private String dataInicioDoPedido;
    private String status;
    
	public void statusPedido() {
		this.status = "Aberto"; 
		Date data = new Date();
		SimpleDateFormat dataFormatada= new SimpleDateFormat("dd/MM/yyyy");
		dataInicioDoPedido = dataFormatada.format(data);
		JOptionPane.showMessageDialog(null, "Pedido em aberto");
	}



	@Override
	public String getStatus() {
		return status;
	}


	@Override
	public String getDataInicial() {
		return dataInicioDoPedido;
	}



	@Override
	public String situacaoDataStatus() {
		return "Em processo";
	}
	
}
