package controle;

import java.util.ArrayList;

import dao.CadastroCompraDao;
import entidade.CadastroCompra;

public class BLLCadastroCompra  implements IBLLCrud<CadastroCompra>{
 
	public int salvar(CadastroCompra entidade) {
		return new CadastroCompraDao().salvar(entidade);
	}

	public boolean excluir(CadastroCompra entidade) {
		return new CadastroCompraDao().excluir(entidade);
	}

	public ArrayList<CadastroCompra> listar() {
		return (ArrayList<CadastroCompra>) new CadastroCompraDao().listar();
	}

	}