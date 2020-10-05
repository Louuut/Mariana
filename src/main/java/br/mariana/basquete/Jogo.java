package br.mariana.basquete;

public class Jogo {

	private Integer jogo;
	private boolean jogoativo;
	private Integer Pmax;
	private Integer Pmin;
	private Integer Qmax;
	private Integer Qmin;
	private Integer placar;
	
	public Jogo() {
		this.Qmax = 0;
		this.Qmin = 0;
	}
	public Integer getJogo() {
		return jogo;
	}
	public void setJogo(Integer jogo) {
		this.jogo = jogo;
	}
	public boolean isJogoativo() {
		return jogoativo;
	}
	public void setJogoativo(boolean jogoativo) {
		this.jogoativo = jogoativo;
	}
	public Integer getPmax() {
		return Pmax;
	}
	public void setPmax(Integer pmax) {
		Pmax = pmax;
	}
	public Integer getPmin() {
		return Pmin;
	}
	public void setPmin(Integer pmin) {
		Pmin = pmin;
	}
	public Integer getQmax() {
		return Qmax;
	}
	public void setQmax(Integer qmax) {
		Qmax = qmax;
	}
	public Integer getQmin() {
		return Qmin;
	}
	public void setQmin(Integer qmin) {
		Qmin = qmin;
	}
	public Integer getPlacar() {
		return placar;
	}
	public void setPlacar(Integer placar) {
		this.placar = placar;
	}
	
}