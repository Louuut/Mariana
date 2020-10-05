package br.mariana.basquete.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.mariana.basquete.Jogo;
import br.mariana.basquete.Operacao;

public class OperacaoTest {
	Operacao operacao = new Operacao();
	
	@Test
	public void permiteCadastrarJogo() {
		Jogo jogo = new Jogo(); 
		jogo.setJogo(1);
		jogo.setPlacar(20);
		
		operacao.cadastrarJogo(jogo, 1);
			
	}
	
	@Test
	public void erroJogoJaExistente() {
		Jogo jogo = new Jogo(); 
		jogo.setJogo(2);
		jogo.setPlacar(20);
		
		operacao.cadastrarJogo(jogo, 2);
		operacao.cadastrarJogo(jogo, 2);
	}
	
	@Test
	public void excluirJogo() {
		operacao.excluirJogo(1);
		
	}

	@Test
	public void consultarDados() {
		operacao.visualizarJogo();
	}
}
