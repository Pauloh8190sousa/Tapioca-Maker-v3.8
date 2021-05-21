package dao;

import java.util.ArrayList;

import model.factoryMethod.Tapioca;
import view.exception.TapiocaDuplicadaException;

public interface TapiocaDAO {

	public void save(String tapiocaArquivo);
	
	public ArrayList<Tapioca> load(String tapiocaArquivo);
	
	public void createTapioca(Tapioca tapioca) throws TapiocaDuplicadaException;
	
	public ArrayList<Tapioca> readTapioca();
	
	public ArrayList<Tapioca> readTapiocaExcluidas();
	
	public void deleteTapioca(Tapioca tapioca);
}
