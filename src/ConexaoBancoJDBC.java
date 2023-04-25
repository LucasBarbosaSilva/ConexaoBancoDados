import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBancoJDBC {

	public static void main(String [] args) throws ClassNotFoundException, SQLException{
		Connection con = null;
		Statement stmt = null;
		
		try {
			
			String user = "SA";
			String passwd = "";
			String url = "jdbc:hsqldb:file:bd/locadora;hsqldb.lock_file=false";
			String driverUrl = "org.hsqldb.jdbc.JDBCDriver";
			
			Class.forName(driverUrl);
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from cliente;");

			System.out.println("CLIENTES:");
			int i = 1;
			while (rs.next()) {
				System.out.println("Cliente "+i+": ");
				System.out.println("Login: " + rs.getString("login"));
				System.out.println("Nome: " + rs.getString("nome"));
				i++;
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}catch (ClassNotFoundException e) {
			System.out.println(e);
		}finally {
			
			if(stmt != null){ 
				stmt.close();	
			}
			
			if(con != null){ 
				con.close();	
			}
			
		}
		
	}
}
