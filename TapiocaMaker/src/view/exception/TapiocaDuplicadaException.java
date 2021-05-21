package view.exception;

public class TapiocaDuplicadaException extends Exception{

	public String getMessage(){
		return "Tapioca já existe";
	}
}
