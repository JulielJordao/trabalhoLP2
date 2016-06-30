package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.Conexao;
import entidade.CadastroCompra;

public class CadastroCompraDao {

	 public int salvar(CadastroCompra entidade) {
	
	 Connection conexao = new Conexao().geraConexao();
	 PreparedStatement sqlParametro = null;
	 ResultSet resultado = null;
	 int codigo = 0;
	 String sql;
	
	 try {
	 if(entidade.getCod_cad_compra() == 0){
	 sql = "insert into cadastroCompra(cod_cad_compra, cod_esp, telefone, mesa, datPedido, horPedido) values(?, ?, ?, ?, ?);";
	 sqlParametro = conexao.prepareStatement(sql);
	 sqlParametro.setInt(1, entidade.getCod_cad_compra());
	 sqlParametro.setString(2, entidade.getCod_esp());
	 sqlParametro.setLong(3, entidade.getTelefone());
	 sqlParametro.setInt(4, entidade.getMesa());
	 sqlParametro.setDate(5, entidade.getDatPedido());
	 sqlParametro.setTime(6, entidade.getHorPedido());
	 sqlParametro.executeUpdate();
	 sql = "select last_insert_id() as cod_cad_compra";
	 sqlParametro = conexao.prepareStatement(sql);
	 resultado = sqlParametro.executeQuery();
	 if (resultado.next()) {
	 codigo = resultado.getInt("cod_cad_compra");
	 entidade.setCod_cad_compra(codigo);
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
	
	 public boolean excluir(CadastroCompra entidade) {
	
	 Connection conexao = new Conexao().geraConexao();
	 PreparedStatement sqlParametro = null;
	 String sql;
	 boolean teste = false;
	 try {
	 sql = "delete from cadastroCompra where cod_Cad_compra = ?;";
	 sqlParametro = conexao.prepareStatement(sql);
	 sqlParametro.setInt(1, entidade.getCod_cad_compra());
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
	
	 public ArrayList<CadastroCompra> listar() {
	
	 Connection conexao = new Conexao().geraConexao();
	 ArrayList<CadastroCompra> lista = new ArrayList<CadastroCompra>();
	 Statement consulta = null;
	 ResultSet resultado = null;
	 CadastroCompra entidade = null;
	 String sql;
	 try {
	 sql = "select * from cadastroCompra order by cod_cad_compra;";
	 consulta = conexao.createStatement();
	 resultado = consulta.executeQuery(sql);
	 while (resultado.next()) {
	 entidade = new CadastroCompra();
	 entidade.setCod_cad_compra(resultado.getInt("cod_cad_compra"));
	 entidade.setCod_esp(resultado.getString("cod_esp"));
	 entidade.setTelefone(resultado.getLong("telefone"));
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
