package br.com.doeaqui.dao;

import java.util.List;

import br.com.doeaqui.model.Pessoa;

public interface IPessoaDAO {

	public void addPessoa(Pessoa p);

	public void updatePessoa(Pessoa p);

	public void removePessoa(String cnpj);

	public Pessoa findPessoa(String cnpj);

	public List<Pessoa> listPessoa();
}
