package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import Student.Student;

public class database {
		static String url="jdbc:mysql://localhost:3306/quanlysv";
		static String user="root";
		static String password="Phoenix1510@";
		public static Connection getConnection() {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(url, user, password);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}
	
	public static List<Student>findAll(){
		List<Student>studentList= new ArrayList<>();
		String query="select*from student";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				Student st = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
						rs.getInt("gender"),rs.getString("major"), rs.getFloat("score"));
				studentList.add(st);
			}
		}catch(Exception e) {
			
		}
		return studentList;
		
	}
	
	public static void insert(Student st) {
		String query="insert into student(name, age, genser, major, score) value(?,?,?,?,?)";
		try {
			Connection connection= getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1, st.getName());
			pstmt.setInt(2, st.getAge());
			pstmt.setInt(3, st.getGender());
			pstmt.setInt(4, st.getMSSV());
			pstmt.setFloat(5, st.getScore());
			pstmt.execute();			
		}catch(Exception e) {
			
		}
	}
	
	public static void delete(Student st) {
		String query="delete into student(name, age, genser, major, score) value(?,?,?,?,?)";
		try {
			Connection connection= getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.execute();			
		}catch(Exception e) {
			
		}
	}
	
	public static void update(Student st) {
		String query="update from student where name='" +st.getName() + "'";
		try {
			Connection connection= getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, st.getName());
			pstmt.setInt(2, st.getAge());
			pstmt.setInt(3, st.getGender());
			pstmt.setInt(4, st.getMSSV());
			pstmt.setFloat(5, st.getScore());
			pstmt.execute();		
		}catch(Exception e) {
			
		}
	}
	
	public static List<Student>findByName(Student s){
		List<Student>studentList= new ArrayList<>();
		String query="select*from student where name='"+s.getScore() + "'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				Student st = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
						rs.getInt("gender"),rs.getString("major"), rs.getFloat("score"));
				studentList.add(st);
			}
		}catch(Exception e) {
			
		}
		return studentList;
	}

}
