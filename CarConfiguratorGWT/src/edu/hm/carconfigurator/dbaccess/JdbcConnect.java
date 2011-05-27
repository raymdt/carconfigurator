package edu.hm.carconfigurator.dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class JdbcConnect {

  public static void main(String[] args) {
    String username="ray";
    String passwort="ray";
    try {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("DRIVER OK !");
      String url = "jdbc:mysql://localhost/carconfigurator";
      String user = "root";
      String passwd = "root";
      Connection conn = DriverManager.getConnection(url,user,passwd);
      System.out.println("Connection sucessfull");
      
      java.sql.Statement state = conn.createStatement();
      ResultSet result = state.executeQuery("SELECT*FROM person where username='"+username+"' and passwort='"+passwort+"'");
      ResultSetMetaData resultMeta = result.getMetaData();
      
      for(int i=1; i<=resultMeta.getColumnCount();i++) 
        System.out.println("\n"+resultMeta.getColumnName(i).toUpperCase());
        
        while(result.next()) {
          for(int j=1;j<=resultMeta.getColumnCount();j++) {
            System.out.println("\n"+result.getObject(j).toString());
        }
      }
    
        result.close();
        state.close();
    }
    catch(Exception e) {
      System.out.println("ERROR bei der Verbindung");
      e.printStackTrace();
    }
    
  }
}
