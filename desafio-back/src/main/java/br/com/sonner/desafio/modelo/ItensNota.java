package br.com.sonner.desafio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ItensNota {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String item;
	private float valor;

	public ItensNota(){

	}

	public ItensNota(long id, String item, Float valor) {
		this.id = id;
		this.item = item;
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
