package br.com.sonner.desafio.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PrimitiveIterator;

@Entity
public class NotaFiscal {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Long numero;

	private String estado;

	private String cidades;

	@OneToOne
	private Fornecedor fornecedor;


	@JsonSerialize (using = DateSerializer.class)
	private Date data;


	@OneToMany(mappedBy="nota", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Itens> itens = new ArrayList<>();




	public NotaFiscal(){

	}


	public NotaFiscal(long id, Fornecedor fornecedor, Long numero, Date data, String estado, String cidades) {
		this.id = id;
		this.numero = numero;
		this.fornecedor = fornecedor;
		this.data = data;
		this.estado = estado;
		this.cidades = cidades;

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

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
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
		itens.forEach( i -> {
			if(i!=null && i.getNota()==null){
				i.setNota(this);
			}
		});
		this.itens = itens;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidades() {
		return cidades;
	}

	public void setCidades(String cidades) {
		this.cidades = cidades;
	}
}
