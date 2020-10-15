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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author debmeister
 */
public class user {
public String setName(String name,String email,String password,String movie,String music,String color,String birth,String ip){
         String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO user VALUES('"+name+"',NULL,'"+email+"','"+password+"','"+ip+"','"+color+"','"+movie+"','"+music+"','"+birth+"','"+this.createRandom(5,5)+"');"
);
result="User was successfuly added.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
        
        return result;
        
    } 

  public String[] getChoices(String email){
      String[] choices=new String[4];
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT user.* FROM user WHERE email='"+email+"'");
while(rs.next()){
    choices[0]=rs.getString("color");//my fav food
choices[1]=rs.getString("movie");
choices[2]=rs.getString("music");
choices[3]=rs.getString("birth");
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
                
        return choices;
        
    }
  

  
    public ArrayList login(String email,String password,String nip){
      ArrayList result=new ArrayList();
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT user.* FROM user WHERE email='"+email+"' AND pasword='"+password+"'");
while(rs.next()){
result.add(rs.getString("name"));
result.add(rs.getString("email"));
result.add(rs.getString("movie"));
result.add(rs.getString("music"));
result.add(rs.getString("color"));
result.add(rs.getString("birth"));
result.add(rs.getString("ip"));
this.setLogInTime(email,nip);
result.add(this.timeDiff(this.getLoginTimes(rs.getString("email"))));
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
                
        return result;
        
    }
    
    

    
    

    public String updateIP(String email,String ip){
         String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"UPDATE user SET ip='"+ip+"' WHERE email='"+email+"';"
);
result="IP updated.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
        
        return result;
        
    } 

    
    
    
    
public String setLogInTime(String email,String ip){
Timestamp timestamp=null;//or you can assign this stuff to stime variable
Calendar cal = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO login VALUES(NULL,'"+sdf.format(cal.getTime()).substring(11)+"','"+email+"','"+ip+"');"
);
result="User was successfuly added.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
        
        return result;
        
    }
    
      public String getLoginTimes(String email){
String result=""; 
try {
    

            Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
 statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT SEC_TO_TIME(AVG(TIME_TO_SEC(`logged`))) AS vg FROM login WHERE uid='"+email+"'");
while(rs.next()){
result=rs.getString("vg");

}
}
} catch(Exception insertException) {
result="Error while getting details :"+insertException.toString();
}
                
   return result;        
    }
      
public long timeDiff(String first){
String time1 = first;
String time2 = "";
Timestamp timestamp=null;//or you can assign this stuff to stime variable
Calendar cal = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
time2=sdf.format(cal.getTime()).substring(11);
long difference=0;
try{
SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
Date date1 = format.parse(time1);
Date date2 = format.parse(time2);
difference = date2.getTime() - date1.getTime(); 
}catch(Exception ex){
    
}   
return difference;
}
    

public String createRandom(final int maxLength, final int maxTry){
   final Random random = new Random(System.nanoTime());
    final int max = (int) Math.pow(10, maxLength);
    final int maxMin = (int) Math.pow(10, maxLength-1);
    int i = 0;
    boolean unique = false;
    int randomId = -1;
    while (i < maxTry) {
        randomId = random.nextInt(max - maxMin - 1) + maxMin;
        i++;
    }
    return String.valueOf(randomId);
}

public int create(final int maxLength, final int maxTry){
   final Random random = new Random(System.nanoTime());
    final int max = (int) Math.pow(10, maxLength);
    final int maxMin = (int) Math.pow(10, maxLength-1);
    String result="";
    int i = 0;
    boolean unique = false;
    int randomId = -1;
    while (i < maxTry) {
        randomId = random.nextInt(max - maxMin - 1) + maxMin;
        i++;
    }
    if(randomId > 4)
    {
    randomId=0;
    }
    return randomId;
}


    
}
