package project.test.DAO;
import project.test.DTO.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class evacuation_map_DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private	String url = "jdbc:mysql://localhost:3306/evacuationmap?characterEncoding=utf-8&serverTimezone=UTC&useSSL=false&useUnicode=true";

	private String user = "root";
	private String password = "password";

	public evacuation_map_DAO() { 
		try {
			
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insert_evaucation_map(String arr, int matSize, String floor) {
		try {
			Connection conn= DriverManager.getConnection(url, user, password);
			String sql= "insert into evacuationmap values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, matSize); 
			pstmt.setString(2, arr); 
			pstmt.setString(3, floor);
			
			int rows = pstmt.executeUpdate();
			System.out.println(rows);
			if (rows == 1) {
				return true;
			}

			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		return false;
		
	}
	
	public String[] select_evacuation_map() {
		try {
			
			Connection conn= DriverManager.getConnection(url, user, password);
			
			String map_info[] = new String[3];
			String sql = "select * from evacuationmap where floor= 'floor4' ";
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			
			ResultSet rs= pstmt.executeQuery();
			
			if(rs.next()) {
				map_info[0] =rs.getString("mapSize");
				map_info[1] = rs.getString("mapMatrix");
				map_info[2]= rs.getString("floor");
				
				for(int i=0; i<3; i++) {
					System.out.println(map_info[i]);
						
				}
				
				return map_info;
			}
			
		
			
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
