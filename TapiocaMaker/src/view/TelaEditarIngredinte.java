package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.facade.FacadeCardapio;
import model.Ingrediente;
import view.ouvinte.OuvinteVoltarTelaIngrediente;
import view.templateMethod.TelaPadrao;

public class TelaEditarIngredinte extends TelaPadrao{
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JComboBox<String> ingredientes;
	private JTextField campoPreco;
	private JComboBox<Float> gramas;
	
	public TelaEditarIngredinte(String usuario) {
		construirTela(usuario);
		repaint();
	}
	@Override
	public void adicionarBotoes() {
		OuvinteVoltarTelaIngrediente ouvinte = new OuvinteVoltarTelaIngrediente(this);
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(410, 10, 80, 30);
		voltar.addActionListener(ouvinte);
		add(voltar);
		
    	OuvinteButton ouvinteButton = new OuvinteButton();
    	JButton botaoEditar = new JButton("Editar");
    	botaoEditar.setBounds(200, 300, 80, 30);
    	botaoEditar.addActionListener(ouvinteButton);
    	add(botaoEditar);
		
	}
	@Override
	public void adicionarTextField() {
    	campoPreco = new JTextField();
    	campoPreco.setBounds(180, 50, 220, 30);
    	add(campoPreco);
	}
	@Override
	public void adicionarJComboBox() {
    	ingredientes = new JComboBox<>();
    	ingredientes.setToolTipText("Selecione o ingrediente");
    	FacadeCardapio facade = FacadeCardapio.getInstance();
    	if(facade.getIngredientes().size()==0){
    		ingredientes.addItem("Não tem ingrediente");
    	}else{
    	for(Ingrediente i:facade.getIngredientes()){
    		ingredientes.addItem(i.toString());
    	   }
    	}
    	ingredientes.setBounds(200, 170, 200, 30);
    	add(ingredientes);
    	
    	gramas = new JComboBox<>();
    	gramas.addItem((float) 100);
    	gramas.addItem((float) 200);
    	gramas.addItem((float)300);
    	gramas.addItem((float)500);
    	gramas.setBounds(320, 120, 80, 30);
    	add(gramas);
	}
	@Override
	public void adicionarRadioButton() {
    	ButtonGroup botaoGrupo = new ButtonGroup();
    	radioButton1 = new JRadioButton("Disponivel");
    	radioButton2 = new JRadioButton("Indisponivel");
    	radioButton1.setBounds(150, 250, 100, 30);
    	radioButton2.setBounds(260,250,100,30);
    	botaoGrupo.add(radioButton1);
    	botaoGrupo.add(radioButton2);
    	add(radioButton1);
    	add(radioButton2);
	}
	
	public class OuvinteButton implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			FacadeCardapio facade = FacadeCardapio.getInstance();
			Ingrediente i = null;
			String opcao = (String) ingredientes.getSelectedItem();
			for(int cont = 0;cont<facade.getIngredientes().size();cont++){
				if(opcao.equals(facade.getIngredientes().get(cont).toString())){
					i = facade.getIngredientes().get(cont);
					break;
				}
			}
			try{
			    float preco = Float.parseFloat(campoPreco.getText());
			    try{
			       i.setPreco(preco);
					String status = "";
					if(radioButton1.isSelected()){
						status  = radioButton1.getActionCommand();
					}else if(radioButton2.isSelected()){
						status = radioButton2.getActionCommand();
					}
					if(status.equals("")){
						JOptionPane.showMessageDialog(null, "Selecione um status");
					}else{
					i.setStatus(status);
					i.setCalorias((float) gramas.getSelectedItem());
					facade.saveIngrediente();
					ingredientes.removeAllItems();
					for(Ingrediente x: facade.getIngredientes()){
						ingredientes.addItem(x.toString());
					}
					JOptionPane.showMessageDialog(null, "Editado");
					}
					campoPreco.setText("");
			    }catch(Exception exc){
			    	JOptionPane.showMessageDialog(null, "Não há ingredientes para editar", "ATENÇÂO", JOptionPane.WARNING_MESSAGE);
			    }
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Preço inválido", "ATENÇÂO", JOptionPane.WARNING_MESSAGE);
			}
	    }
   }

	@Override
	public void menuAdministrador() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuCliente() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void adicionarLabel(String usuario) {
    	JLabel preco = new JLabel("Preço");
    	preco.setBounds(120, 50, 50, 30);
    	add(preco);
    	
    	JLabel labelGramas = new JLabel("gramas");
    	labelGramas.setBounds(410,120,50,30);
    	add(labelGramas);
		
	}
	@Override
	public void adicionarTabela() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isBotoes() {
		return true;
	}
	@Override
	public boolean isTextField() {
		return true;
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
		return true;
	}
	@Override
	public boolean isJComboBox() {
		return true;
	}
	@Override
	public boolean isMenuCliente() {
		return false;
	}
	@Override
	public boolean isMenuAdministrador() {
		return false;
	}
}