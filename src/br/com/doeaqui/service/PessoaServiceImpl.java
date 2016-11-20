package br.com.doeaqui.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.doeaqui.dao.IPessoaDAO;
import br.com.doeaqui.exception.DoeaquiException;
import br.com.doeaqui.model.Empresa;
import br.com.doeaqui.model.ONG;
import br.com.doeaqui.model.Pessoa;

@ManagedBean(name = "pessoaService")
@SessionScoped
@Service
public class PessoaServiceImpl implements IPessoaService {

	private IPessoaDAO repositorioPessoa;

	public PessoaServiceImpl(IPessoaDAO repositorioPessoa) {
		this.repositorioPessoa = repositorioPessoa;
	}

	// public void setRepositorioPessoa(IPessoaDAO repositorioPessoa) {
	// this.repositorioPessoa = repositorioPessoa;
	// }

	@Override
	@Transactional
	public void addPessoa(Pessoa p) throws DoeaquiException {

		// validar(p);
		repositorioPessoa.addPessoa(p);

	}

	@Override
	@Transactional
	public void updatePessoa(Pessoa p) {

		repositorioPessoa.updatePessoa(p);

	}

	@Override
	@Transactional
	public void removePessoa(String cnpj) throws DoeaquiException {

		if (cnpj == null || cnpj == " ") {

			throw new DoeaquiException("CNPJ inválido!");

		} else {

			repositorioPessoa.removePessoa(cnpj);

		}

	}

	@Override
	@Transactional
	public Pessoa findPessoa(String cnpj) throws DoeaquiException {

		if (cnpj == null || cnpj == " ") {

			throw new DoeaquiException("CNPJ inválido!");

		} else {

			return repositorioPessoa.findPessoa(cnpj);

		}

	}

	@Override
	@Transactional
	public List<Pessoa> listPessoa() {
		return repositorioPessoa.listPessoa();
	}

	protected void validar(Pessoa p) throws DoeaquiException {
		if (p == null) {
			throw new DoeaquiException("Usuário inválido!");
		} else if (p.getCnpj() == " " || p.getCnpj() == null) {
			throw new DoeaquiException("Cnpj é inválido!");
		} else if (p.getEndereco() == null) {
			throw new DoeaquiException("Informe o endereço!");
		} else if (p.getEmail() == null || p.getEmail() == " ") {
			throw new DoeaquiException("Email inválido!");
		} else if (p instanceof Empresa) {
			if (((Empresa) p).getRazaoSocial() == null || ((Empresa) p).getRazaoSocial() == " ") {
				throw new DoeaquiException("Razão social inválida!");
			}
		} else if (p instanceof ONG) {
			if (((ONG) p).getTipoOng() == null || ((ONG) p).getTipoOng() == " ") {
				throw new DoeaquiException("Ong de tipo inválida!");
			}
		}
	}

}
