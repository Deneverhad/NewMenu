package Menu;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class SQLConnector {
	
	public static final String URL = "jdbc:mysql://localhost:3306/invoice";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Wars";
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	Statement stmt;
	CallableStatement callStatement;
	ResultSet res;
	ArrayList<Object[]> listEX;
	Object[][] tmp;
	Object pa;
	int counter;
	int output;
	Connection conn;
	private static SQLConnector sqlConnector;
	
	private SQLConnector(){
		init();
	}
	private void init(){
		openConnection();
	}
	public static SQLConnector getInstance() {
		
		if (sqlConnector == null) {
			synchronized(Guide.class) {
				if (sqlConnector == null) {
					sqlConnector = new SQLConnector();
				}
			}
		}
		return sqlConnector;
	}
	
	public void openConnection() {
			try{
				System.out.println("Connecting to a selected database...");
				//Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(URL,  USERNAME, PASSWORD);
				System.out.println("Connected database successfully...");
				//String testquery = "INSERT INTO klienci(nazwa, nipklienta, adres, email, telefon)VALUES (\"asd\", \"1234567890\",\"adress\", \"emaill\", \"123456789\")";
				//stmt.executeUpdate(testquery);
			} catch(Exception se){
				se.printStackTrace();
			}
	}
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException throwables) {
			System.out.println("dont worry");
		}
	}
	
	public String[] selectColumns(String tableName){
	return new String[]{" ", "a"};
	}
	
	public Object[][] select(String tableName) {
		try{
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT * FROM " +tableName;
			ResultSet resultSet  = statement.executeQuery(query);
			int sizeOfrow=-1;
			if (resultSet != null) {
				resultSet.last();
				sizeOfrow = resultSet.getRow();
				resultSet.first();
			}
			stmt = conn.createStatement();
			
			ResultSet rs;
			ResultSetMetaData rsmd = rs.getMetaData();
			int size=rsmd.getPrecision(COLUMN_INDEX);
			
			if (tableName == "firma") {
				//String testquery = "SELECT * FROM firma";
				//tmp = new Object[6];
					//res = stmt.executeQuery(testquery);
					//while(res.next()){
						//Retrieve by column name
						//tmp[0] = res.getObject("firmaid");
						//tmp[1] = res.getInt("pracownikid");
					///	tmp[2] = res.getString("nazwafirmy");
					//	tmp[3] = res.getString("adresfirmy");
						//tmp[4] = res.getString("nipfirmy");
						//tmp[5] = res.getString("telefon");
						
						
					
				}
			else if (tableName == "faktura"){
					String testquery = "SELECT * FROM faktura";
					//tmp = new Object[6];
					//res = stmt.executeQuery(testquery);
					//while(res.next()){
						//Retrieve by column name
						//tmp[0] = res.getObject("fakutraid");
						//tmp[1] = res.getInt("firmaid");
						//tmp[2] = res.getString("klientid");
						//tmp[3] = res.getString("calkowitakwotabrutto");
						//tmp[4] = res.getString("calkowitakwotanetto");
						//tmp[5] = res.getString("Data");
						//listEX.add(tmp);
						
					}
				else if (tableName == "klienci"){
					//String testquery = "SELECT * FROM klienci";
					//tmp = new Object[6];
					//res = stmt.executeQuery(testquery);
					//while(res.next()){
						//Retrieve by column name
					//	tmp[0] = res.getObject("klientid");
						//tmp[1] = res.getInt("nazwa");
						//tmp[2] = res.getString("nipklienta");
						///tmp[3] = res.getString("adres");
						//tmp[4] = res.getString("email");
						//tmp[5] = res.getString("telefon");
						//listEX.add(tmp);
					}
				else if (tableName == "pracownicy"){
					String testquery = "SELECT * FROM pracownicy";
					//tmp = new Object[3];
					//res = stmt.executeQuery(testquery);
					//while(res.next()){
						//Retrieve by column name
						//tmp[0] = res.getObject("pracownikid");
						//tmp[1] = res.getInt("login");
						//tmp[2] = res.getString("haslo");
						//tmp[3] = res.getString("imie");
						//tmp[4] = res.getString("nazwisko");
						//tmp[5] = res.getString("uprawnienia");
						//listEX.add(tmp);
					}
				else if (tableName == "produkty") {
				
				String number = "SELECT COUNT(ProduktID) FROM produkty Group BY ProduktID";
				res = stmt.executeQuery(number);
				int numberRow = 0;
				while (res.next()) numberRow++;
				
				//String testquery = "SELECT * FROM produkty";
				tmp = new Object[numberRow][5];
				//res = stmt.executeQuery(testquery);
				int j = 0;
				do {
					//Retrieve by column name
					tmp[j][0] = resultSet.getInt("ProduktID");
					tmp[j][1] = resultSet.getString("NazwaProduktu");
					tmp[j][2] = resultSet.getInt("Cena");
					tmp[j][3] = resultSet.getString("Jednostka");
					tmp[j][4] = resultSet.getString("Podatek");
					j++;
					//System.out.println(tmp[0]+" "+tmp[1]+" "+ tmp[2]+" "+tmp[3]+" "+tmp[4] );
					//listEX.add(tmp);
					}while (resultSet.next());
				}
				else if (tableName == "produktynafakturze") {
					String testquery = "SELECT * FROM pracownicy";
					//tmp = new Object[8];
					res = stmt.executeQuery(testquery);
					while (res.next()) {
						//Retrieve by column name
						//tmp[0] = res.getObject("pozycjaid");
						//tmp[1] = res.getInt("produktid");
						//tmp[2] = res.getString("fakturaid");
						//tmp[3] = res.getString("cena");
						//tmp[4] = res.getString("iloscproduktu");
						//tmp[5] = res.getString("jednostka");
						//tmp[6] = res.getString("kwotanetto");
						//tmp[7] = res.getString("kwotabrutto");
						//listEX.add(tmp);
					}
				}
			
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
			return tmp;
		}
		
		public int dodajFaktura(int firmaid, int klientid, double calkowitakwotabruttoo, double calkowitakwotanettoo, String date){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call dodajFaktura(? ,? , ?, ?, CAST(? AS DATE) , ?) }");
				callStatement.setInt(1, firmaid);
				callStatement.setInt(2, klientid);
				callStatement.setDouble(3, calkowitakwotabruttoo);
				callStatement.setDouble(4, calkowitakwotanettoo);
				callStatement.setDate(5, Date.valueOf(date));
				callStatement.registerOutParameter(6, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(6);
				callStatement.close();
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		public int dodajFirma(int pracownikid, String nazwafirmy, String adresfirmy, String nipfirmy, String telefon){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call dodajFirma(? ,? , ?, ?, ? , ?) }");
				callStatement.setInt(1, pracownikid);
				callStatement.setString(2, nazwafirmy);
				callStatement.setString(3, adresfirmy);
				callStatement.setString(4, nipfirmy);
				callStatement.setString(5, telefon);
				callStatement.registerOutParameter(6, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(6);
				callStatement.close();
				
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		public int dodajProdukt(String nazwaproduktuu, Double cenaa, String jednostkaa, double podatekk){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call dodajProdukt(? ,? , ?, ?, ?) }");
				callStatement.setString(1, nazwaproduktuu);
				callStatement.setDouble(2, cenaa);
				callStatement.setString(3, jednostkaa);
				callStatement.setDouble(4, podatekk);
				callStatement.registerOutParameter(5, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(5);
				callStatement.close();
				
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		public int dodajPracownik(String login, String haslo, String imie, String nazwisko, int uprawnienia){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call dodajPracownik(? ,? , ?, ?, ? , ?) }");
				callStatement.setString(1, login);
				callStatement.setString(2, haslo);
				callStatement.setString(3, imie);
				callStatement.setString(4, nazwisko);
				callStatement.setInt(5, uprawnienia);
				callStatement.registerOutParameter(6, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(6);
				callStatement.close();
				
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		
		public int dodajListaProdukty(int produktidd, int fakturaidd, double cenaa, int iloscproduktuu, String jednosktaa, double kwotanettoo, double kwotabruttoo){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call dodajListaProdukty(? ,? , ?, ?, ? , ?, ?, ?) }");
				callStatement.setInt(1, produktidd);
				callStatement.setInt(2, fakturaidd);
				callStatement.setDouble(3, cenaa);
				callStatement.setInt(4, iloscproduktuu);
				callStatement.setString(5, jednosktaa);
				callStatement.setDouble(6, kwotanettoo);
				callStatement.setDouble(7, kwotabruttoo);
				callStatement.registerOutParameter(8, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(8);
				callStatement.close();
				
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		
		public int dodajKlient(String nazwaa, String nipklientaa, String adress, String emaill,String telefon){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call dodajKlient(? ,? , ?, ?, ?, ?) }");
				callStatement.setString(1, nazwaa);
				callStatement.setString(2, nipklientaa);
				callStatement.setString(3, adress);
				callStatement.setString(4, emaill);
				callStatement.setString(5, telefon);
				callStatement.registerOutParameter(6, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(6);
				callStatement.close();
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		
		public int logowanie(String loginn, String hasloo){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call logowanie(? ,? , ?) }");
				callStatement.setString(1, loginn);
				callStatement.setString(2, hasloo);
				callStatement.registerOutParameter(3, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(3);
				callStatement.close();
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		
		public int usunKlient(int id){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call usunKlient(? ,?) }");
				callStatement.setInt(1, id);
				callStatement.registerOutParameter(2, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(2);
				callStatement.close();
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		
		public int usunProdukt(int id){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call usunProdukt(? ,?) }");
				
				callStatement.setInt(1, id);
				callStatement.registerOutParameter(2, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(2);
				callStatement.close();
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		
		public int usunFirma(String  nip){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call usunFirma(? ,?) }");
				callStatement.setString(1, nip);
				callStatement.registerOutParameter(2, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(2);
				callStatement.close();
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		
		public int usunFaktura(int id){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call usunFaktura(? ,?) }");
				callStatement.setInt(1, id);
				callStatement.registerOutParameter(2, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(2);
				callStatement.close();
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		
		public int usunPracownik(int id){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call usunPracownik(? ,?) }");
				callStatement.setInt(1, id);
				callStatement.registerOutParameter(2, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(2);
				callStatement.close();
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		
		
		public int usunListaProdukty(int id){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call usunListaProdukty(? ,?) }");
				callStatement.setInt(1, id);
				callStatement.registerOutParameter(2, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(2);
				callStatement.close();
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		
		public int poprawFaktura(int id, int firmaid, int klientid, double calkowitakwotabruttoo, double calkowitakwotanettoo, String date){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call poprawFaktura(?, ? ,? , ?, ?, CAST(? AS DATE) , ?) }");
				callStatement.setInt(1, id);
				callStatement.setInt(2, firmaid);
				callStatement.setInt(3, klientid);
				callStatement.setDouble(4, calkowitakwotabruttoo);
				callStatement.setDouble(5, calkowitakwotanettoo);
				callStatement.setDate(6, Date.valueOf(date));
				callStatement.registerOutParameter(7, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(7);
				callStatement.close();
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		public int poprawFirma(int id, int pracownikid, String nazwafirmy, String adresfirmy, String nipfirmy, String telefon){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call poprawFirma(?, ? ,? , ?, ?, ? , ?) }");
				callStatement.setInt(1, id);
				callStatement.setInt(2, pracownikid);
				callStatement.setString(3, nazwafirmy);
				callStatement.setString(4, adresfirmy);
				callStatement.setString(5, nipfirmy);
				callStatement.setString(6, telefon);
				callStatement.registerOutParameter(7, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(7);
				callStatement.close();
				
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		public int poprawProdukt(int id, String nazwaproduktuu, Double cenaa, String jednostkaa, double podatekk){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call poprawProdukt(?, ? ,? , ?, ?, ?) }");
				callStatement.setInt(1, id);
				callStatement.setString(2, nazwaproduktuu);
				callStatement.setDouble(3, cenaa);
				callStatement.setString(4, jednostkaa);
				callStatement.setDouble(5, podatekk);
				callStatement.registerOutParameter(6, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(6);
				callStatement.close();
				
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		public int poprawPracownik(int id, String login, String haslo, String imie, String nazwisko, int uprawnienia){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call poprawPracownik(?, ? ,? , ?, ?, ? , ?) }");
				callStatement.setInt(1, id);
				callStatement.setString(2, login);
				callStatement.setString(3, haslo);
				callStatement.setString(4, imie);
				callStatement.setString(5, nazwisko);
				callStatement.setInt(6, uprawnienia);
				callStatement.registerOutParameter(7, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(7);
				callStatement.close();
				
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		
		public int poprawListaProdukty(int id, int produktidd, int fakturaidd, double cenaa, int iloscproduktuu, String jednosktaa, double kwotanettoo, double kwotabruttoo){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call poprawListaProdukty(?, ? ,? , ?, ?, ? , ?, ?, ?) }");
				callStatement.setInt(1, id);
				callStatement.setInt(2, produktidd);
				callStatement.setInt(3, fakturaidd);
				callStatement.setDouble(4, cenaa);
				callStatement.setInt(5, iloscproduktuu);
				callStatement.setString(6, jednosktaa);
				callStatement.setDouble(7, kwotanettoo);
				callStatement.setDouble(8, kwotabruttoo);
				callStatement.registerOutParameter(9, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(9);
				callStatement.close();
				
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		
		public int poprawKlient(int id, String nazwaa, String nipklientaa, String adress, String emaill,String telefon){
			output = 0;
			try {
				callStatement = conn.prepareCall("{ call poprawKlient(?, ? ,? , ?, ?, ?, ?) }");
				callStatement.setInt(1, id);
				callStatement.setString(2, nazwaa);
				callStatement.setString(3, nipklientaa);
				callStatement.setString(4, adress);
				callStatement.setString(5, emaill);
				callStatement.setString(6, telefon);
				callStatement.registerOutParameter(7, Types.INTEGER);
				callStatement.execute();
				output = callStatement.getInt(7);
				callStatement.close();
			} catch (SQLException throwables) {
				return output;
			}
			return output;
		}
		
		public int makebackup(){
			try {
				Runtime.getRuntime().exec("mysqldump -h 127.0.0.1 -u root -p music>C:\\Users\\karol\\Desktop\\backuptest.sql"); //nie wiem czy podwojne ukoscniki
			} catch (IOException e) {
				return  0;
			}
			return  1;
		}
		
		public int restorebackup(){
			try {
				stmt = conn.createStatement();
				String sql = "DROP DATABASE invoice";
				stmt.executeUpdate(sql);
				sql = "CREATE DATABASE invoice";
				stmt.executeUpdate(sql);
				Runtime.getRuntime().exec("mysql -h 127.0.0.1 -u root -p music<C:\\Users\\karol\\Desktop\\.sql)");
			} catch (SQLException throwables) {
				return 0;
			} catch (IOException e) {
				return 0;
			}
			return 1;
		}
	}

