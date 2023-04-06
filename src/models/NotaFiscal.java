package models;

import java.sql.Date;

public interface NotaFiscal {
	
	void criarNota(double valor, Date dataEmissao, String produto);


}
