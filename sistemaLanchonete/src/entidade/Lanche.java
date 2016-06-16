package entidade;

public class Lanche {
	private int cod_lanche;
	private int cod_promocao;
	private String nom_lanche;
	private double val_lanche;

	public int getCod_lanche() {
		return cod_lanche;
	}

	public void setCod_lanche(int cod_lanche) {
		this.cod_lanche = cod_lanche;
	}

	public int getCod_promocao() {
		return cod_promocao;
	}

	public void setCod_promocao(int cod_promocao) {
		this.cod_promocao = cod_promocao;
	}

	public String getNom_lanche() {
		return nom_lanche;
	}

	public void setNom_lanche(String nom_lanche) {
		this.nom_lanche = nom_lanche;
	}

	public double getVal_lanche() {
		return val_lanche;
	}

	public void setVal_lanche(double val_lanche) {
		this.val_lanche = val_lanche;
	}
}
