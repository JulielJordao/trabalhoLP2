package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.Conexao;
import entidade.Acompanhamento;

public class AcompanhamentoDao {
	
	public int salvar(Acompanhamento entidade) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		int codigo = 0;
		String sql;
		
		try {
			if(entidade.getCod_acomp() == 0){
				sql = "insert into acompanhamento(val_acomp, nom_acomp, cod_promocao) values( ?, ?, ?);";
				sqlParametro = conexao.prepareStatement(sql);
				sqlParametro.setDouble(1, entidade.getVal_acomp());
				sqlParametro.setString(2, entidade.getNom_acomp());
				sqlParametro.setInt(3, entidade.getCod_promocao());
				sqlParametro.executeUpdate();
				sql = "select last_insert_id() as Codigo";
				sqlParametro = conexao.prepareStatement(sql);
				resultado = sqlParametro.executeQuery();
				if (resultado.next()) {
					codigo = resultado.getInt("Codigo");
					entidade.setCod_acomp(codigo);
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

	public boolean excluir(Acompanhamento entidade) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		boolean teste = false;
		try {
			sql = "delete from acompanhamento where cod_acomp = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setInt(1, entidade.getCod_acomp());
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

	public ArrayList<Acompanhamento> listar() {

		Connection conexao = new Conexao().geraConexao();
		ArrayList<Acompanhamento> lista = new ArrayList<Acompanhamento>();
		Statement consulta = null;
		ResultSet resultado = null;
		Acompanhamento entidade = null;
		String sql;
		try {
			sql = "select * from acompanhamento order by cod_acomp;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				entidade = new Acompanhamento();
				entidade.setCod_acomp(resultado.getInt("cod_acomp"));
				entidade.setVal_acomp(resultado.getDouble("val_acomp"));
				entidade.setNom_acomp(resultado.getString("nom_acomp"));
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

	public Acompanhamento  buscarPorCodigo(int codigo) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Acompanhamento entidade = null;
		String sql;
		try {
			sql = "select * from acompanhamento where cod_acomp = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				entidade = new Acompanhamento();
				entidade.setCod_acomp(resultado.getInt("cod_acomp"));
				entidade.setVal_acomp(resultado.getDouble("val_acomp"));
				entidade.setNom_acomp(resultado.getString("nom_acomp"));
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
	
	public ArrayList<Acompanhamento> buscarPorPromocao(int codigo){
		Connection conexao = new Conexao().geraConexao();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Acompanhamento entidade = null;
		ArrayList<Acompanhamento> lista = new ArrayList<Acompanhamento>();
		String sql;
		try {
			sql = "select * from acompanhamento where cod_promocao = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setInt(1, codigo);
			resultado = consulta.executeQuery();
			while (resultado.next()) {
				entidade = new Acompanhamento();
				entidade.setCod_acomp(resultado.getInt("cod_acomp"));
				entidade.setVal_acomp(resultado.getDouble("val_acomp"));
				entidade.setNom_acomp(resultado.getString("nom_acomp"));
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
