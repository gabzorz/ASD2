/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.asd.model.dao.DBConnector;
import uts.asd.model.dao.AccessDBManager;
import uts.asd.model.dao.PostDAO;
import uts.asd.model.Post;

/**
 *
 * @author CristinaFidelino
 */
public class TestPostDB {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private AccessDBManager db;
    private PostDAO pd;

    public static void main(String[] args) throws SQLException {
        (new TestPostDB()).runQueries();
    }
    
    public TestPostDB(){
    try {
        connector = new DBConnector();
        conn = connector.openConnection();
        db = new AccessDBManager(conn);
        pd = new PostDAO(conn);
    }
    catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    private char readChoice(){
        System.out.print("Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }

private void runQueries() throws SQLException {
    char c;
    
    while ((c = readChoice()) != '*'){
        switch(c){
            case 'C':
                testAdd();
                break;
            case 'R':
                testRead();
                break;
            case 'U':
                testUpdate();
                break;
            case 'D':
                testDelete();
                break;
            case 'S':
                testShow();
                break;
            case 'T':
                testCheck();
                break;
            default:
                System.out.println("Unknown Command");
        }
    }
}

private void testAdd(){
        System.out.print("Post Title: ");
        String title = in.nextLine();
        
        System.out.print("Post Category: ");
        String category = in.nextLine();
        
        System.out.print("Post Content: ");
        String content = in.nextLine();
    
        try {
            pd.addPost(title, category, content);
        } catch (SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Post is added to the database.");
} 

    private void testRead() throws SQLException {
        System.out.print("Post ID: ");
        int postID = in.nextInt();
        in.nextLine();
        
        ArrayList<Post> post = pd.searchPost(postID);
        
        if (post != null){
            for(Post p: post){
                System.out.println(p.getPostID());
                System.out.println("Post ID exists in database");
                
            }
        }
        else {
            System.out.println("Post ID does not exist");
        }  
    }
    
    private void testUpdate() throws SQLException {
        System.out.print("Post ID: ");
        int postID = in.nextInt();
        in.nextLine();
        
        try{
            if(pd.checkPost(postID)) {
                System.out.print("Post Title: ");
                String title = in.nextLine();
        
                System.out.print("Post Category: ");
                String category = in.nextLine();

                System.out.print("Post Content: ");
                String content = in.nextLine();
                
                pd.updatePost(postID, title, category, content);
                
                System.out.println("Post successfully updated");
            } else {
                System.out.println("Post ID does not exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testDelete() throws SQLException {
        System.out.print("Post ID: ");
        int postID = in.nextInt();
        in.nextLine();
        
        try{
            if(pd.checkPost(postID)) {
                pd.deletePost(postID);
                System.out.println("Post successfully deleted");
            } else {
                System.out.println("Post does not exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testShow() throws SQLException {
        try{
            ArrayList<Post> posts = pd.fetchPosts();
            System.out.println("POST TABLE: ");
            posts.stream().forEach((post) -> {
                System.out.printf("%-20s %-30s %-20s %10s\n", post.getPostID(), post.getTitle(), post.getCategory(), post.getContent());
            });
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    private int testCheck() throws SQLException {
        System.out.print("Post ID: ");
        int postID = in.nextInt();
        //in.nextLine();
        
        try{
            if(pd.checkPost(postID)) {
                System.out.println("Post found");
                return postID;
            } else {
                System.out.println("Post does not exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
