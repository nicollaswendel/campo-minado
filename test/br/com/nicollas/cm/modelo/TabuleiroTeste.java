package br.com.nicollas.cm.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TabuleiroTeste {

	private Tabuleiro tabuleiro;
	
	@BeforeEach
	void inciarTabuleiro() {
		tabuleiro = new Tabuleiro(6, 6, 3);
	}

	@Test
	void testeAbrirCoordenada() {
		tabuleiro.abrir(5, 3);
	}
	
	@Test
	void testeAlternarMarcacao() {
		tabuleiro.alternarMarcacao(4, 2);
	}
	
	@Test
	void testeFimDeJogoGanho() {
		tabuleiro.objetivoAlcancado();
		tabuleiro.reiniciar();
	}
	
	@Test
	void testeImpressaoDasInformacoes() {
		tabuleiro.toString();
	}
	
}
