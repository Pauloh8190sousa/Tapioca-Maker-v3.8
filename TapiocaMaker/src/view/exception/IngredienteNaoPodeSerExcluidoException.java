package view.exception;

public class IngredienteNaoPodeSerExcluidoException extends Exception {

	public String getMessage(){
		return "Ingrediente não pode ser excluído, pois está em tapiocas do cardápio.";
	}
	
}
