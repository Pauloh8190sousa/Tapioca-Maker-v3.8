package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.Ingrediente;
import model.factoryMethod.Tapioca;
import model.iterator.IterarColecaoConcreto;
import model.iterator.Iterator;
import view.exception.IngredienteDuplicadoException;
import view.exception.IngredienteNaoPodeSerExcluidoException;

public class IngredienteDAOXML implements IngredienteDAO {

	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	private File arquivo;
	private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	private IterarColecaoConcreto iterarIngrediente = new IterarColecaoConcreto(ingredientes);
	private Iterator iteratorArrayIngrediente = iterarIngrediente.criarIterator();

	public IngredienteDAOXML() {
		ingredientes = load();
	}
	
 	public void save() {
		arquivo = new File("ingredientes.xml");
		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
		xml += xstream.toXML(ingredientes);
		try {
			arquivo.createNewFile();
			PrintWriter gravar = new PrintWriter(arquivo);
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Ingrediente> load() {
		arquivo = new File("ingredientes.xml");
		try {
			if(arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				return (ArrayList<Ingrediente>) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<Ingrediente>();
	}

	public void createIngrediente(Ingrediente ingrediente) throws IngredienteDuplicadoException{

		while (iteratorArrayIngrediente.hasNext()) {
			Ingrediente ingredienteDaVez = (Ingrediente) iteratorArrayIngrediente.next();
			if(ingrediente.getNome().equalsIgnoreCase(ingredienteDaVez.getNome())){
				throw new IngredienteDuplicadoException();
			}
		}
		
		ingredientes.add(ingrediente);
		/*for (ArrayList<String> ingredienteDaVez: ingredientes) {
			//Ingrediente ingredienteDaVez = (Ingrediente) iteratorArrayIngrediente.next();
			if(ingrediente.getNome().equalsIgnoreCase(ingredienteDaVez.get(0))){
				throw new IngredienteDuplicadoException();
			}
		}
		
		ArrayList<String> ingredienteSave = new ArrayList<String>();
		ingredienteSave.add(ingrediente.getNome());
		ingredienteSave.add(ingrediente.getStatus());
		ingredienteSave.add(Float.toString(ingrediente.getCalorias()));
		ingredienteSave.add(Float.toString(ingrediente.getPreco()));
		
		ingredientes.add(ingredienteSave);*/
		save();
	}

	public ArrayList<Ingrediente> readIngrediente() {
		return load();
	}

	public void deleteIngrediente(Ingrediente ingrediente) throws IngredienteNaoPodeSerExcluidoException {

		TapiocaDAO tapiocaJDBC = new TapiocaDAOXML();
		ArrayList<Tapioca> tapiocas = tapiocaJDBC.readTapioca();
		IterarColecaoConcreto iterarTapioca = new IterarColecaoConcreto(tapiocas);
		Iterator iteratorArrayTapioca = iterarTapioca.criarIterator();
		
		while (iteratorArrayTapioca.hasNext()) {
			Tapioca contTapioca = (Tapioca) iteratorArrayTapioca.next();
			for(Ingrediente e: contTapioca.getArray()){
				if(e.getNome().equals(ingrediente.getNome())){
					new IngredienteNaoPodeSerExcluidoException();
				}
			}
		}
		
		while (iteratorArrayIngrediente.hasNext()) {
			Ingrediente ingredienteDaVez = (Ingrediente) iteratorArrayIngrediente.next();
			if(ingrediente.getNome().equals(ingredienteDaVez.getNome())){
				ingredientes.remove(ingrediente);
			}
		}
		save();
	}
}
