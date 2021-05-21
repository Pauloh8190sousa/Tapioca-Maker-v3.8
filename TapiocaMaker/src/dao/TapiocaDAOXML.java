package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.factoryMethod.Tapioca;
import model.iterator.IterarColecaoConcreto;
import model.iterator.Iterator;
import view.exception.TapiocaDuplicadaException;

public class TapiocaDAOXML implements TapiocaDAO{

	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	private File arquivo;
	private ArrayList<Tapioca> tapiocas = new ArrayList<Tapioca>();
	private ArrayList<Tapioca> tapiocasExcluidas = new ArrayList<Tapioca>();
	private IterarColecaoConcreto iterarTapioca = new IterarColecaoConcreto(tapiocas);
	private Iterator iteratorArrayTapioca = iterarTapioca.criarIterator();
	
	public TapiocaDAOXML() {
		tapiocas = load("tapiocas");
		tapiocasExcluidas = load("tapiocasExcluidas");
	}
	
	public void save(String tapiocaArquivo) {
		arquivo = new File(tapiocaArquivo + ".xml");
		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
		xml += xstream.toXML(tapiocas);
		try {
			arquivo.createNewFile();
			PrintWriter gravar = new PrintWriter(arquivo);
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Tapioca> load(String tapiocaArquivo) {
		arquivo = new File(tapiocaArquivo + ".xml");
		try {
			if(arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				return (ArrayList<Tapioca>) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<Tapioca>();
	}

	public void createTapioca(Tapioca tapioca) throws TapiocaDuplicadaException {
		while (iteratorArrayTapioca.hasNext()){
			Tapioca tapiocaDaVez = (Tapioca) iteratorArrayTapioca.next();
			if(tapioca.getNome().equalsIgnoreCase(tapiocaDaVez.getNome())){
				throw new TapiocaDuplicadaException();
			}
		}

		tapiocas.add(tapioca);
		/*ArrayList<String> tapiocaSave = new ArrayList<String>();
		tapiocaSave.add(tapioca.getNome());
		tapiocaSave.add(Integer.toString(tapioca.getQuantidadeDaTapiocaComprada()));
		tapiocaSave.add(Float.toString(tapioca.getGramas()));
		tapiocaSave.add(Float.toString(tapioca.getPreco()));
		//tapiocaSave.add(tapioca.getArray());
		
		tapiocas.add(tapiocaSave);*/
		save("tapiocas");
	}

	public ArrayList<Tapioca> readTapioca() {
		tapiocas = load("tapiocas");
		return tapiocas;
	}
	
	public ArrayList<Tapioca> readTapiocaExcluidas() {
		tapiocasExcluidas = load("tapiocasExcluidas");
		return tapiocasExcluidas;
	}

	public void deleteTapioca(Tapioca tapioca) {

		tapiocasExcluidas.add(tapioca);
		save("tapiocasExcluidas");
		
		while (iteratorArrayTapioca.hasNext()) {
			Tapioca tapiocaDaVez = (Tapioca) iteratorArrayTapioca.next();
			if(tapioca.getNome().equals(tapiocaDaVez.getNome())){
				tapiocas.remove(tapioca);
			}
		}
		save("tapiocas");
	}
}
