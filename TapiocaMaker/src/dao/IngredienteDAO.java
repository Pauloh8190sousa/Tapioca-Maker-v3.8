package dao;

import java.util.ArrayList;

import model.Ingrediente;
import view.exception.IngredienteDuplicadoException;
import view.exception.IngredienteNaoPodeSerExcluidoException;

public interface IngredienteDAO {

	public void save();

	public ArrayList<Ingrediente> load();

	public void createIngrediente(Ingrediente ingrediente) throws IngredienteDuplicadoException;

	public ArrayList<Ingrediente> readIngrediente();

	public void deleteIngrediente(Ingrediente ingrediente) throws IngredienteNaoPodeSerExcluidoException;
	
}
