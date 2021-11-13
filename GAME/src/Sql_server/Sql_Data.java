package Sql_server;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.sql.ConnectionEvent;
public class Sql_Data {
	String url="jdbc:sqlserver://localhost:1433;databaseName=GAME_QUESTION";
	String username="sa";
	String password="1234";
	int[] index_of_quest=new int[30];
    private  String[] quest = new String[30];
	private String[] ans1 = new String[30];
	private String[] ans2 = new String[30];
	private String[] ans3 = new String[30];
	private String[] right_ans = new String[30];
	{
	
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	} catch(java.lang.ClassNotFoundException e) {
		System.out.print("ClassNotFoundException: ");
		System.out.println(e.getMessage());}
	try {
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connected to sql server");
		
		 ResultSet rs0;
			Statement stmt0 = connection.createStatement();
		rs0 = stmt0.executeQuery("SELECT number_of_quest FROM dbo.quest1");
		int v = 0;
		//System.out.println("the index of question is:");
		while (rs0.next()) {
			index_of_quest[v] = rs0.getInt("number_of_quest");
		//	System.out.printf("%n%s\n" ,index_of_quest[v]);
			v+= 1;}
		
        ResultSet rs;
		Statement stmt = connection.createStatement();
		rs = stmt.executeQuery("SELECT quest1 FROM dbo.quest1");
		int i = 0;
		//System.out.println("questions:");
		while (rs.next()) {
			quest[i] = rs.getString("quest1");
			//System.out.printf("%n%s%s%s" ,i+1,")" ,quest[i]);
			i += 1;
		}
		   ResultSet rs1;
			Statement stmt1 = connection.createStatement();
		rs1 = stmt1.executeQuery("SELECT ans1 FROM dbo.quest1");
		int j = 0;
		//System.out.println("\n\nfirst answer:");
		while (rs1.next()) {
			ans1[j] = rs1.getString("ans1");
			//System.out.printf("%n%s" , ans1[j]);
			j+= 1;
		}
		   ResultSet rs2;
			Statement stmt2 = connection.createStatement();
		rs2 = stmt2.executeQuery("SELECT ans2 FROM dbo.quest1");
		int a = 0;
		//System.out.println("\n\nsecond answer:");
		while (rs2.next()) {
			ans2[a] = rs2.getString("ans2");
			//System.out.printf("%n%s" ,ans2[a]);
			a += 1;
		}
		   ResultSet rs3;
			Statement stmt3 = connection.createStatement();
		rs3 = stmt3.executeQuery("SELECT ans3 FROM dbo.quest1");
		int b = 0;
		//System.out.println("\n\nthird answer:");
		while (rs3.next()) {
			ans3[b] = rs3.getString("ans3");
			//System.out.printf("%n%s" ,ans3[b]);
			b += 1;
		}
		   ResultSet rs4;
			Statement stmt4 = connection.createStatement();
		rs4 = stmt4.executeQuery("SELECT final_ans FROM dbo.quest1");
		int c = 0;
		//System.out.println("\n\nthe right answer is:");
		while (rs4.next()) {
			right_ans[c] = rs4.getString("final_ans");
			//System.out.printf("%n%s" ,right_ans[c]);
			c+= 1;
		}

	} catch (SQLException e) {
		System.out.println("There is an error in the connection to the database");
		System.out.println(	e.getMessage());
		e.printStackTrace();
	}
	
}
	public String getAns1(int i) {
		
		return ans1[i];
	}
	public String getAns2(int i) {
		return ans2[i];
	}
	public String getAns3(int i) {
		return ans3[i];
	}
	public String getQuest(int i) {
		return quest[i];
	}
	public String getRight_ans(int i) {
		return right_ans[i];
		
	}
	public int getIndex(int i) {
		return index_of_quest[i];
	}
	public int[] getSize() {
	return index_of_quest;
	}
}