package controllers;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import views.Users;


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
        // System.out.println(statement);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        // System.out.println(resultSet);
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
     public String fetchUsername(String email) throws SQLException {
        String sql = "SELECT user_name from users WHERE email = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        // statement.executeUpdate();
        ResultSet resultSet = statement.executeQuery();
        String username = "";
        while(resultSet.next()){
            username = resultSet.getString("user_name");

        }
        return username;
    }

    public ArrayList<ArrayList<String>> fetchUsers() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        String[] users;
        Users user = null;
        // List<User> userList = new ArrayList<>();
        String[] nested;
        // List<<String>> userList = new ArrayList<>();
        ArrayList<ArrayList<String>> userList = new ArrayList<ArrayList<String>>();
        while (resultSet.next()) {
            int id = resultSet.getInt("user_id");
            String name = resultSet.getString("full_name");
            String email = resultSet.getString("email");
            
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(name);
            temp.add(email);
            userList.add(temp);

    }
    // if (resultSet != null) {
    //         resultSet.close();
    //     }
    //     if (statement != null) {
    //         statement.close();
    //     }
    //     if (connection != null) {
    //         connection.close();
    //     }

        return userList;
    }
    public String fetchUserProjectDetails(int projectId) throws SQLException {
        String sql = "SELECT *  FROM users WHERE user_id  = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, projectId);
        // statement.executeUpdate();
        ResultSet resultSet = statement.executeQuery();
        String full_name = "";
        // String username;
        ArrayList<String> userDetails = new ArrayList<>();
    
            while(resultSet.next()){
                 full_name = resultSet.getString("full_name");
                // String username = resultSet.getString("user_name");
                System.out.println(full_name);

            } 
                // userDetails.add(username);

       
     
        System.out.println("From API ROUTERS" + userDetails);
        return full_name; 
    }
    public int fetchProjectID(String username) throws SQLException {
        String sql = "SELECT * from users WHERE email = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        // statement.executeUpdate();
        ResultSet resultSet = statement.executeQuery();
        String userId = "";
        while(resultSet.next()){
            userId = resultSet.getString("user_id");

        }
        int userIdInt = Integer.parseInt(userId);
        return userIdInt;
        
    } 
    public ArrayList<ArrayList<String>> fetchProjects() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM projects");
        // String[] projectList;
        Users user = null;
        // List<User> userList = new ArrayList<>();
        String[] nested;
        // List<<String>> userList = new ArrayList<>();
        ArrayList<ArrayList<String>> projectList = new ArrayList<ArrayList<String>>();
        while (resultSet.next()) {
            int id =  resultSet.getInt("project_id");
            String projectName = resultSet.getString("project_name");
            String projectDetails = resultSet.getString("project_description");
            String versionControl = resultSet.getString("version_control_system");
            String repoUrl = resultSet.getString("repository_url");
            String createdAt = resultSet.getString("created_at");
            String projectUserId = resultSet.getString("user_id");
            
            // String startDate = resultSet.getString("started_at");
            // String endData = resultSet.getString("end_date");
           String idNum = String.valueOf(id);
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(projectName);
            
            temp.add(projectDetails);
            temp.add(idNum);
            temp.add(versionControl);
            temp.add(repoUrl);
            temp.add(createdAt);
            temp.add(projectUserId);
            projectList.add(temp);

    }
   

        return projectList;
    }

}
 