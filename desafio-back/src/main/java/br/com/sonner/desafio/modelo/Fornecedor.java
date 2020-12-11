package br.com.sonner.desafio.modelo;

import org.aspectj.weaver.ast.Not;

import javax.persistence.*;

@Entity
public class Fornecedor {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fornecedor;

	public Fornecedor(){

	}
	public Fornecedor(long id, String fornecedor) {
		this.id = id;
		this.fornecedor = fornecedor;
	}

	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String descricao) {
		this.fornecedor = descricao;
	}

	

}
