package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	   public static Connection GeraConexao(){
	        Connection conexao = null;
	       try{
	           String url = "jdbc:mysql://localhost/projeto_java";
	           String usuario ="root";
	           String senha="";
	           conexao = DriverManager.getConnection(url,usuario,senha);
	           System.out.println("Conexão realizada com sucesso.");
	       } catch (SQLException e) {
	           System.out.println("Ocorreu um erro ao tentar conectar: " + e.getMessage());
	           conexao = null; }
	        return conexao;
	    }  }
