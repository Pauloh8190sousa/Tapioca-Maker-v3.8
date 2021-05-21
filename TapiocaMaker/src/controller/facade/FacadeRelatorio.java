package controller.facade;

import model.GeradorDePDF;
import model.Pedido;

public class FacadeRelatorio {
	
    private FacadeCardapio facadeCardapio = FacadeCardapio.getInstance();
    private GeradorDePDF gerador = new GeradorDePDF(); 
   
    public void gerarCardapio(String arquivo){
    	gerador.gerarCardapio(facadeCardapio, arquivo);
    }
    public void gerarDadosDeCompraParaOAdministrador(Pedido pedido,String arquivo, String data, String hora, int tempoDeEntrega){
    	gerador.gerarDadosDeCompraParaOAdministrador(pedido, arquivo, data, hora, tempoDeEntrega);
    }
  
    public void gerarDadosDoCliente(Pedido pedido,String arquivo,String data,String hora,int tempoDeEntrega){
    	gerador.gerarDadosDoCliente(pedido, arquivo, data, hora, tempoDeEntrega);
    }
    public void gerarRelatorio(String arquivo){
    	gerador.gerarRelatorio(facadeCardapio, arquivo);
    }

}
