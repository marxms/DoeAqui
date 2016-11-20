package br.com.doeaqui.service;

import java.util.List;

import br.com.doeaqui.exception.DoeaquiException;
import br.com.doeaqui.model.Pessoa;

public interface IPessoaService {

	public void addPessoa(Pessoa p) throws DoeaquiException;

	public void updatePessoa(Pessoa p);

	public void removePessoa(String cnpj) throws DoeaquiException;

	public Pessoa findPessoa(String cnpj) throws DoeaquiException;

	public List<Pessoa> listPessoa();
	
}
