package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.Conexao;
import entidade.Lanche;

public class LancheDao {
	
	public int salvar(Lanche entidade) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		int codigo = 0;
		String sql;
		
		try {
			if(entidade.getCod_lanche() == 0){
				sql = "insert into Lanche(cod_lanche, val_lanche, nom_lanche, cod_promocao) values(?, ?, ?, ?);";
				sqlParametro = conexao.prepareStatement(sql);
				sqlParametro.setInt(1, entidade.getCod_lanche());
				sqlParametro.setDouble(2, entidade.getVal_lanche());
				sqlParametro.setString(3, entidade.getNom_lanche());
				sqlParametro.setInt(4, entidade.getCod_promocao());
				sqlParametro.executeUpdate();
				sql = "select last_insert_id() as Codigo";
				sqlParametro = conexao.prepareStatement(sql);
				resultado = sqlParametro.executeQuery();
				if (resultado.next()) {
					codigo = resultado.getInt("Codigo");
					entidade.setCod_lanche(codigo);
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

	public boolean excluir(Lanche entidade) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		boolean teste = false;
		try {
			sql = "delete from lanche where cod_lanche = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, entidade.getCod_lanche());
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

	public ArrayList<Lanche> listar() {

		Connection conexao = new Conexao().geraConexao();
		ArrayList<Lanche> lista = new ArrayList<Lanche>();
		Statement consulta = null;
		ResultSet resultado = null;
		Lanche entidade = null;
		String sql;
		try {
			sql = "select * from lanche order by cod_lanche;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				entidade = new Lanche();
				entidade.setCod_lanche(resultado.getInt("cod_lanche"));
				entidade.setVal_lanche(resultado.getDouble("val_lanche"));
				entidade.setNom_lanche(resultado.getString("nom_lanche"));
				entidade.setCod_promocao(resultado.getInt("cod_promocao"));
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

	public Lanche  buscarPorCodigo(int codigo) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Lanche entidade = null;
		String sql;
		try {
			sql = "select * from lanche where cod_lanche = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				entidade = new Lanche();
				entidade.setCod_lanche(resultado.getInt("cod_lanche"));
				entidade.setVal_lanche(resultado.getDouble("val_lanche"));
				entidade.setNom_lanche(resultado.getString("nom_lanche"));
				entidade.setCod_promocao(resultado.getInt("cod_promocao"));
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
	public ArrayList<Lanche> buscarPorPromocao(int codigo){
		Connection conexao = new Conexao().geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Lanche entidade = null;
		ArrayList<Lanche> lista = new ArrayList<Lanche>();
		String sql;
		try {
			sql = "select * from Lanche where cod_promocao = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			while (resultado.next()) {
				entidade = new Lanche();
				entidade.setCod_lanche(resultado.getInt("cod_lanche"));
				entidade.setVal_lanche(resultado.getDouble("val_lanche"));
				entidade.setNom_lanche(resultado.getString("nom_lanche"));
				entidade.setCod_promocao(resultado.getInt("cod_promocao"));
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
}
