package br.com.nicollas.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.nicollas.cm.excecao.ExplosaoException;

public class CampoTeste {

	private Campo campo;

	@BeforeEach
	void inciarCampo() {
		campo = new Campo(3, 3);
	}

	@Test
	void testeVizinhoDistancia1Esquerda() {
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDistancia1Direita() {
		Campo vizinho = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDistancia1EmCima() {
		Campo vizinho = new Campo(2, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDistancia1Embaixo() {
		Campo vizinho = new Campo(4, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistancia2() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo(1, 1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}
	
	@Test
	void testeAbrirComVizinhos1() {		
		Campo campo11 = new Campo(1, 1);
		Campo campo22 = new Campo(2, 2);
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	
	@Test
	void testeAbrirComVizinhos2() {		
		Campo campo11 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 2);
		campo12.minar();
		
		Campo campo22 = new Campo(2, 2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}
	
	@Test
	void testePegarCoordenada() {
		Campo campo23 = new Campo (2, 3);
		campo23.getLinha();
		campo23.getColuna();
	}
	
	@Test
	void testeDesvendado() {
		campo.abrir();
		campo.objetivoAlcancado();
	}
	
	@Test
	void testeProtegido() {
		campo.minar();
		campo.alternarMarcacao();
		campo.objetivoAlcancado();
	}
	
	@Test
	void testeMinasNaVizinhanca() {
		Campo campo32 = new Campo(3, 2);
		Campo campo34 = new Campo(3, 4);
		campo32.minar();
		campo34.minar();
		
		campo.adicionarVizinho(campo32);
		campo.adicionarVizinho(campo34);

		campo.abrir();
		campo.minasNaVizinhanca();
	}
	
	@Test
	void testeFimDeJogo() {
		Campo campo32 = new Campo(3, 2);
		campo32.minar();
		
		Campo campo34 = new Campo(3, 4);
		campo34.minar();
		campo34.alternarMarcacao();
		
		campo.abrir();
		
		assertThrows(ExplosaoException.class, () -> {
			campo32.abrir();
		});
		
		campo32.reiniciar();
		campo34.reiniciar();
		campo.reiniciar();
		
		assertFalse(campo.isFechado() && campo32.isMinado() && campo34.isMarcado());
	}
	
	@Test
	void testeMarcacao() {
		campo.minar();
		campo.alternarMarcacao();
		campo.toString();
	}
	
	@Test
	void testeAbertoEMinado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
		
		campo.toString();
	}
	
	@Test
	void testeAbertoEMinasNaVizinhanca() {
		Campo campo32 = new Campo(3, 2);
		campo32.minar();
		
		Campo campo34 = new Campo(3, 4);
		campo34.minar();
		
		campo.adicionarVizinho(campo32);
		campo.adicionarVizinho(campo34);
		
		campo.abrir();
		campo.toString();
	}
	
	@Test
	void testeAberto() {
		campo.abrir();
		campo.toString();
	}
	
	@Test
	void testeFechado() {
		campo.toString();
	}
}
