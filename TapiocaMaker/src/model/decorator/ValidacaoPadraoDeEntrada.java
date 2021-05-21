package model.decorator;

import view.exception.EmailInvalidoException;
import view.exception.SenhaInvalidaException;

public class ValidacaoPadraoDeEntrada extends Validacao{

	public boolean validacao(String entradaParaValidar) throws Exception {
		if(entradaParaValidar.equals("")){
			return false;
		}
		return true;
	}







}
