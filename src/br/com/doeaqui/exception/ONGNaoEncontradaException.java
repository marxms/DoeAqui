package br.com.doeaqui.exception;

public class ONGNaoEncontradaException extends Exception {

	public ONGNaoEncontradaException() {

		super("ONG não encontrada!");

	}

	public ONGNaoEncontradaException(String msg) {

		super(msg);

	}

}
