package controle;

import java.util.ArrayList;
import java.util.List;

import dao.ItemPedidoDao;
import entidade.ItemPedido;

public class BLLItemPedido  implements IBLLCrud<ItemPedido>{
 
	public int salvar(ItemPedido entidade) {
		return new ItemPedidoDao().salvar(entidade);
	}

	public boolean excluir(ItemPedido entidade) {
		return new ItemPedidoDao().excluir(entidade);
	}

	public ArrayList<ItemPedido> listar() {
		return (ArrayList<ItemPedido>) new ItemPedidoDao().listar();
	}

	public ItemPedido buscarPorCodigo(int codigo) {
		return new ItemPedidoDao().buscarPorCodigo(codigo);
	}
}
