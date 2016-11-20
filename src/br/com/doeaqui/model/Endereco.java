package br.com.doeaqui.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
@ManagedBean
public class Endereco {
	@Id
	@GeneratedValue
	private int id;
	@Column(length = 2)
	@NotNull
	private String uf;
	@Column(length = 9)
	@NotNull
	private String cep;
	@Column
	@NotNull
	private String cidade;
	@Column
	@NotNull
	private String bairro;
	@Column
	@NotNull
	private String municipio;
	@Column
	@NotNull
	private String logradouro;

	@NotNull
	@Column
	private long numero;

	@OneToMany(mappedBy = "endereco")
	private List<Pessoa> listaPessoas;

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public int getId() {
		return id;
	}
}
