package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    static final String url = "jdbc:postgresql://localhost:5432/mineradora"; //incica o caminho do banco de dados
	static final String user = "postgres"; // aqui vai o nome usuario que vc quer acessar
	static final String pass = "@JoaoVictor10"; // aqui a senha do seu banco	

	public static Connection criarConexao() throws ClassNotFoundException, SQLException{
		//Class.forName("org.postgresql.Driver");
		Connection conecta = DriverManager.getConnection(url, user, pass);
	if (conecta != null){
	return conecta;
	}
	return null;
	}
	
}