package br.com.doeaqui.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.doeaqui.dao.IDoacaoDAO;
import br.com.doeaqui.dao.PessoaDAOImpl;
import br.com.doeaqui.exception.EmpresaAutenticacaoException;
import br.com.doeaqui.exception.EmpresaNaoEncontradaException;
import br.com.doeaqui.exception.ONGAutenticacaoException;
import br.com.doeaqui.exception.ONGNaoEncontradaException;
import br.com.doeaqui.model.Doacao;
import br.com.doeaqui.model.Empresa;
import br.com.doeaqui.model.ONG;

@ManagedBean(name = "doacaoService")
@SessionScoped
@Service
public class DoacaoServiceImpl implements IDoacaoService {

	private IDoacaoDAO respositorioDoacao;
	private PessoaDAOImpl daoPessoa;

	public DoacaoServiceImpl(IDoacaoDAO respositorioDoacao) {

		this.respositorioDoacao = respositorioDoacao;
		this.daoPessoa = new PessoaDAOImpl();

	}

	@Override
	@Transactional
	public void addDoacao(Doacao doacao) throws EmpresaNaoEncontradaException, EmpresaAutenticacaoException {

		String cnpj = doacao.getCnpj();
		String password = doacao.getPassword();

		Empresa empresa = (Empresa) daoPessoa.findPessoa(cnpj);

		if (empresa == null) {

			throw new EmpresaNaoEncontradaException();

		} else if (!empresa.getPassword().equals(password)) {

			throw new EmpresaAutenticacaoException();

		} else {

			doacao.setEmpresaDoadora(empresa);

			respositorioDoacao.addDoacao(doacao);

		}

	}

	@Override
	@Transactional
	public List<Doacao> listDoacao() {

		return respositorioDoacao.listDoacao();

	}

	@Override
	@Transactional
	public void mudarStatusDisponibilidade(Doacao doacao) {

		// TODO - Ver a forma de chamada do método antes de implementar.

	}

	@Override
	@Transactional
	public List<Doacao> listDoacaoByCategoria(String categoria) {

		return respositorioDoacao.listByCategoria(categoria);

	}

	@Override
	public void reservarDoacao(String cnpj, String senha, Doacao doacao)
			throws ONGNaoEncontradaException, ONGAutenticacaoException {

		ONG ongReceb = (ONG) daoPessoa.findPessoa(cnpj);

		if (ongReceb == null) {

			throw new ONGNaoEncontradaException();

		} else if (!ongReceb.getPassword().equals(senha)) {

			throw new ONGAutenticacaoException("Problema na autenticação");

		} else {

				doacao.setDisponibilidade(false);
				doacao.setOngBeneficiaria(ongReceb);

			respositorioDoacao.updateDoacao(doacao);

		}

	}

	public Empresa autenticarEmpresa(String cnpj, String password) {

		Empresa empresa = (Empresa) daoPessoa.findPessoa(cnpj);

		if (empresa != null) {

			if (empresa.getPassword().equals(password)) {

				return empresa;

			}

		}

		return null;

	}

	public ONG autenticarONG(String password, String cnpj) {

		ONG ong = (ONG) daoPessoa.findPessoa(cnpj);
		
		if (ong != null) {

			if (ong.getPassword().equals(password)) {

				return ong;

			}

		}

		return null;

	}
}
