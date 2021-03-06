package net.javaguides.registration.dao;

import java.sql.*;

import net.javaguides.registration.model.Employee;


public class EmployeeDao {
	
	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO employee" + "(id, first_name, last_name, username, password, address, contact) VALUES "+ "(?, ?, ?, ?, ?, ?, ?);";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		//connection
		
		String url = "jdbc:mysql://localhost:3307/employees";
		String uname = "root";
		String pass = "QWERTY786";
	//	String query = "select * from newoffice";
		
		
		try (Connection connection = DriverManager.getConnection(url,uname,pass);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			
			preparedStatement.setInt(1, 3);
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setString(4, employee.getUsername());
			preparedStatement.setString(5, employee.getPassword());
			preparedStatement.setString(6, employee.getAddress());
			preparedStatement.setString(7, employee.getContact());
		
			System.out.println(preparedStatement);
			
			
			//Statement st = connection.createStatement();
			//ResultSet rs = st.executeQuery(query);
		
			
			result = preparedStatement.executeUpdate();
		
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

}
