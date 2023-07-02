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

    public int fetchProjectId(String projectName) throws SQLException {
          String sql = "SELECT * from projects WHERE project_name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, projectName);
            // statement.executeUpdate();
            ResultSet resultSet = statement.executeQuery();
            int proId = -1;
            while(resultSet.next()){
                proId = resultSet.getInt("project_id");

            }
            return proId;

    }
    
    public boolean createIssue(String name, String description, String status, int projectId) throws SQLException {
        
        boolean statuses = false;
        //for sake of avoiding namespace collision
        String sql = "INSERT INTO issues (issue_name, issue_description, status, project_id) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, description);
        statement.setString(3, status);
        statement.setInt(4, projectId);
        
        statement.executeUpdate();
        statuses = true;
        return statuses;
    }

    public void createUserAssignment(int userId, int taskId) throws SQLException {
        String sql = "INSERT INTO user_assignments (user_id, task_id) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, userId);
        statement.setInt(2, taskId);
        statement.executeUpdate();
    }

    public boolean createTask(String name, String description, String username , String projectName) throws SQLException {
        boolean status = false;
        
        String sql = "INSERT INTO tasks (task_name, task_description, user_name, project_name , start_date , end_date ) VALUES (?, ?, ?, ?,NOW() ,NOW())";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, description);
        statement.setString(3, username);
        statement.setString(4, projectName);

        statement.executeUpdate();
        status = true;
        return status;

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
   
    public boolean createProject(int project_id , String project_name, String project_description, String versionControl , String repoUrl, String readme  , int user_id  ) throws SQLException {
        boolean status = false;
        
        String sql = "INSERT INTO projects (  user_id , project_name , project_description , version_control_system , repository_url , read_me , project_id ,  start_date , end_date) VALUES (?, ?, ? , ? , ? , ?, ? , NOW() , NOW())";
        PreparedStatement statement = connection.prepareStatement(sql);
        // statement.setInt(1, projectId);
        statement.setInt(1, user_id);
        statement.setString(2, project_name);
        statement.setString(3, project_description);
        statement.setString(4, versionControl);
        statement.setString(5, repoUrl);
        statement.setString(6, readme);
        statement.setInt(7, project_id);
        statement.executeUpdate();
        status = true;
        return status;
    }
    public boolean createFork(String name, String description,  int projectId , int user_id) throws SQLException {
        boolean status = false;
        
        String sql = "INSERT INTO forked_projects (main_project_id,forked_project_name,forked_project_description , forked_by_user_id) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, projectId);
        statement.setString(2, name);
        statement.setString(3, description);
        statement.setInt(4, user_id);
        statement.executeUpdate();
        status = true;
        return status;
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
    public boolean updateUserProfile(int user_id , String user_name , String email , String full_name , String Version_Control) throws  SQLException {
        boolean status = true;
        
        String sql = "UPDATE users SET user_name = ? , email = ? , full_name = ? , Version_Control = ? WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1  , user_name );
        statement.setString(2 , email);
        statement.setString(3 , full_name);
        statement.setString(4 , Version_Control);
        statement.setInt(5 , user_id);
        statement.executeUpdate();
        status = true;
        return status;
        

    }
    public ArrayList<String> dumpSpecificUser(int userId) throws SQLException {
        boolean status = true;
        
        String sql = "SELECT * FROM users WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1  , userId );
         ResultSet resultSet = statement.executeQuery();
         ArrayList<String> specificUser = new ArrayList<String>();
         while(resultSet.next()){

            String username = resultSet.getString("user_name");
            String fullName = resultSet.getString("full_name");
            String email = resultSet.getString("email");
            String versionControl = resultSet.getString("Version_Control");
            specificUser.add(username);
            specificUser.add(fullName);
            specificUser.add(email);
            specificUser.add(versionControl);

        }
        status = true;
        return specificUser;

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
            String id =  resultSet.getString("project_id");
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
            temp.add(id);
            projectList.add(temp);

    }
   

        return projectList;
    }
     public ArrayList<ArrayList<String>> fetchIssues() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select *  from issues join projects on projects.project_id = issues.project_id join users on projects.user_id = users.user_id");
        // String[] projectList;
       
        // List<<String>> userList = new ArrayList<>();
        ArrayList<ArrayList<String>> issueList = new ArrayList<ArrayList<String>>();
        while (resultSet.next()) {
            String id =  resultSet.getString("project_id");
            String projectName = resultSet.getString("project_name");
            String projectDetails = resultSet.getString("issue_description");
            String ownerName = resultSet.getString("full_name");
            String repoUrl = resultSet.getString("repository_url");
         
            
            // String startDate = resultSet.getString("started_at");
            // String endData = resultSet.getString("end_date");
           String idNum = String.valueOf(id);
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(projectName);
            
            temp.add(projectDetails);
            temp.add(idNum);
            temp.add(ownerName);
            temp.add(repoUrl);
            issueList.add(temp);

    }
   

        return issueList;
    }
     public ArrayList<ArrayList<String>> fetchTasks(String username) throws SQLException {
         String sql = "SELECT * from tasks WHERE user_name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        // statement.executeUpdate();
        ResultSet resultSet = statement.executeQuery();
        // List<<String>> userList = new ArrayList<>();
        ArrayList<ArrayList<String>> taskLists = new ArrayList<ArrayList<String>>();
        while (resultSet.next()) {
            String id =  resultSet.getString("task_id");
            String projectName = resultSet.getString("project_name");
            String taskDetail = resultSet.getString("task_description");
            String userAssigned = resultSet.getString("user_name");
            String taskName = resultSet.getString("task_name");
         
            
            // String startDate = resultSet.getString("started_at");
            // String endData = resultSet.getString("end_date");
           String idNum = String.valueOf(id);
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(idNum);
            temp.add(projectName);
            
            temp.add(taskDetail);
            temp.add(userAssigned);
            temp.add(taskName);
            taskLists.add(temp);

    }
   

        return taskLists;
    }

}
 