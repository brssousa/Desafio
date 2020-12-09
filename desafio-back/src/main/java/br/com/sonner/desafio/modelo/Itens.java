package br.com.sonner.desafio.modelo;

import javax.persistence.*;

@Entity
public class Itens {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private NotaFiscal nota;

	private String item;

	private float valor;





	public Itens(){

	}

	public Itens(long id, String item, Float valor) {
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

	public NotaFiscal getNota() {
		return nota;
	}

	public void setNota(NotaFiscal nota) {
		this.nota = nota;
	}
}
