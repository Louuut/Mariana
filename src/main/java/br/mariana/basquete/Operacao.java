package br.mariana.basquete;

import java.util.ArrayList;
import java.util.List;


public class Operacao implements Info{
	private boolean jogoExistente;
	private int cont;
	public Operacao() {
		this.jogoExistente = false;
		this.cont = 0;		
	}
	public boolean isJogoExistente() {
		return jogoExistente;
	}
	
	List<Jogo> lista  = new ArrayList<Jogo>();
	
	/**
	 * M�todo respons�vel por permitir o cadastro de um jogo
	 * @param jogo Recebe um jogo a ser cadastrado 
	 * @param  numero Recebe um n�mero de jogo
	 * @returns N�o h� retorno
	 **/
	public void cadastrarJogo(Jogo jogo, Integer numero) {
			for(Jogo jogos : lista) {
				if( jogos.getJogo().equals(numero)){
					System.out.println("Jogo ja existe!");
					this.jogoExistente = true;
					break;
				}else {
					this.jogoExistente = false;
				}
			}
			if(cont == 0 || this.jogoExistente == false) {
				lista.add(jogo);
				maximaTemporada();
				minimaTemporada();
				System.out.println("Jogo Acrecentado!");
				this.cont++;			
			}	
	}
	
	/**
	 * M�todo respons�vel por registrar o m�ximo da temporada
	 * @returns N�o h� retorno
	 */
	public void maximaTemporada() {
		int contMax = 0;
		for(Jogo jogos : lista) {
			if(lista.indexOf(jogos) == 0) {
				jogos.setPmax(lista.get(0).getPlacar());
			} 
			else {
				if(jogos.getPlacar() > lista.get(lista.indexOf(jogos) - 1).getPmax()) {
					jogos.setPmax(jogos.getPlacar());
					contMax++; 
				}else {
					jogos.setPmax(lista.get(lista.indexOf(jogos) - 1).getPmax());
				}
				recordMax(contMax, jogos);
			}
		}
	}
	
	/**
	 * M�todo respons�vel por registrar o m�nimo da temporada
	 * @returns N�o h� retorno
	 */
	public void minimaTemporada() {
		int contMin = 0;
		for(Jogo jogos : lista) {
			if(lista.indexOf(jogos) == 0) {
				jogos.setPmin(lista.get(0).getPlacar());
			} 
			else {
				if(jogos.getPlacar() < lista.get(lista.indexOf(jogos) - 1).getPmin()) {
					jogos.setPmin(jogos.getPlacar());
					contMin++; 					
				}else {
					jogos.setPmin(lista.get(lista.indexOf(jogos) - 1).getPmin());
				}
				recordMin(contMin, jogos);
			}			
		}
	}
	
	/**
	 * M�todo respons�vel por registrar a quantidades de quebra de recorde m�ximo
	 * @param nunMax recebe o n�mero de vezes de quebra m�xima
	 * @param jogo salva o n�mero recebido da quebra de recorde para dentro da lista
	 * @returns N�o h� retorno
	 */
	public void recordMax(Integer nunMax, Jogo jogo) {
		jogo.setQmax(nunMax);
	}
	
	/**
	 * M�todo respons�vel por registrar a quantidades de quebra de recorde m�nimo
	 * @param nunMin recebe o n�mero de vezes de quebra m�nimo
	 * @param jogo salva o n�mero recebido da quebra de recorde para dentro da lista
	 * @returns N�o h� retorno
	 */
	public void recordMin(Integer nunMin, Jogo jogo) {
		jogo.setQmin(nunMin);
	}
	
	/**
	 * M�todo para vizualizar todos os jogos
	 * @returns N�o h� retorno
	 */
	public void visualizarJogo() {
		System.out.println(				
				"Jogo | Placar | Minimo  | Maximo  | Quebra | Quebra\n" +
				"     |        |   da    |   da    | Minimo | Maxima\n" +
				"     |        |Temporada|Temporada|        |       ");
		for (Jogo jogos : lista) {
			System.out.println(	"  " + jogos.getJogo() + "  |   " + jogos.getPlacar()+ "   |   " + jogos.getPmin()+ "  |  " + jogos.getPmax()+ "  |  " + jogos.getQmin()+ "  |  " + jogos.getQmax() + "\n");
		}
	}
	
	
	/**
	 * M�todo respons�vel por excluir um jogo
	 * @param numero Recebe o numero do jogo a ser excluido
	 * @returns N�o h� retorno
	 */
	public void excluirJogo(Integer numero) {
		for(Jogo jogos : lista) {
			if( jogos.getJogo().equals(numero)){
				lista.remove(jogos);
				System.out.println("Jogo excluido!");
				jogoExistente = true;
				this.cont--;
				break;
			}
		}
		if (jogoExistente == false) {
			System.out.println("Jogo n�o encontrado!");
		}		
		
	}
}
