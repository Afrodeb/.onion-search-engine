/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import helpers.Connector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
//import javax.servlet.ServletContext;

/**
 *
 * @author debmeister
 */
public class Mining {
    
    public String readFile(String fileName){
       String rizo="";
       try{
File f = new File(fileName);
FileReader fr = new FileReader(f);
BufferedReader br  = new BufferedReader(fr);
String s = null;
while ((s = br.readLine()) != null) {
rizo = rizo + s;   
}

br.close();
    }catch(Exception io){
           rizo=io.toString();
       }
       return rizo;
    }
  
    public String writeFile(String fileName,String text){
        String rizo="";
        try{
    FileWriter fw = new FileWriter(fileName); //the true will append the new data
    fw.write(text);//appends the string to the file
    fw.close();
    rizo="File Appended";
}
catch(IOException ioe)
{
    rizo="IOException: " + ioe.getMessage();
}
        
        return rizo;        
    }
    
public String createClassifierTrainingModel(){
varwere v=new varwere();
ArrayList cats=v.categories();
ArrayList sets=v.getTraining();
String categories="";
String set="";
int c=cats.size();
int s=sets.size();
for(int x=0;x<c;x++){
categories=categories+cats.get(x)+",";
}
categories=categories.substring(0, categories.length() - 1);//remove lasst coma
for(int o=0;o < s; o++){
   ArrayList st=(ArrayList)sets.get(o);
   String sentence=(String)st.get(2);
   sentence=sentence.trim();
   set ="\n"+set+"\n"+st.get(1)+",'"+sentence+"',";
}
//set=set.substring(0, set.length() - 1);//remove lasst coma

String text="@relation sms_test\n" +
"\n" +
"@attribute spamclass {"+categories+"}\n\n" +
"@attribute text String\n" +
"\n" +
"@data" + set;    
return text;
}

public String trainData(String model){
  String result="";
  varwere v=new varwere();
  ArrayList content=v.getMinedContent();
  ArrayList page=new ArrayList();
   deleteMined();//lets delete previousley classsfied data first
  int s=content.size();
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
for(int x=0;x < s;x++){
    page=(ArrayList)content.get(x);
  MyFilteredClassifier classy=new MyFilteredClassifier();
  String clas=classy.start((String)page.get(1),model);
  
int i = statement.executeUpdate(
"INSERT INTO classification(class,cid) VALUES('"+clas+"','"+page.get(0)+"');"
);
result="training statement was successfuly added."; 
}

}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
       
        return result;
     
    }

public String deleteMined(){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"DELETE FROM classification WHERE 1;"
);
result="Classified data was successfuly deleted.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while deleting details :"+insertException.toString();
}
                   
        return result;
     
    }

public String getCrawledPageStatus(String id){
    String result="Not Classified";
            try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT classification.* FROM classification WHERE cid='"+id+"'");

while(rs.next()){
result=rs.getString("class");    
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
    return result;
}

}
