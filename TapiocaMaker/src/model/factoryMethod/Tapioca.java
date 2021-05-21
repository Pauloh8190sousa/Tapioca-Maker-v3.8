package model.factoryMethod;
import java.util.ArrayList;

import model.Ingrediente;

public abstract class Tapioca {
	private String nome;
	private float preco;
	private float gramas;
	private int quantidadeDaTapiocaComprada;
	private ArrayList<Ingrediente> array = new ArrayList<>();

	public Tapioca(String nome) {
		this.nome = nome;
		
	}
	public float getGramas() {
		float total = 0;
		for(Ingrediente a:array){
			total+= a.getCalorias();
		}
		gramas = total;
		return gramas;
	}
    public String toString(){
    	return nome+" - preço: "+getPreco();
    }
	public String getNome() {
		return nome;
	}
    public void aumentarQuandidadesDeTapiocasCompradas(){
    	quantidadeDaTapiocaComprada+=1;
    }
    public int getQuantidadeDaTapiocaComprada(){
    	return quantidadeDaTapiocaComprada;
    }
	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		float total = 0;
		for (Ingrediente i: array) {
			total += i.getPreco();
		}
		preco = total;
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public ArrayList<Ingrediente> getArray() {
		return array;
	}

	public void setArray(ArrayList<Ingrediente> array) {
		this.array = array;
	}
}
