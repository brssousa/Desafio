package br.com.sonner.desafio.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class NotaFiscal {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Long numero;

	private String fornecedor;


	@JsonSerialize (using = DateSerializer.class)
	private Date data;


	@OneToMany(mappedBy="nota", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Itens> itens = new ArrayList<>();




	public NotaFiscal(){

	}


	public NotaFiscal(long id, String fornecedor, Long numero, Date data) {
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Itens> getItens() {
		return itens;
	}

	public void setItens(List<Itens> itens) {
		this.itens = itens;
	}

}
