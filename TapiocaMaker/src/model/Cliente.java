package model;
import java.util.ArrayList;

import model.factoryMethod.Tapioca;

public class Cliente {
    private String email;
    private String nome;
    private ArrayList<Tapioca> carrinho = new ArrayList<>();
    
    public void AdicionarAoCarrinho(Tapioca tapioca){
    	    carrinho.add(tapioca);
    }
	public ArrayList<Tapioca> getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(ArrayList<Tapioca> carrinho) {
		this.carrinho = carrinho;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
