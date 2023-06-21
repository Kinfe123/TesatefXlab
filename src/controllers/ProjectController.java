package controllers;
import java.sql.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProjectController {

    
    // private Connection connection;

   public static Connection connection = null;
   

	//database connection initialization
	public ProjectController() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");  //lib name
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project_management_tool","root","alsotaken"); //dbname , mysqlaccname, mysqlpass
	}
    

    public boolean registerUser(String username, String fullName, String email, String password) throws SQLException {
        boolean status = false;
       
        String sql = "INSERT INTO users (user_name, email, password , full_name , created_at) VALUES (?, ?, ? , ? ,  NOW())";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, email);
        statement.setString(3, password);
        statement.setString(4, fullName);
        statement.executeUpdate();
        status = true;
        return status;
        
    }
    

    public boolean authenticateUser(String username, String password) throws SQLException {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
        return count == 1;
    }

    public void createIssue(String name, String description, String status, int projectId) throws SQLException {
        String sql = "INSERT INTO issues (issue_name, issue_description, status, project_id) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, description);
        statement.setString(3, status);
        statement.setInt(4, projectId);
        statement.executeUpdate();
    }

    public void createUserAssignment(int userId, int taskId) throws SQLException {
        String sql = "INSERT INTO user_assignments (user_id, task_id) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, userId);
        statement.setInt(2, taskId);
        statement.executeUpdate();
    }

    public void createTask(String name, String description, Date startDate, Date endDate, String status, int projectId) throws SQLException {
        String sql = "INSERT INTO tasks (task_name, task_description, start_date, end_date, status, project_id) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, description);
        statement.setDate(3, startDate);
        statement.setDate(4, endDate);
        statement.setString(5, status);
        statement.setInt(6, projectId);
        statement.executeUpdate();
    }

    public void createPullRequest(String name, String description, String status, int projectId) throws SQLException {
        String sql = "INSERT INTO pull_requests (pull_request_name, pull_request_description, status, project_id) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, description);
        statement.setString(3, status);
        statement.setInt(4, projectId);
        statement.executeUpdate();
    }
}