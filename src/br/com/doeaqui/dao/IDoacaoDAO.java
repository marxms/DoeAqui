package br.com.doeaqui.dao;

import java.util.List;

import br.com.doeaqui.exception.DoacaoNaoEncontradaException;
import br.com.doeaqui.model.Doacao;

public interface IDoacaoDAO {

	public void addDoacao(Doacao d);

	public void updateDoacao(Doacao d);

	public Doacao findById(int id) throws DoacaoNaoEncontradaException;

	public List<Doacao> listByCategoria(String categoria);

	public List<Doacao> listDoacao();

}
