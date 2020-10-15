/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import helpers.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author debmeister
 */
public class files {
  public String setFile(String name,String user,String status,String description){
         String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO files VALUES('"+user+"',NULL,'"+name+"',NULL,'"+status+"','"+description+"');"
);
result="Department was successfuly added.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
        
        return result;
        
    }  
  
  public String rep(String des){
     String fin=des.replace(" ",",");
     return fin; 
  }
  
  public ArrayList getKeyWords(String email){
       String [] result=new String[5000];
      ArrayList rizo=new ArrayList();
      try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT files.* FROM files WHERE user_id='"+email+"'");
while(rs.next()){
String desc[]=rs.getString("description").split(",");//return the comma delimeted description and spli it
int count=desc.length;//get the description lengt
for(int x=0;x<count;x++){
if(rizo.contains(desc[x])){
}else{
if(desc[x] != "" || desc[x] !=null){    
rizo.add(desc[x]);
}
}
}
}
}
//result=new String[rizo.size()];
 //result=(String[])rizo.toArray();//cast to array
int r=rizo.size();
String result2[]=new String[r];
for(int y=0;y<r;y++){
result2[y]=(String)rizo.get(y);
}
rizo.toArray(result);
//result=result2;
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
      
    return rizo;
      
  }
  
  public ArrayList getFiles(String email){
      ArrayList result=new ArrayList();
      ArrayList names=new ArrayList();
      ArrayList created=new ArrayList();
            try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM files WHERE user_id='"+email+"' ORDER BY created DESC");
//result.add(email);
while(rs.next()){
String name=rs.getString("name");
String date=rs.getString("created");
names.add(name);//return this user's files 
created.add(date);
}
result.add(names);
result.add(created);
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
}
      return result;
  }
  
  
  
}
