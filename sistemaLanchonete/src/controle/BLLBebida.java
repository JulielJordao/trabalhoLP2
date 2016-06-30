package controle;

import java.util.ArrayList;

import dao.BebidasDao;
import entidade.Bebida;

public class BLLBebida {
	 
	public int salvar(Bebida entidade) {
		return new BebidasDao().salvar(entidade);
	}

	public boolean excluir(Bebida entidade) {
		return new BebidasDao().excluir(entidade);
	}

	public ArrayList<Bebida> listar() {
		return new BebidasDao().listar();
	}

	public Bebida buscarPorCodigo(int codigo) {
		return new BebidasDao().buscarPorCodigo(codigo);
	}
	
	public ArrayList<Bebida> buscarPorPromocao(int codigo){
		return new BebidasDao().buscarPorPromocao(codigo);
	}
}
