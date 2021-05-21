package model;

import java.text.SimpleDateFormat;

import view.state.EstadoDoPedido;

public class Pedido {
	private Cliente cliente;
    private EstadoDoPedido estado;
    private String endereco;

    private long id = System.currentTimeMillis();
    
    public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
    public void setEstadoDoPedido(EstadoDoPedido estado){
    	this.estado = estado;
    	this.estado.statusPedido();
    }
    public String getStatus(){
    	return estado.getStatus();
    }
    public String dataInicial(){
    	return estado.getDataInicial();
    }
    public String situacaoDataStatus(){
    	return estado.situacaoDataStatus();
    }
	public void adicionarCliente(Cliente cliente) {
		this.cliente = cliente;
	}

    public long getId() {
		return id;
	}
	public String toString(){
    	return cliente.getEmail()+" - "+endereco;
    }
	public Cliente getCliente() {
		return cliente;
	}
}
