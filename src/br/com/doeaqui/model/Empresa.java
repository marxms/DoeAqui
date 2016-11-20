package br.com.doeaqui.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
@Table
@ManagedBean(name = "empresa")
public class Empresa extends Pessoa {

	@Column
	@NotNull
	private String razaoSocial;
	
	@OneToMany(mappedBy = "empresaDoadora")
	private List<Doacao> listaDoacao;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public List<Doacao> getListaDoacao() {
		return listaDoacao;
	}

	public void setListaDoacao(List<Doacao> listaDoacao) {
		this.listaDoacao = listaDoacao;
	}
}
