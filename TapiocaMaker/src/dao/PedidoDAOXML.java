
package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.Pedido;

public class PedidoDAOXML implements PedidoDAO{

	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	private File arquivo;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	public PedidoDAOXML() {
		pedidos = load();
	}
	
	public void save() {
		arquivo = new File("pedidos.xml");
		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
		xml += xstream.toXML(pedidos);
		try {
			arquivo.createNewFile();
			PrintWriter gravar = new PrintWriter(arquivo);
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Pedido> load() {
		arquivo = new File("pedidos.xml");
		try {
			if(arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				return (ArrayList<Pedido>) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<Pedido>();
	}

	public void createPedido(Pedido pedido) {
		pedidos.add(pedido);
		save();
	}

	public ArrayList<Pedido> readPedido() {
		pedidos = load();
		return pedidos;
	}

	@Override
	public void deletePedido() {
		pedidos.remove(pedidos.size()-1);
		save();
	}

}
