package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.Conexao;
import entidade.Pedido;

public class PedidoDao implements IDAOCrud<Pedido> {
	
	public int salvar(Pedido entidade) {
 
		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		int codigo = 0;
		String sql;
		
		try {
			if(entidade.getCod_pedido() == 0){
				sql = "insert into Pedido(val_pedido, dat_pedido, cod_desconto) values(?, now(), ?);";
				sqlParametro = conexao.prepareStatement(sql);
				sqlParametro.setDouble(1, entidade.getVal_pedido());
				sqlParametro.setInt(2, entidade.getCod_desconto());
				sqlParametro.execute();
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

	public boolean excluir(Pedido entidade) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		boolean teste = false;
		try {
			sql = "delete from pedido where cod_pedido = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, entidade.getCod_pedido());
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

	public List<Pedido> listar() {

		Connection conexao = new Conexao().geraConexao();
		List<Pedido> lista = new ArrayList<Pedido>();
		Statement consulta = null;
		ResultSet resultado = null;
		Pedido entidade = null;
		String sql;
		try {
			sql = "select * from pedido order by cod_pedido;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				entidade = new Pedido();
				entidade.setCod_pedido(resultado.getInt("cod_Pedido"));
				entidade.setVal_pedido(resultado.getDouble("val_pedido"));
				entidade.setDat_pedido(resultado.getString("dat_pedido"));
				entidade.setCod_desconto(resultado.getInt("cod_desconto"));
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

	public Pedido  buscarPorCodigo(int codigo) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Pedido entidade = null;
		String sql;
		try {
			sql = "select * from pedido where cod_pedido = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				entidade = new Pedido();
				entidade.setCod_pedido(resultado.getInt("cod_Pedido"));
				entidade.setVal_pedido(resultado.getDouble("val_pedido"));
				entidade.setDat_pedido(resultado.getString("dat_pedido"));
				entidade.setCod_desconto(resultado.getInt("cod_desconto"));
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
