package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.Conexao;
import entidade.Bebida;

public class BebidasDao {
	
	public int salvar(Bebida entidade) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		int codigo = 0;
		String sql;
		
		try {
			if(entidade.getCod_bebida() == 0){
				sql = "insert into Bebida(cod_bebida, val_bebida, nom_bebida, cod_promocao) values(?, ?, ?, ?);";
				sqlParametro = conexao.prepareStatement(sql);
				sqlParametro.setInt(1, entidade.getCod_bebida());
				sqlParametro.setDouble(2, entidade.getVal_bebida());
				sqlParametro.setString(3, entidade.getNom_bebida());
				sqlParametro.setInt(4, entidade.getCod_promocao());
				sqlParametro.executeUpdate();
				sql = "select last_insert_id() as Codigo";
				sqlParametro = conexao.prepareStatement(sql);
				resultado = sqlParametro.executeQuery();
				if (resultado.next()) {
					codigo = resultado.getInt("Codigo");
					entidade.setCod_bebida(codigo);
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

	public boolean excluir(Bebida entidade) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		boolean teste = false;
		try {
			sql = "delete from bebida where cod_bebida = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, entidade.getCod_bebida());
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

	public ArrayList<Bebida> listar() {

		Connection conexao = new Conexao().geraConexao();
		ArrayList<Bebida> lista = new ArrayList<Bebida>();
		Statement consulta = null;
		ResultSet resultado = null;
		Bebida entidade = null;
		String sql;
		try {
			sql = "select * from bebida order by cod_bebida;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				entidade = new Bebida();
				entidade.setCod_bebida(resultado.getInt("cod_bebida"));
				entidade.setVal_bebida(resultado.getDouble("val_bebida"));
				entidade.setNom_bebida(resultado.getString("nom_bebida"));
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

	public Bebida  buscarPorCodigo(int codigo) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Bebida entidade = null;
		String sql;
		try {
			sql = "select * from bebida where cod_bebida = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				entidade = new Bebida();
				entidade.setCod_bebida(resultado.getInt("cod_Bebida"));
				entidade.setVal_bebida(resultado.getDouble("val_bebida"));
				entidade.setNom_bebida(resultado.getString("nom_bebida"));
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
	
	public ArrayList<Bebida> buscarPorPromocao(int codigo){
		Connection conexao = new Conexao().geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Bebida entidade = null;
		ArrayList<Bebida> lista = new ArrayList<Bebida>();
		String sql;
		try {
			sql = "select * from bebida where cod_promocao = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			while (resultado.next()) {
				entidade = new Bebida();
				entidade.setCod_bebida(resultado.getInt("cod_bebida"));
				entidade.setVal_bebida(resultado.getDouble("val_bebida"));
				entidade.setNom_bebida(resultado.getString("nom_bebida"));
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
