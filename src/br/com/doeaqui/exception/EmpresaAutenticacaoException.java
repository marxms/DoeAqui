package br.com.doeaqui.exception;

public class EmpresaAutenticacaoException extends Exception {

	private static final long serialVersionUID = -1500111882913028227L;

	public EmpresaAutenticacaoException() {

		super("Empresa não autenticada!");

	}

	public EmpresaAutenticacaoException(String msg) {

		super(msg);

	}

}
