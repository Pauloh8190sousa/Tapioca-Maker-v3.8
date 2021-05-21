package model.decorator.copy;

import view.exception.EmailInvalidoException;

public class ValidacaoDeLetras extends DecoratorValidacao{

	public ValidacaoDeLetras(Validacao validacao) {
		super(validacao);
	}
	
	@Override
	public boolean validacao(String entradaParaValidar) throws Exception {
		boolean confirmacao = super.validacao(entradaParaValidar);
		int letras = 0;
		if(confirmacao){
			for(int cont = 0;cont<entradaParaValidar.length();cont++){
				if(Character.isLetter(entradaParaValidar.charAt(cont))==true){
					letras+=1;
				}
			}
			if(letras>2)
				return true;
			else
				throw new Exception("Letra com menos de 3 caracteres");
		}
		return false;
	}

}
