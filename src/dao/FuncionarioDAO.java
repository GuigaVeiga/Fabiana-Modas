package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import codigo.Funcionario;
import conexao.Conexao;

public class FuncionarioDAO {
	    
	private Connection connection;
	private String s;
	
	public Connection getConnection() {
	return connection;
	}
		
	public FuncionarioDAO(){
		this.connection = Conexao.GeraConexao();
		}
	
	Funcionario f = new Funcionario();
	
	
	public void adiciona(Funcionario f) throws SQLException{
		
		String sql = "INSERT INTO funcionario(nome,usuario,senha) value (?,?,?)";
		
		   
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, f.getNome());
				stmt.setString(2, f.getUsuario());
				stmt.setString(3, f.getSenha());
				
				stmt.execute();
				stmt.close();
				
	}
	
public void consulta() throws Exception{
    	
    	String sql = "SELECT * from funcionario";
    	
    			try ( PreparedStatement stm = connection.prepareStatement(sql);
    							ResultSet rs = stm.executeQuery()) {
    				
    				while(rs.next()){
    					setS(rs.getString("id")
    							+ " - " + rs.getString("nome"));
    					
    				}
    			}
    }



public String getS() {
	return s;
}

public void setS(String s) {
	this.s = s;
}
		
	
	
}
