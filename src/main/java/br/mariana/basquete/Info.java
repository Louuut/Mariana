package br.mariana.basquete;

public interface Info {
	void cadastrarJogo(Jogo jogo, Integer numero);
	void maximaTemporada();
	void minimaTemporada();
	void recordMax(Integer nunMax, Jogo jogo);
	void recordMin(Integer nunMin, Jogo jogo);
	void visualizarJogo();
	void excluirJogo(Integer numero);
}
