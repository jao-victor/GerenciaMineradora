package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Gestor extends Funcionario {
	
	private double bonificacao = 500;

	
	
	@Override
	public void setSalario(double salario) {
		// TODO Auto-generated method stub
		this.salario = salario + this.bonificacao;
	}
	
	public ResultSet relatorioOpercao(int idOperacao) {
		// select * from Opercao wherer idoperacao = 'idOpercao'
		String id = String.valueOf(idOperacao);
		try {
			Connection con = Conexao.criarConexao();
			Statement stm = con.createStatement();
			ResultSet resultado = stm.executeQuery("Select * from operacao where id="+id);
			return resultado;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

		
	}
	
	
	public ResultSet relatorioGeral() {
		
		try {
			Connection con = Conexao.criarConexao();
			Statement stm = con.createStatement();
			ResultSet resultado = stm.executeQuery("Select * from operacao");
			return resultado;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

		
		
	}
	
}
