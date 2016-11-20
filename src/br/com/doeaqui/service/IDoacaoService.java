package br.com.doeaqui.service;

import java.util.List;

import br.com.doeaqui.exception.EmpresaAutenticacaoException;
import br.com.doeaqui.exception.EmpresaNaoEncontradaException;
import br.com.doeaqui.exception.ONGAutenticacaoException;
import br.com.doeaqui.exception.ONGNaoEncontradaException;
import br.com.doeaqui.model.Doacao;

public interface IDoacaoService {

	public void addDoacao(Doacao doacao) throws EmpresaNaoEncontradaException, EmpresaAutenticacaoException;

	public List<Doacao> listDoacao();

	public void mudarStatusDisponibilidade(Doacao doacao);

	public List<Doacao> listDoacaoByCategoria(String categoria);

	public void reservarDoacao(String cnpj, String senha, Doacao doacao) throws ONGNaoEncontradaException, ONGAutenticacaoException;
	

}
