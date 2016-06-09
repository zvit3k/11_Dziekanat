package pawlak.witold.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig;

import pawlak.witold.classes.Access;
import pawlak.witold.classes.Student;
import pawlak.witold.classes.Uczelnia;
import pawlak.witold.classes.Wpis;

public class Database {
	private static String DRV = "org.sqlite.JDBC";
	private static String DB = "jdbc:sqlite:Dziekanat.db";

	private static Connection conn; // komunikacja z baza
	private static Statement stat; // zarzadzaniami zapytaniami sql

	public static void connect() {
		try {
			Class.forName(DRV); // ladujemy sterownik
			
			//aktywacja mechanizmu kluczy obcych
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true);
			
			conn = DriverManager.getConnection(DB, config.toProperties()); // baza danych DB zostanie
													// utworzona na nowo jezeli
													// nie istniala
			// lub zostanie z nia nawiazane polaczenie jezeli istniala
			stat = conn.createStatement(); // inicjalizujemy zmienna od
											// zarzadzania zapytaniami
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ladujemy klase do aplikacji dzieki czemu pozniej mozemy uzywac jdbc
			// dla sqlite w programie
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createTables() {
		try {
			String tabelaStudent = "create table if not exists Student (id integer primary key autoincrement, "
					+ "imie varchar(50) not null, nazwisko varchar(50) not null, wiek integer not null, "
					+ "rokStudiow integer not null, zdjecie varchar(60) not null);";
			
			String tabelaU = "create table if not exists Uczelnia (id integer primary key autoincrement, "
					+ "nazwa varchar(30) not null, " + "miejscowosc varchar (30) not null, "
					+ "rokZalozenia integer (5) not null, " + "nazwaRektora varchar (20) not null );";
			
			String tabelaW = "create table if not exists Wpis (id integer primary key autoincrement,"
					+ "idStudent integer not null, idUczelnia integer not null,"
					+ "foreign key (idStudent) references Student(id) on delete cascade on update cascade,"
					+ "foreign key (idUczelnia) references Uczelnia(id) on delete cascade on update cascade);";
			
			String tableAccess = "create table if not exists Access " + "(id integer primary key autoincrement , "
					+ "login varchar(20) not null, " + "password varchar(20) not null, " + "role varchar (5) not null);";
	
			stat.execute(tableAccess);
			stat.execute(tabelaU);
			stat.execute(tabelaStudent);
			stat.execute(tabelaW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertStudent(String imie, String nazwisko, int wiek, int rokStudiow, String zdjecie) {
		String insertS = "insert into Student (imie, nazwisko, wiek, rokStudiow, zdjecie) values (?,?,?,?,?);";
		try {
			PreparedStatement ps = conn.prepareStatement(insertS);
			ps.setString(1, imie);
			ps.setString(2, nazwisko);
			ps.setInt(3, wiek);
			ps.setInt(4, rokStudiow);
			ps.setString(5, zdjecie);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateStudent(int id, String imie, String nazwisko, int wiek, int rokStudiow, String zdjecie) {
		String updateS = "update Student set imie=?, nazwisko=?, wiek=?, rokStudiow=?, zdjecie=? where id=?;";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(updateS);
			ps.setString(1, imie);
			ps.setString(2, nazwisko);
			ps.setInt(3, wiek);
			ps.setInt(4, rokStudiow);
			ps.setString(5, zdjecie);
			ps.setInt(6, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteStudent(int id) {
		String deleteS = "delete from Student where id=?;";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(deleteS);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<Student> selectStudent() {
		String selectS = "select * from Student";
		List<Student> lista = new ArrayList<>();
		try {
			ResultSet rs = stat.executeQuery(selectS);
			while (rs.next()) {
				int id = rs.getInt("id"); // to w "" to nazwa kolumny z tabeli
				String imie = rs.getString("imie");
				String nazwisko = rs.getString("nazwisko");
				int wiek = rs.getInt("wiek");
				int rokStudiow = rs.getInt("rokStudiow");
				String zdjecie = rs.getString("zdjecie");
				lista.add(new Student(id, imie, nazwisko, wiek, rokStudiow, zdjecie));
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void insertUczelnia(String nazwa, String miejscowosc, int rokZalozenia, String nazwaRektora) {
		String insertU = "insert into Uczelnia (nazwa, miejscowosc, rokZalozenia, nazwaRektora) values (?,?,?,?) ;";

		try {
			PreparedStatement ps = conn.prepareStatement(insertU);
			ps.setString(1, nazwa);
			ps.setString(2, miejscowosc);
			ps.setInt(3, rokZalozenia);
			ps.setString(4, nazwaRektora);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateUczelnia(int id, String nazwa, String miejscowosc, int rokZalozenia, String nazwaRektora) {
		String updateU = "update Uczelnia set nazwa=?, miejscowosc=?, rokZalozenia=?, nazwaRektora=? where id=? ;";
		try {
			PreparedStatement ps = conn.prepareStatement(updateU);
			ps.setString(1, nazwa);
			ps.setString(2, miejscowosc);
			ps.setInt(3, rokZalozenia);
			ps.setString(4, nazwaRektora);
			ps.setInt(5, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteUczelnia(int id) {
		String deleteU = "delete from Uczelnia where id=?;";
		try {
			PreparedStatement ps = conn.prepareStatement(deleteU);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<Uczelnia> selectUczelnia() {
		String selectU = "select * from Uczelnia";
		List<Uczelnia> lista = new ArrayList<>();
		try {
			ResultSet rs = stat.executeQuery(selectU);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nazwa = rs.getString("nazwa");
				String miejscowosc = rs.getString("miejscowosc");
				int rokZalozenia = rs.getInt("rokZalozenia");
				String nazwaRektora = rs.getString("nazwaRektora");
				lista.add(new Uczelnia(id, nazwa, miejscowosc, rokZalozenia, nazwaRektora));
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static void insertUser(String userName, String userPassword, String userRole) {
		String newUser = "insert into Access (login, password, role) values (?,?,?);";
		try {

			PreparedStatement ps = conn.prepareStatement(newUser);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ps.setString(3, userRole);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateUser(int id, String userName, String userPassword, String userRole) {
		String updateUser = "update Access set userName=?, userPassword=?, userRole=? where id=?;";
		try {
			PreparedStatement ps = conn.prepareStatement(updateUser);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ps.setString(3, userRole);
			ps.setInt(4, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteUser(int id) {
		String deleteUser = "delete Access where id=?;";
		try {
			PreparedStatement ps = conn.prepareStatement(deleteUser);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Access> selectAccess() {
		String selectUser = "select * from Access";
		List<Access> list = new ArrayList<>();
		try {
			ResultSet rs = stat.executeQuery(selectUser);
			while (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("login");
				String userPassword = rs.getString("password");
				String userRole = rs.getString("role");
				list.add(new Access(id, userName, userPassword, userRole));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void insertWpis(int idStudent, int idUczelnia) {
		String insertW = "insert into Wpis (idStudent, idUczelnia) values (?,?) ;";

		try {
			PreparedStatement ps = conn.prepareStatement(insertW);
			ps.setInt(1, idStudent);
			ps.setInt(2, idUczelnia);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteWpis(int id){
		String deleteW = "delete Wpis where id=?;";
		try {
			PreparedStatement ps = conn.prepareStatement(deleteW);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void updateWpis(int id, int idSudent, int idUczelnia){
		String updateW = "update Wpis set idStudent=?, idUczelnia=? where id=?;";
		try {
			PreparedStatement ps = conn.prepareStatement(updateW);
			ps.setInt(1, idSudent);
			ps.setInt(2, idUczelnia);
			ps.setInt(3, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Wpis> selectWpis() {
		String selectWpis = "select * from Wpis";
		List<Wpis> list = new ArrayList<>();
		try {
			ResultSet rs = stat.executeQuery(selectWpis);
			while (rs.next()) {
				int id = rs.getInt("id");
				int idStudent = rs.getInt("idStudent");
				int idUczelnia = rs.getInt("idUczelnia");
				list.add(new Wpis(id, idStudent, idUczelnia));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
