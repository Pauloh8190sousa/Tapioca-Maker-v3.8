package view.exception;

public class IngredienteDuplicadoException extends Exception{

	public String getMessage(){
		return "Ingrediente j� existe";
	}
}
