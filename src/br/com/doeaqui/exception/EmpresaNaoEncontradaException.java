package br.com.doeaqui.exception;

public class EmpresaNaoEncontradaException extends Exception {

	private static final long serialVersionUID = 2543734278014847458L;

	public EmpresaNaoEncontradaException() {

		super("Empresa não encontrada!");

	}

	public EmpresaNaoEncontradaException(String msg) {

		super(msg);

	}

}
