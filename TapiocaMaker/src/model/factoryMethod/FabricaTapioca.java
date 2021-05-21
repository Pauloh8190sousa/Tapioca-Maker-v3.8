package model.factoryMethod;

public class FabricaTapioca extends FabricaTapiocaMaker{

	@Override
	public Tapioca criarTapioca(String nomeTapioca) {
		
		return new TapiocaComum(nomeTapioca);
	}

	
}
