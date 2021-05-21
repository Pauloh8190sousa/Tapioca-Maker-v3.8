package model.ValidarEmail;

import view.exception.EmailInvalidoException;

public class ValidacaoEmail {

	public void validarEmail(String entradaParaValidar) throws EmailInvalidoException{
			String regex = "[A-Za-z0-9\\._-]+@[A-Za-z]+\\.[A-Za-z]+";
			if(entradaParaValidar.matches(regex)==false){
			   throw new EmailInvalidoException();
			}
	}
}
