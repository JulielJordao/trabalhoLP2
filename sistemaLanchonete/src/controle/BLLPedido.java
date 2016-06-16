package controle;

import java.util.List;

import dao.PedidoDao;
import entidade.Pedido;

public class BLLPedido implements IBLLCrud<Pedido> {

	public int salvar(Pedido entidade) {
		return new PedidoDao().salvar(entidade);
	}

	public boolean excluir(Pedido entidade) {
		return new PedidoDao().excluir(entidade);
	}

	public List<Pedido> listar() {
		return new PedidoDao().listar();
	}

	public Pedido buscarPorCodigo(int codigo) {
		return new PedidoDao().buscarPorCodigo(codigo);
	}
}
