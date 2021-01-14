package Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnector {
	public static final String URL = "jdbc:mysql://localhost:3306/invoice";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Wars";
	
	public SQLConnector() {
		
		try (
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt = con.createStatement()
			//System.out.println("Conexion exitosa");
		){
			String testquery = "INSERT INTO klienci(KlientID,Nazwa, NIPKlienta, Adres, Email, Telefon) VALUES (\"1\",\"Kotek\", \"12345678\", \"adress\", \"emaill\", 1233212); ";
			//ResultSet res = stmt.executeQuery(testquery);
			stmt.executeUpdate(testquery);
			
		} catch (SQLException ex) {
				ex.printStackTrace();
			System.out.println("Error");
		}
	}
	
	public void mostrarDatos() {
		/*String name;
		try {
			Connection con = null;
			con = getConnection();
			
			CallableStatement cs;
			cs = con.prepareCall("{CALL comprobarUsuario(?,?,?)}");
			cs.setString(1,"Jorge" );
			cs.setString(2, "1627Jorge");
			cs.registerOutParameter(3, SQLType,name);
			ResultSet rs2 = cs.executeQuery();
			
			if(rs2.next()){
				System.out.println(true);
			}
			int resultado = cs.getInt("idusuarios");
			System.out.println(resultado);
			con.close();
			
		} catch (Exception e) {
		
		}*/
	}
}

