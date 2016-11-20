package br.com.doeaqui.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import br.com.doeaqui.util.DataUtil;

@Entity
@Table
@SessionScoped
@ManagedBean(name = "doacao")
public class Doacao implements Serializable {

	private static final long serialVersionUID = -4088798507412356886L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;

	@NotNull
	@Column(length = 100)
	private String titulo;

	@NotNull
	@Column(length = 1000)
	private String descricao;

	@NotNull
	@Column
	private String categoria;

	@NotNull
	@Column
	private boolean disponibilidade;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_empresa")
	@NotNull
	private Empresa empresaDoadora;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ong")
	private ONG ongBeneficiaria;

	@NotNull
	@Column
	@Temporal(value = TemporalType.DATE)
	private Calendar dtDoacao;

	@Transient
	private String cnpj;

	@Transient
	private String password;
	
	@Transient
	private String cnpjOng;
	@Transient
	private String passwordOng;

	public Doacao() {
		this.dtDoacao = Calendar.getInstance();
		this.disponibilidade = true;

	}

	public String getCnpj() {

		return cnpj;

	}

	public void setCnpj(String cnpj) {

		this.cnpj = cnpj;

	}

	public Calendar getDtDoacao() {

		return dtDoacao;

	}

	public String getData() {

		return DataUtil.dataToString(this.dtDoacao);

	}

	public void setDtDoacao() {

		this.dtDoacao = Calendar.getInstance();

	}

	public String getTitulo() {

		return titulo;

	}

	public void setTitulo(String titulo) {

		this.titulo = titulo;

	}

	public String getDescricao() {

		return descricao;

	}

	public void setDescricao(String descricao) {

		this.descricao = descricao;

	}

	public String getCategoria() {

		return categoria;

	}

	public void setCategoria(String categoria) {

		this.categoria = categoria;

	}

	public Empresa getEmpresaDoadora() {

		return empresaDoadora;

	}

	public void setEmpresaDoadora(Empresa empresaDoadora) {

		this.empresaDoadora = empresaDoadora;

	}

	public ONG getOngBeneficiaria() {

		return ongBeneficiaria;

	}

	public void setOngBeneficiaria(ONG ongBeneficiaria) {

		this.ongBeneficiaria = ongBeneficiaria;

	}

	public boolean getDisponibilidade() {

		return disponibilidade;

	}

	public boolean isDisponibilidade() {

		return disponibilidade;

	}

	public void setDisponibilidade(boolean disponibilidade) {

		this.disponibilidade = disponibilidade;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public int getId() {

		return id;

	}

	public String getCnpjOng() {
		return cnpjOng;
	}

	public void setCnpjOng(String cnpjOng) {
		this.cnpjOng = cnpjOng;
	}

	public String getPasswordOng() {
		return passwordOng;
	}

	public void setPasswordOng(String passwordOng) {
		this.passwordOng = passwordOng;
	}

}