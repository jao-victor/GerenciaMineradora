package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.commons.lang3.RandomStringUtils;


public class NotaOperacao implements NotaFiscal{

	private double valor;
	private Date dataEmissao;
	private String produto;
	private String codBarras;
	
	
	@Override
	public void criarNota(double valor, Date dataEmissao, String produto) {
		// TODO Auto-generated method stub
		
		String sql = "insert into nota(valor, dataEmissao, produto, codBarras) values (?, ?, ?, ?)";
		String codBarras = RandomStringUtils.randomAlphanumeric(15).toUpperCase();
		try {
			Connection con = Conexao.criarConexao();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setDouble(1, valor);
			pst.setDate(2, dataEmissao);
			pst.setString(3, produto);
			pst.setString(4, codBarras);
			pst.executeUpdate();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		
		
		
		
	}

	

}
