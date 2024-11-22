package br.com.nicollas.cm;

import br.com.nicollas.cm.modelo.Tabuleiro;
import br.com.nicollas.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {

		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);
		new TabuleiroConsole(tabuleiro);

	}
}
