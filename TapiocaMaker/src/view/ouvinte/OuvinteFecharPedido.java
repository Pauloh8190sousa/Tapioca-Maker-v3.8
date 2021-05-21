package view.ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import controller.facade.FacadeAdministracao;
import controller.facade.FacadeCardapio;
import controller.facade.FacadeRelatorio;
import model.Pedido;
import model.ValidarEmail.ValidacaoEmail;
import model.decorator.Validacao;
import model.decorator.ValidacaoPadraoDeEntrada;
import view.TelaFazerPedido;
import view.TelaMeuCarrinho;
import view.state.EstadoDoPedidoAberto;


public class OuvinteFecharPedido implements ActionListener{
    private TelaFazerPedido tfp;
    public OuvinteFecharPedido(TelaFazerPedido tfp){
    	this.tfp = tfp;
    	
    }
	public void actionPerformed(ActionEvent arg0) {
		String email = tfp.getCampoEmail().getText();
	    String nome = tfp.getCampoNome().getText();
	    String endereco = tfp.getCampoEndereco().getText();
	    FacadeAdministracao facade = new FacadeAdministracao();
	    FacadeRelatorio facadeRelatorio = new FacadeRelatorio();  
	    FacadeCardapio cardapio = FacadeCardapio.getInstance();
	    
		Validacao validacaoPadrao = new ValidacaoPadraoDeEntrada();
   	 	ValidacaoEmail validacaoEmail = new ValidacaoEmail();
   	  try {
		if(validacaoPadrao.validacao(nome)==false||validacaoPadrao.validacao(email)==false||validacaoPadrao.validacao(endereco)==false){
			JOptionPane.showMessageDialog(tfp, "Campo vazio");
		}else{
			
			Pedido pedido = cardapio.getPedidos().get(cardapio.getPedidos().size()-1);
				 validacaoEmail.validarEmail(email);
				 cardapio.excluirPedido();
		    	 pedido.setEndereco(endereco);
				 pedido.getCliente().setEmail(email);
				 pedido.getCliente().setNome(nome);
				 pedido.setEstadoDoPedido(new EstadoDoPedidoAberto());;
			Date data = new Date();
			SimpleDateFormat dataFormatada = new SimpleDateFormat();
			String[] dataAtual = dataFormatada.format(data).split(" ");
			int tempoDeEntrega = (int)( 20+Math.random()*30);
			facadeRelatorio.gerarDadosDoCliente(pedido, "Pedido.pdf",dataAtual[0],dataAtual[1],tempoDeEntrega);
			facadeRelatorio.gerarDadosDeCompraParaOAdministrador(pedido, "DadosDeCompra.pdf", dataAtual[0], dataAtual[1],tempoDeEntrega);
			boolean teste = facade.enviarEmailComAnexo(pedido.getCliente().getNome(), pedido.getCliente().getEmail(),"Dados do seu pedido","Olá, "+pedido.getCliente().getNome()+" esses são os seus dados. Segue o anexo abaixo", "Pedido.pdf");
			facade.enviarEmailComAnexo(facade.getAdministrador().getNome(), facade.getAdministrador().getEmail(), "PEDIDO EM ABERTO-TAPIOCA MAKER", "Olá "+facade.getAdministrador().getNome()+", aqui está um pedido feito na sua tapiocaria, os dados estão abaixo!", "DadosDeCompra.pdf");
			if(teste==true){
			JOptionPane.showMessageDialog(tfp, "E-mail enviado "+pedido.getCliente().getNome());
			cardapio.adicionarPedido(pedido);
			JOptionPane.showMessageDialog(tfp, "Pedido feito");
			JOptionPane.showMessageDialog(tfp, "Você voltara para a tela anterior!");
			new TelaMeuCarrinho("Cliente");
			tfp.dispose();
			}else{
				JOptionPane.showMessageDialog(tfp, "Sem internet!");
				}
			}
   	        }catch (Exception e) {
				JOptionPane.showMessageDialog(tfp, e.getMessage());
			}
		tfp.getCampoEmail().setText("");
		tfp.getCampoNome().setText("");
		tfp.getCampoEndereco().setText("");
  }
}
