package br.com.doeaqui.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import br.com.doeaqui.dao.DoacaoDAOImpl;
import br.com.doeaqui.dao.IDoacaoDAO;
import br.com.doeaqui.exception.EmpresaAutenticacaoException;
import br.com.doeaqui.exception.EmpresaNaoEncontradaException;
import br.com.doeaqui.exception.ONGAutenticacaoException;
import br.com.doeaqui.exception.ONGNaoEncontradaException;
import br.com.doeaqui.model.Doacao;
import br.com.doeaqui.service.DoacaoServiceImpl;
import br.com.doeaqui.service.IDoacaoService;

@ManagedBean(name = "doacaoController")
@Controller
@SessionScoped
public class DoacaoController {

	private IDoacaoService doacaoService;
	private Doacao doacaoSelecionada;
	
	public DoacaoController() {

		IDoacaoDAO dao = new DoacaoDAOImpl();
		doacaoService = new DoacaoServiceImpl(dao);

	}
	@Transactional
	public void addDoacao(Doacao doacao) {

		try {
			doacaoService.addDoacao(doacao);

		} catch (EmpresaNaoEncontradaException e) {

			// TODO - tratar na view
			e.printStackTrace();

		} // TODO - exception do password
		catch (EmpresaAutenticacaoException e) {

			// TODO - tratar na view
			e.printStackTrace();

		}
	}

	@Transactional
	public List<Doacao> listDoacao() {

		return doacaoService.listDoacao();

	}

	public void reservarDoacao(Doacao doacao)
			throws ONGNaoEncontradaException, ONGAutenticacaoException {
		doacaoService.reservarDoacao(doacao.getCnpjOng(), doacao.getPasswordOng(), doacao);
	}

	public Doacao getDoacaoSelecionada() {
		return doacaoSelecionada;
	}

	public void setDoacao(Doacao doacaoSelecionada) {
		this.doacaoSelecionada = doacaoSelecionada;
	}
	
	
}
