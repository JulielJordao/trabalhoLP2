package controle;

import java.util.ArrayList;

import dao.AcompanhamentoDao;
import entidade.Acompanhamento;

public class BLLAcompanhamento {
 
	public int salvar(Acompanhamento entidade) {
		return new AcompanhamentoDao().salvar(entidade);
	}

	public boolean excluir(Acompanhamento entidade) {
		return new AcompanhamentoDao().excluir(entidade);
	}

	public ArrayList<Acompanhamento> listar() {
		return new AcompanhamentoDao().listar();
	}

	public Acompanhamento buscarPorCodigo(int codigo) {
		return new AcompanhamentoDao().buscarPorCodigo(codigo);
	}
	
	public ArrayList<Acompanhamento> buscarPorPromocao(int codigo){
		return new AcompanhamentoDao().buscarPorPromocao(codigo);
	}
}
