package Task12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcconnection {

	public static void main(String[] args) {
		
		//database information
		
		String db_url="jdbc:mysql://localhost:3306/";
		String username="root";
		String password="Subash@123";
		
		//Establishing connection
		try {
			
			Connection conn=DriverManager.getConnection(db_url,username,password);
			
			//validate the connection is success
			//create statement
			Statement stm = conn.createStatement();
			
			//insert data
			String creatDB="Create database JDBCtask";
			String use= "use JDBCtask";
			String createTbl="create table empinfo(empcode int,empname varchar(30),empage int,esalary long);";
			String insert="insert into empinfo values(101,'jenny',25,10000),"+"(102,'jecky',30,20000),"+"(103,'Joe',20,40000),"+"(104,'John',40,80000),"+"(105,'Shameer',25,90000)";
			String select ="select * from empinfo";
			
//			stm.execute(creatDB);
			stm.execute(use);
//			stm.execute(createTbl);
//			stm.execute(insert);
			stm.execute(select);
			
			//resultset
			ResultSet rs=stm.executeQuery(select);
			
			System.out.println("=============================");
		
			while(rs.next()) {
				System.out.println(rs.getInt("empcode")+" "+rs.getString("empname")+" "+rs.getInt("empage")+" "+rs.getLong("esalary"));
			}
			//closing the connection
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		
	}

}
