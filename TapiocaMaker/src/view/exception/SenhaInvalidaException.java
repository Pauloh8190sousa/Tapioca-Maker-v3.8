package view.exception;

public class SenhaInvalidaException extends Exception{

	public String getMessage(){
		return "Senha inv�lida, a senha tem que ter 3 letras e 1 n�mero pelo menos";
	}
}
