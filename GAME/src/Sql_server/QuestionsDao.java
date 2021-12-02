package Sql_server;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class QuestionsDao {
public List<questions> getQuestionsEH() throws Exception{
List<questions> quest = new ArrayList<questions>();
DB_CON DB=new DB_CON();
Connection con;
PreparedStatement stmt = null;
ResultSet rs = null;
String sql="SELECT * FROM [GAME_QUESTION].[dbo].[easy.modeH] ";
try {
con=DB.getConnection();
stmt=con.prepareStatement(sql);
rs=stmt.executeQuery();//save data to rs
while(rs.next()) {
	int numb_of_quest = rs.getInt("numb_of_quest");// column name()
	String quest1 = rs.getString("quest1");
	String ans1 = rs.getString("ans1");
	String ans2 = rs.getString("ans2");
	String ans3 = rs.getString("ans3");
	String final_ans = rs.getString("final_ans");
	questions q=new questions(numb_of_quest, quest1, ans1, ans2, ans3, final_ans);
	quest.add(q);
}
rs.close();
stmt.close();
DB.close();
return quest;
}
catch (Exception e) {
throw new ErrorClass(e.getMessage());
}
finally {
	try {
		DB.close();
	}
	catch (Exception e) {
		
	}
}

}
public List<questions> getQuestionsEM() throws Exception{
List<questions> quest2 = new ArrayList<questions>();
DB_CON DB=new DB_CON();
Connection con;
PreparedStatement stmt = null;
ResultSet rs = null;
String sql="SELECT * FROM [GAME_QUESTION].[dbo].[easy.modeΜ] ";
try {
con=DB.getConnection();
stmt=con.prepareStatement(sql);
rs=stmt.executeQuery();//save data to rs
while(rs.next()) {
	int numb_of_quest = rs.getInt("number_of_quest");// column name()
	String quest1 = rs.getString("quest1");
	String ans1 = rs.getString("ans1");
	String ans2 = rs.getString("ans2");
	String ans3 = rs.getString("ans3");
	String final_ans = rs.getString("final_ans");
	questions q=new questions(numb_of_quest, quest1, ans1, ans2, ans3, final_ans);
	quest2.add(q);
}
rs.close();
stmt.close();
DB.close();
return quest2;
}
catch (Exception e) {
throw new ErrorClass(e.getMessage());
}
finally {
	try {
		DB.close();
	}
	catch (Exception e) {
		
	}
}
}
public List<questions> getQuestionsHH() throws Exception{
List<questions> quest3 = new ArrayList<questions>();
DB_CON DB=new DB_CON();
Connection con;
PreparedStatement stmt = null;
ResultSet rs = null;
String sql="SELECT * FROM [GAME_QUESTION].[dbo].[hard.modeH] ";
try {
con=DB.getConnection();
stmt=con.prepareStatement(sql);
rs=stmt.executeQuery();//save data to rs
while(rs.next()) {
	int numb_of_quest = rs.getInt("numb_of_quest");// column name()
	String quest1 = rs.getString("quest1");
	String ans1 = rs.getString("ans1");
	String ans2 = rs.getString("ans2");
	String ans3 = rs.getString("ans3");
	String final_ans = rs.getString("final_ans");
	questions q=new questions(numb_of_quest, quest1, ans1, ans2, ans3, final_ans);
	quest3.add(q);
}
rs.close();
stmt.close();
DB.close();
return quest3;
}
catch (Exception e) {
throw new ErrorClass(e.getMessage());
}
finally {
	try {
		DB.close();
	}
	catch (Exception e) {
		
	}
}
}
public List<questions> getQuestionsHM() throws Exception{
List<questions> quest4 = new ArrayList<questions>();
DB_CON DB=new DB_CON();
Connection con;
PreparedStatement stmt = null;
ResultSet rs = null;
String sql="SELECT * FROM [GAME_QUESTION].[dbo].[hard.modeM] ";
try {
con=DB.getConnection();
stmt=con.prepareStatement(sql);
rs=stmt.executeQuery();//save data to rs
while(rs.next()) {
	int numb_of_quest = rs.getInt("number_of_quest");// column name()
	String quest1 = rs.getString("quest1");
	String ans1 = rs.getString("ans1");
	String ans2 = rs.getString("ans2");
	String ans3 = rs.getString("ans3");
	String final_ans = rs.getString("final_ans");
	questions q=new questions(numb_of_quest, quest1, ans1, ans2, ans3, final_ans);
	quest4.add(q);
}
rs.close();
stmt.close();
DB.close();
return quest4;
}
catch (Exception e) {
throw new ErrorClass(e.getMessage());
}
finally {
	try {
		DB.close();
	}
	catch (Exception e) {
		
	}
}
}
}
