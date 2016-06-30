package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.Conexao;
import entidade.Promocao;

public class PromocaoDao {

	public int salvar(Promocao entidade) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		int codigo = 0;
		String sql;

		try {
			if (entidade.getCod_promocao() == 0) {
				sql = "insert into Promocao(val_desconto) values(?, ?)";
				sqlParametro = conexao.prepareStatement(sql);
				sqlParametro.setInt(1, entidade.getVal_desconto());
				sqlParametro.executeUpdate();
				sql = "select last_insert_id() as Codigo";
				sqlParametro = conexao.prepareStatement(sql);
				resultado = sqlParametro.executeQuery();

				if (resultado.next()) {
					codigo = resultado.getInt("cod_promocao");
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

	public boolean excluir(Promocao entidade) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		boolean teste = false;
		try {
			sql = "delete from promocao where cod_promocao = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, entidade.getCod_promocao());
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

	public List<Promocao> listar() {

		Connection conexao = new Conexao().geraConexao();
		List<Promocao> lista = new ArrayList<Promocao>();
		Statement consulta = null;
		ResultSet resultado = null;
		Promocao entidade = null;
		String sql;
		try {
			sql = "select * from Promocao order by cod_promocao;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				entidade = new Promocao();
				entidade.setCod_promocao(resultado.getInt("cod_promocao"));
				entidade.setVal_desconto(resultado.getInt("val_Promocao"));
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

	public Promocao buscarPorCodigo(int codigo) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Promocao entidade = null;
		String sql;
		try {
			sql = "select * from Promocao where cod_Promocao = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				entidade = new Promocao();
				entidade.setCod_promocao(resultado.getInt("cod_promocao"));
				entidade.setVal_desconto(resultado.getInt("val_Promocao"));
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
