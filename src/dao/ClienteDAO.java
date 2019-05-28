package dao;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import codigo.Cliente;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ClienteDAO {
    
    private Connection connection;
    
	public Connection getConnection() {
		return connection;
	}
	public ClienteDAO(){
    	
	this.connection = Conexao.GeraConexao();
	
    }
    public void adiciona(Cliente c){
    	
        String sql = "INSERT INTO cliente(nome,rg,sexo,idade,contato,endereco,email,usuario,senha) VALUES(?,?,?,?,?,?,?,?,?)";
        try {

           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, c.getNome());
           stmt.setString(2, c.getRg());
           stmt.setString(3, c.getSexo());
           stmt.setInt(4, c.getIdade());
           stmt.setString(5, c.getContato());
           stmt.setString(6, c.getEndereco());
           stmt.setString(7, c.getEmail());
           stmt.setString(8, c.getUsuario());
           stmt.setString(9, c.getSenha());
           
         
           stmt.execute();
           stmt.close();
           
           JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

        } catch (SQLException u) {
        	JOptionPane.showMessageDialog(null, "O cadastro não foi realizado ");
        	System.out.println(u.getMessage());
          
        }
    }
    public void consulta() throws Exception{
    	
    	String sql = "SELECT * from cliente";
    	
    			try ( PreparedStatement stm = connection.prepareStatement(sql);
    							ResultSet rs = stm.executeQuery()) {
    				
    				while(rs.next()){
    					String s = rs.getString("nome")
    							+ "; " + rs.getString("senha")
    							+ "; " + rs.getString("rg")
    							+ "; " + rs.getString("endereco")
    							+ "; " + rs.getString("contato");
    				}
    			}
    }
    




}