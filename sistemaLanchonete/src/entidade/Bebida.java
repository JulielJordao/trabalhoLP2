package entidade;

public class Bebida {

	private int cod_bebida;
	private int cod_promocao;
	private String nom_bebida;
	private double val_bebida;
	private int tempo_espera;
	
	public int getCod_bebida() {
		return cod_bebida;
	}

	public void setCod_bebida(int cod_bebida) {
		this.cod_bebida = cod_bebida;
	}

	public int getCod_promocao() {
		return cod_promocao;
	}

	public void setCod_promocao(int cod_promocao) {
		this.cod_promocao = cod_promocao;
	}

	public String getNom_bebida() {
		return nom_bebida;
	}

	public void setNom_bebida(String nom_bebida) {
		this.nom_bebida = nom_bebida;
	}

	public double getVal_bebida() {
		return val_bebida;
	}

	public void setVal_bebida(double val_bebida) {
		this.val_bebida = val_bebida;
	}

	public int getTempo_espera() {
		return tempo_espera;
	}

	public void setTempo_espera(int tempo_espera) {
		this.tempo_espera = tempo_espera;
	}
}
