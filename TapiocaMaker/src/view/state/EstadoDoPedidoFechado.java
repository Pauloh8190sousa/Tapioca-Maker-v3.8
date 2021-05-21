package view.state;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Pedido;

public class EstadoDoPedidoFechado implements EstadoDoPedido{
//	private SimpleDateFormat datainicial;
    private String dataFinalDoPedido;
    private String status;
    
	public void statusPedido() {
		this.status = "Fechado";
		Date data = new Date();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		dataFinalDoPedido = dataFormatada.format(data);
		JOptionPane.showMessageDialog(null, "Pedido Fechado");
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public String getDataInicial() {
		return dataFinalDoPedido;
	}

	@Override
	public String situacaoDataStatus() {
		return dataFinalDoPedido;
	}



	
}
