package br.com.doeaqui.exception;

public class ONGAutenticacaoException extends Exception {
	public ONGAutenticacaoException() {

		super("ONG não encontrada!");

	}

	public ONGAutenticacaoException(String msg) {

		super(msg);

	}
}
