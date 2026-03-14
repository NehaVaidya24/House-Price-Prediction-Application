package housepriceDBConfig;
import java.sql.*;
public class DBConfig {
//	Protected variables because we can access protected class members in child class
	protected Connection connection;
	protected PreparedStatement pstmt;
	protected ResultSet resultset;
	
	public DBConfig()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
			        "jdbc:mysql://localhost:3306/HousePriceDetectionSyste",
			        "root",
			        "root"
			);
		}
		catch(Exception ex)
		{
			System.out.println("Error : " +ex);
		}
	}
}
