package br.com.jj.cadatroegest�o.mark.II;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection faz_conexao() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/Inquilinos","root","");
				
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getException());

		
		
		
		}
	}

}
