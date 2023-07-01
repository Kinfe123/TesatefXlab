package models;

import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import com.mysql.fabric.xmlrpc.base.Array;

public class ProjectModel extends JFrame {

    static String name  = "";
    String detail = "";
    String id = "";
    String versionControl = "";
    String repoUrl = "" ;
    String createdAt = "";  


    public ProjectModel(String name , String detail , String id , String versionControl , String repoUrl , String createdAt  ) {
        this.name = name;
        
        this.detail = detail;
        this.id = id;
        this.repoUrl = repoUrl;
        this.versionControl = versionControl;
        this.createdAt = createdAt;
        ArrayList<String> lists = new ArrayList<>();
        lists.add(name);
        lists.add(detail);
        lists.add(id);
        lists.add(repoUrl);
        lists.add(versionControl);
        lists.add(createdAt);

        JList<String> displayList = new JList<>(lists.toArray(new String[0]));
        JScrollPane scrollPane = new JScrollPane(displayList);

        getContentPane().add(scrollPane);
       
        setVisible(true);
        

     }
    public static void main(String[] args) {
        
        // ProjectModel projectM = new ProjectModel(null, null)


       


    }
    
}
