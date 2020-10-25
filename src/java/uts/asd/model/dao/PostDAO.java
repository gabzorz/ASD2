<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uts.asd.model.Post;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author CristinaFidelino
 */
public class PostDAO {
    private Statement st;
    private Connection conn;
    
    public PostDAO(Connection conn) throws SQLException{
        st = conn.createStatement();
        this.conn = conn;
    }
   
    //function to search for posts
    public ArrayList<Post> searchPost(int searchID) throws SQLException {
        ArrayList<Post> searchPosts = new ArrayList();
        String search = "Select * from ASDREAMS.Post where POSTID=" + searchID + "";
        ResultSet rs = st.executeQuery(search);
        
        while (rs.next()){
            int postID = rs.getInt(1);
            String title = rs.getString(2);
            String category = rs.getString(3);
            String content = rs.getString(4);
            searchPosts.add(new Post(postID, title, category, content));
        }
        if(searchPosts.size() > 0){
            return searchPosts;
        }
        else{
            return null;
        }
    }
    
    //function to add posts information to database
    public void addPost(String title, String category, String content) throws SQLException{
        String update = "INSERT INTO ASDREAMS.Post(title, category, content) VALUES(?, ?, ?)";
        PreparedStatement st = conn.prepareStatement(update);
        st.setString(1, title);
        st.setString(2, category);
        st.setString(3, content);
        st.execute();
    }
    
    //function to create post object from content, title and category
    public Post findPost(String title, String category) throws SQLException{
        String search = "Select * from ASDREAMS.Post where TITLE='" + title + "'AND CATEGORY='"+category+"'";
        ResultSet rs = st.executeQuery(search);
        while (rs.next()){
            int postID = rs.getInt(1);
            String title2 = rs.getString(2);
            String category2 = rs.getString(3);
            String content2 = rs.getString(4);
            return new Post(postID, title2, category2, content2);
        }
        return null;
    }
    
    //function to update post information
    public void updatePost(int postID, String title, String category, String content) throws SQLException{
        st.executeUpdate("UPDATE ASDREAMS.Post SET TITLE ='" + title + "', CATEGORY='" + category + "', CONTENT='" + content + "' WHERE POSTID= " + postID + "");
    }

    //function to delete post information from database
    public void deletePost(int postID) throws SQLException {
        st.executeUpdate("DELETE FROM ASDREAMS.Post WHERE POSTID= " + postID + "");
    }
    
    //function to return posts within the database
    public ArrayList<Post> fetchPosts() throws SQLException {
        ArrayList<Post> posts = new ArrayList();
        String fetch = "Select * from ASDREAMS.Post";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()){
            int postID = rs.getInt(1);
            String title = rs.getString(2);
            String category = rs.getString(3);
            String content = rs.getString(4);
            posts.add(new Post(postID, title, category, content));
        }
        return posts;
    }
    
    //function to check postID in the database
    public boolean checkPost(int postID) throws SQLException{
       String fetch = "select * from ASDREAMS.Post where POSTID = " + postID + " ";
       ResultSet rs = st.executeQuery(fetch);
       
       while(rs.next()) {
           int userPost = rs.getInt(1);
           if (userPost == postID) {
               return true;
           }
       }
       return false;
   }
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uts.asd.model.Post;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author CristinaFidelino
 */
public class PostDAO {
    private Statement st;
    private Connection conn;
    
    public PostDAO(Connection conn) throws SQLException{
        st = conn.createStatement();
        this.conn = conn;
    }
   
    //function to search for posts
    public ArrayList<Post> searchPost(int searchID) throws SQLException {
        ArrayList<Post> searchPosts = new ArrayList();
        String search = "Select * from ASDREAMS.Post where POSTID=" + searchID + "";
        ResultSet rs = st.executeQuery(search);
        
        while (rs.next()){
            int postID = rs.getInt(1);
            String title = rs.getString(2);
            String category = rs.getString(3);
            String content = rs.getString(4);
            searchPosts.add(new Post(postID, title, category, content));
        }
        if(searchPosts.size() > 0){
            return searchPosts;
        }
        else{
            return null;
        }
    }
    
    //function to add posts information to database
    public void addPost(String title, String category, String content) throws SQLException{
        String update = "INSERT INTO ASDREAMS.Post(title, category, content) VALUES(?, ?, ?)";
        PreparedStatement st = conn.prepareStatement(update);
        st.setString(1, title);
        st.setString(2, category);
        st.setString(3, content);
        st.execute();
    }
    
    //function to create post object from content, title and category
    public Post findPost(String title, String category) throws SQLException{
        String search = "Select * from ASDREAMS.Post where TITLE='" + title + "'AND CATEGORY='"+category+"'";
        ResultSet rs = st.executeQuery(search);
        while (rs.next()){
            int postID = rs.getInt(1);
            String title2 = rs.getString(2);
            String category2 = rs.getString(3);
            String content2 = rs.getString(4);
            return new Post(postID, title2, category2, content2);
        }
        return null;
    }
    
    //function to update post information
    public void updatePost(int postID, String title, String category, String content) throws SQLException{
        st.executeUpdate("UPDATE ASDREAMS.Post SET TITLE ='" + title + "', CATEGORY='" + category + "', CONTENT='" + content + "' WHERE POSTID= " + postID + "");
    }

    //function to delete post information from database
    public void deletePost(int postID) throws SQLException {
        st.executeUpdate("DELETE FROM ASDREAMS.Post WHERE POSTID= " + postID + "");
    }
    
    //function to return posts within the database
    public ArrayList<Post> fetchPosts() throws SQLException {
        ArrayList<Post> posts = new ArrayList();
        String fetch = "Select * from ASDREAMS.Post";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()){
            int postID = rs.getInt(1);
            String title = rs.getString(2);
            String category = rs.getString(3);
            String content = rs.getString(4);
            posts.add(new Post(postID, title, category, content));
        }
        return posts;
    }
    
    //function to check postID in the database
    public boolean checkPost(int postID) throws SQLException{
       String fetch = "select * from ASDREAMS.Post where POSTID = " + postID + " ";
       ResultSet rs = st.executeQuery(fetch);
       
       while(rs.next()) {
           int userPost = rs.getInt(1);
           if (userPost == postID) {
               return true;
           }
       }
       return false;
   }
    
}
>>>>>>> Cristina
