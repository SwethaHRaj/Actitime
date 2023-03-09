package reusableComponents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;

public class DataBaseOperations {
	
	public HashMap<String,String> getDataAsHashMap(String sql){	//read and update
		
		HashMap<String,String> hm=null;
		try {
			Class.forName("------") ; 	//driver....api added to pom.xml sqlconnector
			Connection con=DriverManager .getConnection("jdbc:myoracle://localhost:----","---username","---pwd--");	//where my db is?
			
			Statement stmnt=con.createStatement();
			ResultSet rs=stmnt.executeQuery(sql);
			ResultSetMetaData md=rs.getMetaData();
			
			hm=new HashMap<>();
			while(rs.next())
				for(int i=1;i<=md.getColumnCount();i++)
					hm.put(md.getColumnName(i), rs.getString(i));
			System.out.println(hm);
			con.close();
		}
		catch (Exception e) {
		}		
		return hm;
	}

}
