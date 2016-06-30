package controle;

import java.util.ArrayList;
import java.util.List;

import dao.LancheDao;
import entidade.Lanche;

public class BLLLanche {
	public int salvar(Lanche entidade) {
		return new LancheDao().salvar(entidade);
	}
 
	public boolean excluir(Lanche entidade) {
		return new LancheDao().excluir(entidade);
	}

	public ArrayList<Lanche> listar() {
		return new LancheDao().listar();
	}

	public Lanche buscarPorCodigo(int codigo) {
		return new LancheDao().buscarPorCodigo(codigo);
	}
	
	public ArrayList<Lanche> buscarPorPromocao(int codigo){
		return new LancheDao().buscarPorPromocao(codigo);
	}
}
