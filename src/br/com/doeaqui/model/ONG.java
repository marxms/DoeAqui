package br.com.doeaqui.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
@Table
@ManagedBean(name = "ong")
public class ONG extends Pessoa {

	@Column(name = "Tipo")
	@NotNull
	private String tipoOng;
	
	@OneToMany(mappedBy="ongBeneficiaria")
	private List<Doacao> listaDoacao;
	

	public String getTipoOng() {
		return tipoOng;
	}

	public void setTipoOng(String tipoOng) {
		this.tipoOng = tipoOng;
	}

	public List<Doacao> getListaDoacao() {
		return listaDoacao;
	}

	public void setListaDoacao(List<Doacao> listaDoacao) {
		this.listaDoacao = listaDoacao;
	}
}
