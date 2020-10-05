package br.mariana.basquete;
import java.util.Scanner;

public class Menu {

	private boolean retorna,cadastro;
	private int opcaoMenu;
	Operacao operacao = new Operacao();
	
	public Menu() {
		this.retorna = true;
		this.opcaoMenu = 0;
	
	}
	
	/**
	 * Método responsável por abrir o menu e direcionar para os outros métodos
	 * @returns Não há retorno
	 */
	public void abrirMenu() {		
		while (retorna == true) {
			System.out.println( "------------------------------------------------------------\n" +
								"		Selecione uma opcao abaixo.\r\n" + 
								" 		1 - Inserir Novo Jogo\r\n" + 
								"		2 - Excluir um jogo\r\n" +		
								" 		3 - Consutar Dados\r\n"	+
								" 		4 - Sair do sistema\r\n" +
								"------------------------------------------------------------\n");
			Scanner teclado = new Scanner(System.in);
			opcaoMenu = teclado.nextInt();
			Jogo jogo = new Jogo();
			switch (opcaoMenu) {
			case 1: // Inserir Jogo
				do {
					System.out.println("Numero do jogo: ");
					jogo.setJogo(Integer.valueOf(teclado.next()));
					System.out.println("Digite o placar: ");
					jogo.setPlacar(Integer.valueOf(teclado.next()));
					operacao.cadastrarJogo(jogo,jogo.getJogo());
					if (jogo.getPlacar() < 0 || jogo.getPlacar() > 1000 ) {
						System.out.println("Opção de numero de plarcar invalida!/n Voltando para o Cadastro");
						this.cadastro = false;
					} 
					else if (operacao.isJogoExistente()) {
						this.cadastro = false;
						System.out.println("Voltando para Cadastramento!\n");
					}
					else {
						this.cadastro = true;
					}
					
				}while(!this.cadastro);
				break;
			case 2: // Excluir Jogo
				do {
					System.out.println("Informe o numero do jogo para excluir:");
					operacao.excluirJogo(Integer.valueOf(teclado.next()));
				}while(!operacao.isJogoExistente());
				break;
			case 3: // Consutar toda a tabela de jogo
				operacao.visualizarJogo();
				break;
			case 4: // Sair do programa
				this.retorna = false;
				teclado.close();
				break;
			default:
				System.out.println("Opcao invalida, voltando para o menu!");
				break;
			}		
		}
	}
}
