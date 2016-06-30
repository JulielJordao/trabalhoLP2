package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.Conexao;
import entidade.ItemPedido;

public class ItemPedidoDao implements IDAOCrud<ItemPedido>{

		public int salvar(ItemPedido entidade) {

			Connection conexao = new Conexao().geraConexao();
			PreparedStatement sqlParametro = null;
			ResultSet resultado = null;
			int codigo = 0;
			String sql;
			
			try {
				if(entidade.getCod_itemPedido() == 0){
					sql = "insert into itemPedido(cod_item, tipo, cod_pedido, val_item) values(?, ?, ?, ?);";
					sqlParametro = conexao.prepareStatement(sql);
					sqlParametro.setInt(1, entidade.getCod_item());
					sqlParametro.setString(2, entidade.getTipo());
					sqlParametro.setInt(3, entidade.getCod_pedido());
					sqlParametro.setDouble(4, entidade.getVal_item());
					
					sqlParametro.executeUpdate();
					sql = "select last_insert_id() as Codigo";
					sqlParametro = conexao.prepareStatement(sql);
					resultado = sqlParametro.executeQuery();
					if (resultado.next()) {
						codigo = resultado.getInt("Codigo");
						entidade.setCod_itemPedido(codigo);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					sqlParametro.close();
					conexao.close();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			return codigo;
		}

		public boolean excluir(ItemPedido entidade) {

			Connection conexao = new Conexao().geraConexao();
			PreparedStatement sqlParametro = null;
			String sql;
			boolean teste = false;
			try {
				sql = "delete from itemPedido where cod_itemPedido = ?;";
				sqlParametro = conexao.prepareStatement(sql);
				sqlParametro.setInt(1, entidade.getCod_itemPedido());
				sqlParametro.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					sqlParametro.close();
					conexao.close();
					teste = true;
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			return teste;
		}

		public List<ItemPedido> listar() {

			Connection conexao = new Conexao().geraConexao();
			List<ItemPedido> lista = new ArrayList<ItemPedido>();
			Statement consulta = null;
			ResultSet resultado = null;
			ItemPedido entidade = null;
			String sql;
			try {
				sql = "select * from itemPedido order by cod_item;";
				consulta = conexao.createStatement();
				resultado = consulta.executeQuery(sql);
				while (resultado.next()) {
					entidade = new ItemPedido();
					entidade.setCod_itemPedido(resultado.getInt("cod_itemPedido"));
					entidade.setTipo(resultado.getString("tipo"));
					entidade.setCod_pedido(resultado.getInt("cod_pedido"));
					entidade.setCod_item(resultado.getInt("cod_item"));
					entidade.setVal_item(resultado.getDouble("val_item"));
					lista.add(entidade);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					consulta.close();
					resultado.close();
					conexao.close();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			return lista;
		}

		public ItemPedido  buscarPorCodigo(int codigo) {

			Connection conexao = new Conexao().geraConexao();
			PreparedStatement consulta = null;
			ResultSet resultado = null;
			ItemPedido entidade = null;
			String sql;
			try {
				sql = "select * from itemPedido where cod_itemPedido = ?;";
				consulta = conexao.prepareStatement(sql);
				consulta.setInt(1, codigo);
				resultado = consulta.executeQuery();
				if (resultado.next()) {
					entidade = new ItemPedido();
					entidade.setCod_itemPedido(resultado.getInt("cod_itemPedido"));
					entidade.setTipo(resultado.getString("tipo"));
					entidade.setCod_pedido(resultado.getInt("cod_pedido"));
					entidade.setCod_item(resultado.getInt("cod_item"));
					entidade.setVal_item(resultado.getDouble("val_item"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					consulta.close();
					resultado.close();
					conexao.close();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			return entidade;
		}
}

