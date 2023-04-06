package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.NotaOperacao;

public class Operador extends Funcionario{

	@Override
	public void setSalario(double salario) {
		// TODO Auto-generated method stub
		this.salario = salario;
	}

	public void gerarImportacao(String carga, double quantidade, String destinatario, Date dataoperacao, String motorista) {
		String sql = "insert into operacao(tipocarga, quantidade, destinatario, tipoopercao, dataoperacao, motorista) values (?, ?, ?, ?, ?, ?)";
		try {
			Connection con = Conexao.criarConexao();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, carga);
			pst.setDouble(2, quantidade);
			pst.setString(3, destinatario);
			pst.setBoolean(4, true);
			pst.setDate(5, dataoperacao);
			pst.setString(6, motorista);
			pst.executeUpdate();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		
		
	}
	
	public void gerarExportacao(String carga, double quantidade, String destinatario, Date dataoperacao, String motorista) {
		String sql = "insert into operacao(tipocarga, quantidade, destinatario, tipoopercao, dataoperacao, motorista) values (?, ?, ?, ?, ?, ?)";
		try {
			Connection con = Conexao.criarConexao();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, carga);
			pst.setDouble(2, quantidade);
			pst.setString(3, destinatario);
			pst.setBoolean(4, false);
			pst.setDate(5, dataoperacao);
			pst.setString(6, motorista);
			pst.executeUpdate();
			
			NotaOperacao nota = new NotaOperacao();
			if(carga.equals("Minério")) {
				//O Minério custa 5 mil cada tonelada
				nota.criarNota(quantidade * 5, dataoperacao, carga);
			}
			else {
				//O Calcario custa 10 mil cada tonelada
				nota.criarNota(quantidade * 10, dataoperacao, carga);
			}
			
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}
	
	
}
