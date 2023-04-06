package models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gestor g1 = new Gestor();
		Operador o1 = new Operador();
		int opcao;
		Scanner scn = new Scanner(System.in);

		System.out.println("Sistema de cadastro de Operacões");

		while(true) {
			
			System.out.println("Digite seu cargo (1-operador/2-gestor/0-exit)");
			opcao = scn.nextInt();
			
			if(opcao == 1) {
				
				System.out.println("1-Gerar Importacão\n2-Gerar Exportacão");
				int opcao2 = scn.nextInt();
				System.out.println("\n");
				if (opcao2 == 1) {
					//GERANDO UMA IMPORTAÇÃO
					
					System.out.println("Qual é o produto (minerio/calcario): ");
					String carga = scn.next();
					System.out.print("Qual a quantidade de " + carga + "?: ");
					double quantidade = scn.nextDouble();
					System.out.print("Quem é o destinatário?: ");
					String destinatario = scn.next();
					System.out.print("Digite o ano da operação: ");
					int ano = scn.nextInt();
					System.out.print("Digite o mês da operação (entre janeiro - 01 e dezembro 12): ");
					int mes =  scn.nextInt();
					System.out.print("Digite o dia da operação (dias entre 1 e 9 deve ter 0");
					int dia = scn.nextInt();
					Date dataoperacao = new Date(ano, mes, dia);
					System.out.println("Digite o nome do motorista do caminhão: ");
					String motorista = scn.next();
					
					o1.gerarImportacao(carga, quantidade, destinatario, dataoperacao, motorista);
					System.out.println("Importação gerada com sucesso...");
				}
				else if(opcao2 == 2) {
					System.out.println("Qual é o produto (minerio/calcario): ");
					String carga = scn.next();
					System.out.print("Qual a quantidade de " + carga + "?: ");
					double quantidade = scn.nextDouble();
					System.out.print("Quem é o destinatário?: ");
					String destinatario =  scn.next();
					System.out.print("Digite o ano da operação: ");
					int ano = scn.nextInt();
					System.out.print("Digite o mês da operação (entre janeiro - 01 e dezembro 12): ");
					int mes =  scn.nextInt();
					System.out.print("Digite o dia da operação (dias entre 1 e 9 deve ter 0): ");
					int dia = scn.nextInt();
					Date dataoperacao = new Date(ano, mes, dia);
					System.out.println("Digite o nome do motorista do caminhão: ");
					String motorista = scn.next();
					
					o1.gerarExportacao(carga, quantidade, destinatario, dataoperacao, motorista);
					System.out.println("Exportação gerada com sucesso...");
				}
				
				
			}
			else if(opcao == 2) {
				System.out.println("1-Gerar Relatorio de operacao\n2-Gerar relatorio Geral");
				int opcao2 = scn.nextInt();
				
				if(opcao2==2) {
					
					try {
						ResultSet resultado = g1.relatorioGeral();
						//TIPO true é importação e tipo false é exportação
						System.out.println("ID     -   Produto    -     Pesagem    -    Destino     -   Tipo    -    Data    -     Mororista");
						while(resultado.next()) {
							System.out.println(resultado.getInt("id")+ "          "+ resultado.getString("tipoCarga")+ "           "+ resultado.getFloat("quantidade")+  "         "+  resultado.getString("destinatario")+ "            "+  resultado.getBoolean("tipoopercao")+ "         "+  resultado.getDate("dataoperacao")+   "      "+   resultado.getString("motorista"));
						}
					}catch (SQLException e) {
						e.printStackTrace();
					}
					
				}else if(opcao2 == 1) {
					System.out.println("Digite o id da operação: ");
					int id = scn.nextInt();
					
					try {
						ResultSet resultado = g1.relatorioOpercao(id);
						//TIPO true é importação e tipo false é exportação
						System.out.println("ID     -   Produto    -     Pesagem    -    Destino     -   Tipo    -    Data    -     Mororista");
						while(resultado.next()) {
							System.out.println(resultado.getInt("id")+ "          "+ resultado.getString("tipoCarga")+ "           "+ resultado.getFloat("quantidade")+  "         "+  resultado.getString("destinatario")+ "            "+  resultado.getBoolean("tipoopercao")+ "         "+  resultado.getDate("dataoperacao")+   "      "+   resultado.getString("motorista"));
						}
						
					}catch (SQLException e) {
						e.printStackTrace();
					}
					
					
				}
				
			} else if(opcao == 0) {
				break;
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		//getRow() total de linhas
		
		/*
		try {
			ResultSet resultado = g1.relatorioGeral();
			System.out.println("oloco oloco");
			while(resultado.next()) {
				System.out.println("ID     -   Produto    -     Pesagem    -    Destino     -   Tipo    -    Data    -     Mororista");
				System.out.println(resultado.getInt("id")+ "          "+ resultado.getString("tipoCarga")+ "           "+ resultado.getFloat("quantidade")+  "         "+  resultado.getString("destinatario")+ "            "+  resultado.getBoolean("tipoopercao")+ "         "+  resultado.getDate("dataoperacao")+   "      "+   resultado.getString("motorista"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		
		
		
	}

}
