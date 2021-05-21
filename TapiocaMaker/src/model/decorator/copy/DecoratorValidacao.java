package model.decorator.copy;


public class DecoratorValidacao extends Validacao{
    private Validacao validacao;
    public DecoratorValidacao(Validacao validacao) {
		this.validacao = validacao;
	}

	public boolean validacao(String entradaParaValidar) throws Exception {
		return validacao.validacao(entradaParaValidar);
	}

}
