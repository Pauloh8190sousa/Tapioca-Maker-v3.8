package view;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import view.ouvinte.OuvinteAdicionarIngredientes;
import view.ouvinte.OuvinteGerarRelatorio;
import view.ouvinte.OuvinteImprimirCardapio;
import view.ouvinte.OuvinteListaDeTapioca;
import view.ouvinte.OuvinteParaTelaDeIngredientes;
import view.ouvinte.OuvinteSobre;
import view.ouvinte.OuvinteTelaCarrinho;
import view.ouvinte.OuvinteTelaEnviarPromocao;
import view.ouvinte.OuvinteTelaPedido;
import view.ouvinte.OuvinteTelaTapioca;
import view.ouvinte.OuvinteVoltarPrimeiraTela;
import view.templateMethod.TelaPadrao;

public class TelaMenuPrincipal extends TelaPadrao{
	
	private String nome;
	private JMenuBar bar;
	private JMenu menu;
	private JMenuItem sair;
	
	public TelaMenuPrincipal(String nome){
		
		this.nome = nome;
		bar = new JMenuBar();
		menu = new JMenu("Menu");
		bar.add(menu);
		bar.setBounds(0, 2, 500, 30);
		bar.setBackground(Color.GRAY);
		menu.setForeground(Color.WHITE);
		menu.setIcon(new ImageIcon(getClass().getResource("/icons8-menu-vertical-20.png")));
		JMenuItem tapiocas = new JMenuItem("Tapiocas");
		tapiocas.setIcon(new ImageIcon(getClass().getResource("/icons8-taco-20.png")));
		OuvinteListaDeTapioca olt = new OuvinteListaDeTapioca(this);
		tapiocas.addActionListener(olt);
		menu.add(tapiocas);
		
		construirTela(nome);
		
		sair = new JMenuItem("Sair");
		OuvinteVoltarPrimeiraTela ouvinte = new OuvinteVoltarPrimeiraTela(this);
		sair.setIcon(new ImageIcon(getClass().getResource("/icons8-undo-20.png")));
		sair.addActionListener(ouvinte);
		menu.add(sair);
		JMenu informacoes = new JMenu("Informações");
		informacoes.setIcon(new ImageIcon(getClass().getResource("/icons8-informações-20.png")));
		informacoes.setForeground(Color.WHITE);
		JMenuItem sobre = new JMenuItem("Sobre");
		informacoes.add(sobre);
		OuvinteSobre ouvinteSobre = new OuvinteSobre();
		sobre.addActionListener(ouvinteSobre);
        bar.add(informacoes);
        repaint();
	}
	@Override
	public void adicionarBotoes() {}
	
	@Override
	public void adicionarLabel(String usuario) {
		JLabel borda = new JLabel();
		borda.setBounds(0, 55, 500, 30);
		borda.setOpaque(true);
		borda.setBackground(Color.WHITE);
		JLabel bemVindo = new JLabel("Bem-Vindo(a) "+usuario);
		bemVindo.setBounds(135, 55, 275, 30);
		bemVindo.setForeground(Color.BLUE);
		bemVindo.setFont(new Font("Arial",Font.ITALIC,20));
		add(bemVindo);
		add(borda);
		
		JLabel tapioca = new JLabel("Tapioca Maker");
		tapioca.setBounds(120, 100, 178, 50);
		tapioca.setFont(new Font("Arial",Font.ITALIC,18));
		tapioca.setForeground(Color.YELLOW);
		tapioca.setIcon(new ImageIcon(getClass().getResource("/icons8-taco-50.png")));
		add(tapioca);
		
		JLabel imagem = new JLabel();
		imagem.setIcon(new ImageIcon(getClass().getResource("/Tapioca-doce-500x400.jpg")));
		imagem.setBounds(0, 32, 500, 400);
		add(imagem);
	}


	public String getNome(){
		return nome;
	}
	@Override
	public void menuAdministrador() {
		JMenu enviarMala = new JMenu("Enviar mala direta");
		JMenu gerarRelatorio = new JMenu("Gerar relatório");
		gerarRelatorio.setIcon(new ImageIcon(getClass().getResource("/icons8-impressão-20.png")));
		enviarMala.setIcon(new ImageIcon(getClass().getResource("/icons8-enviar-e-mail-em-massa-20.png")));
		enviarMala.setForeground(Color.WHITE);
		gerarRelatorio.setForeground(Color.WHITE);
		OuvinteGerarRelatorio ouvinteRelatorio = new OuvinteGerarRelatorio();
		JMenuItem relatorio = new JMenuItem("Relátorio");
		relatorio.addActionListener(ouvinteRelatorio);
		relatorio.setIcon(new ImageIcon(getClass().getResource("/icons8-exportar-pdf-20.png")));
		gerarRelatorio.add(relatorio);
		bar.add(enviarMala);
		bar.add(gerarRelatorio);
		OuvinteTelaEnviarPromocao ouvintePromocoes = new OuvinteTelaEnviarPromocao(this);
		JMenuItem enviarPromocoes = new JMenuItem("Enviar promoções");
		enviarPromocoes.addActionListener(ouvintePromocoes);
		enviarMala.add(enviarPromocoes);
		enviarPromocoes.setIcon(new ImageIcon(getClass().getResource("/icons8-publicidade-20.png")));
		JMenuItem ingredientes = new JMenuItem("Ingredientes");
		ingredientes.setIcon(new ImageIcon(getClass().getResource("/icons8-list-view-20.png")));
		OuvinteParaTelaDeIngredientes ouvinteIngrediente = new OuvinteParaTelaDeIngredientes(this);
		ingredientes.addActionListener(ouvinteIngrediente);
		menu.add(ingredientes);
		JMenuItem adicionarIngredientes = new JMenuItem("Adicionar Ingrediente");
		adicionarIngredientes.setIcon(new ImageIcon(getClass().getResource("/icons8-ingredients-20.png")));
		OuvinteAdicionarIngredientes ouvinteAdicionar = new OuvinteAdicionarIngredientes(this);
		adicionarIngredientes.addActionListener(ouvinteAdicionar);
		menu.add(adicionarIngredientes);
		JMenuItem adicionarTapioca = new JMenuItem("Adicionar Tapioca");
		adicionarTapioca.setIcon(new ImageIcon(getClass().getResource("/icons8-adicionar-regra-20.png")));
		OuvinteTelaTapioca ouvinteTapioca = new OuvinteTelaTapioca(this);
		adicionarTapioca.addActionListener(ouvinteTapioca);
		menu.add(adicionarTapioca);
		JMenuItem pedidos = new JMenuItem("Pedidos");
		pedidos.setIcon(new ImageIcon(getClass().getResource("/icons8-sacola-de-compras-20.png")));
		OuvinteTelaPedido ouvintePedido = new OuvinteTelaPedido(this);
		pedidos.addActionListener(ouvintePedido);
		menu.add(pedidos);
		add(bar);
		
	}
	@Override
	public void adicionarTextField() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void adicionarTabela() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void adicionarRadioButton() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void adicionarJComboBox() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuCliente() {
		OuvinteTelaCarrinho pe = new OuvinteTelaCarrinho(this);
		JMenuItem carrinho = new JMenuItem("Meu Carrinho");
		carrinho.addActionListener(pe);
		carrinho.setIcon(new ImageIcon(getClass().getResource("/icons8-add-shopping-cart-20.png")));
		menu.add(carrinho);
		JMenu imprimir = new JMenu("Imprimir");
		imprimir.setForeground(Color.WHITE);
		imprimir.setIcon(new ImageIcon(getClass().getResource("/icons8-impressão-20.png")));
		JMenuItem cardapio = new JMenuItem("Cardápio");
		OuvinteImprimirCardapio ouvinteImprimir = new OuvinteImprimirCardapio(this);
		cardapio.setIcon(new ImageIcon(getClass().getResource("/icons8-exportar-pdf-20.png")));
	    imprimir.add(cardapio);
	    cardapio.addActionListener(ouvinteImprimir);
	    bar.add(imprimir);
		add(bar);
		
	}
	@Override
	public boolean isBotoes() {
		return false;
	}
	@Override
	public boolean isTextField() {
		return false;
	}
	@Override
	public boolean isLabel() {
		return true;
	}
	@Override
	public boolean isTabela() {
		return false;
	}
	@Override
	public boolean isRadioButton() {
		return false;
	}
	@Override
	public boolean isJComboBox() {
		return false;
	}
	@Override
	public boolean isMenuCliente() {
		return true;
	}
	@Override
	public boolean isMenuAdministrador() {
		return true;
	}

}