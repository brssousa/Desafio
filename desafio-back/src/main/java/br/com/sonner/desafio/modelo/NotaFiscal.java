package br.com.sonner.desafio.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NotaFiscal {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Long numero;
	private String fornecedor;
	private Date data;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="itens_notaF",
			joinColumns={@JoinColumn(name="notasF_id")},
			inverseJoinColumns={@JoinColumn(name="itens_id")})
	private Itens itens;


	public NotaFiscal(){

	}

	public NotaFiscal(long id,Long numero, String fornecedor,Date data) {
		this.id = id;
		this.numero = numero;
		this.fornecedor = fornecedor;
		this.data = data;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
