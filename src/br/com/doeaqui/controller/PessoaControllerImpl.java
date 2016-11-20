package br.com.doeaqui.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Controller;

import br.com.doeaqui.dao.IPessoaDAO;
import br.com.doeaqui.dao.PessoaDAOImpl;
import br.com.doeaqui.exception.DoeaquiException;
import br.com.doeaqui.model.Pessoa;
import br.com.doeaqui.service.IPessoaService;
import br.com.doeaqui.service.PessoaServiceImpl;

@ManagedBean(name = "pessoaController")
@Controller
public class PessoaControllerImpl {

	IPessoaService pessoaService;

	public PessoaControllerImpl() {
		IPessoaDAO repositorioPessoa = new PessoaDAOImpl();
		pessoaService = new PessoaServiceImpl(repositorioPessoa);
	}

	public void addPessoa(Pessoa p) throws DoeaquiException {
		pessoaService.addPessoa(p);
	}

	public void updatePessoa(Pessoa p) {
		pessoaService.updatePessoa(p);
	}

	public void removePessoa(String cnpj) throws DoeaquiException {
		pessoaService.removePessoa(cnpj);
	}

	public Pessoa findPessoa(String cnpj) throws DoeaquiException {
		return pessoaService.findPessoa(cnpj);
	}

	public List<Pessoa> listPessoa() {
		return pessoaService.listPessoa();

	}
	
}
