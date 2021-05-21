package view.templateMethod;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class TelaPadrao extends JFrame{
    
    public final void construirTela(String usuario){
    	setTitle("Tapioca Maker");
    	setIconImage(new ImageIcon(getClass().getResource("/icons8-taco-30.png")).getImage());
    	setLayout(null);
        setResizable(false);
    	setSize(500,400);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	setLocationRelativeTo(null);
     	
     	if(isMenuCliente() && isMenuAdministrador()){
     		if(usuario.equals("Cliente"))
     			menuCliente();
     		else
     			menuAdministrador();
     	}
     	
     	if(isBotoes())
     		adicionarBotoes();
     	if(isTextField())
     		adicionarTextField();
     	if(isTabela())
     		adicionarTabela();
     	if(isRadioButton())
     		adicionarRadioButton();
     	if(isJComboBox())
     		adicionarJComboBox();
     	if(isLabel())
     		adicionarLabel(usuario);
     	setVisible(true);
    }
    
    
    public abstract void menuAdministrador();
    
    public abstract void menuCliente();
    
    public abstract void adicionarBotoes();
    
    public abstract void adicionarTextField();
    
    public abstract void adicionarLabel(String usuario);
    	
    public abstract void adicionarTabela();
    	
    public abstract void adicionarRadioButton();
    	
    public abstract void adicionarJComboBox();
    
    
    public abstract boolean isBotoes();
    
    public abstract boolean isTextField();
    
    public abstract boolean isLabel();
    
    public abstract boolean isTabela();
    
    public abstract boolean isRadioButton();
    
    public abstract boolean isJComboBox();

    public abstract boolean isMenuCliente();
    
    public abstract boolean isMenuAdministrador();


}