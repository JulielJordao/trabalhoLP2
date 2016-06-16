package entidade;

public class Pedido {
	private int cod_pedido;
	private double val_pedido;
	private String dat_pedido;
	private int cod_desconto;
	
	public void setCod_pedido(int cod_pedido){
		this.cod_pedido = cod_pedido; 
	}
	public int getCod_pedido(){
		return cod_pedido;
	}
	
	public void setVal_pedido(double val_pedido){
		this.val_pedido = val_pedido;
	}
	public double getVal_pedido(){
		return val_pedido;
	}
	
	public void setDat_pedido(String dat_pedido){
		this.dat_pedido = dat_pedido;
	}
	public String getDat_pedido(){
		return dat_pedido;
	}
	public int getCod_desconto() {
		return cod_desconto;
	}
	public void setCod_desconto(int cod_desconto) {
		this.cod_desconto = cod_desconto;
	}
	
}
