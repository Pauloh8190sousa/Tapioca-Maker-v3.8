package view.exception;

public class IngredienteNaoPodeSerExcluidoException extends Exception {

	public String getMessage(){
		return "Ingrediente n�o pode ser exclu�do, pois est� em tapiocas do card�pio.";
	}
	
}
