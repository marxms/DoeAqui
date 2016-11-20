package br.com.doeaqui.exception;

public class DoacaoNaoEncontradaException extends Exception {

	private static final long serialVersionUID = -5925796946899593198L;

	public DoacaoNaoEncontradaException() {

		super("Doação não encontrada!");

	}

	public DoacaoNaoEncontradaException(String msg) {

		super(msg);

	}

}
