/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helpers;


import java.io.PrintWriter;
import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.util.Properties;

/**
 *
 * @author debmeister
 */
public class Connector {
    public Connection connect(){
        Connection myConnection=null;
        try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
//System.out.println("Good to go");
Properties prop = new Properties();
prop.setProperty("user", "root");
prop.setProperty("password", "");
            myConnection = getConnection(
                    "jdbc:mysql://localhost/ethel", prop);
        } catch (Exception E) {
System.out.println("JDBC Driver error"+E.toString());
}
  return myConnection;      
    }
}
