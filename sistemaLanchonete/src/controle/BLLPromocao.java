package controle;

import java.util.List;

import dao.PromocaoDao;
import entidade.Promocao;

public class BLLPromocao {

	public int salvar(Promocao entidade) {
		return new PromocaoDao().salvar(entidade);
	}
 
	public boolean excluir(Promocao entidade) {
		return new PromocaoDao().excluir(entidade);
	}

	public List<Promocao> listar() {
		return new PromocaoDao().listar();
	}

	public Promocao buscarPorCodigo(int codigo) {
		return new PromocaoDao().buscarPorCodigo(codigo);
	}
}
