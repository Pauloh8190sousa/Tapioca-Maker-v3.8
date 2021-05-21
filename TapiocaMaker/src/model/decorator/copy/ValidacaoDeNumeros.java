package model.decorator.copy;

import view.exception.SenhaInvalidaException;

public class ValidacaoDeNumeros extends DecoratorValidacao{

	public ValidacaoDeNumeros(Validacao validacao) {
		super(validacao);
	}
    
	@Override
	public boolean validacao(String entradaParaValidar) throws Exception {
		boolean confirmacao = super.validacao(entradaParaValidar);
		int numeros = 0;
		if(confirmacao){
			for(int cont = 0;cont<entradaParaValidar.length();cont++){
				if(Character.isDigit(entradaParaValidar.charAt(cont))==true){
					numeros+=1;
				}
			}
			if(numeros>2)
				return true;
			else
				throw new Exception("Tem que ter pelo menos 3 números");
		}
		return false;
	}
}
