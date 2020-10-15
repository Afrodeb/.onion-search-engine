package models;


import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;
import helpers.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author debmeister
 */
public class varwere {
    public String register(String name,String email,String password){
        String result="false";
                try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO clients(id,name,email,password) VALUES(NULL,'"+name+"','"+email+"','"+password+"');"
);
result="Client registered successfully";
}else{
    result="connection yakatsva";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
        return result;
}
    
    public String post(String post,String username){
        String result="false";
                try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO forum(post,username) VALUES('"+post+"','"+username+"');"
);
result="Post submitted successfully";
}else{
    result="connection yakatsva";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
        return result;
}    
    
        public String clientupdate(String id,String name,String email,String password){
        String result="false";
                try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"UPDATE clients SET name='"+name+"',email='"+email+"',password='"+password+"' WHERE id='"+id+"';"
);
result="Client updated successfully";
}else{
    result="connection yakatsva";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
        return result;
    }
    
public ArrayList search(String search){
   ArrayList results=new ArrayList();
   
           try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT * " +
"FROM content " +
" WHERE MATCH(page) AGAINST('"+search+"');");

while(rs.next()){
ArrayList result=new ArrayList();
result.add(rs.getString("page"));
result.add(rs.getString("page_name"));
result.add(rs.getString("description"));
result.add(rs.getString("id"));
results.add(result);
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//results.add("Error while getting details :"+insertException.toString());
}
   
   return results;
}
        
        
public String updatetraining(String id,String name,String set){
String result="false";
                try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"UPDATE training SET name='"+name+"',_set='"+set+"' WHERE id='"+id+"';"
);
result="Set updated successfully";
}else{
    result="connection yakatsva";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
        return result;
    }
        
        
        public String registerDoc(String name,String email,String password,String location){
        String result="false";
                try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO users(id,name,email,password) VALUES(NULL,'"+name+"','"+email+"','"+password+"');"
);
result="true";
}else{
    result="connection yakatsva";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
        return result;
    }
        
    
public ArrayList login(String email,String password){
      ArrayList result=new ArrayList();
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery(""
        + "SELECT clients.* FROM clients "
        + "WHERE (email='"+email+"' "
        + "AND "
        + "password='"+password+"') "
        + "OR (name='"+email+"'"
        + "AND password='"+password+"')");
while(rs.next()){
result.add(rs.getString("name"));
result.add(rs.getString("email"));
result.add(rs.getString("password"));
result.add(rs.getString("id"));
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
result.add("Error while getting details :"+insertException.toString());
}
                
        return result;
        
    }

public ArrayList loginDoc(String email,String password){
      ArrayList result=new ArrayList();
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT users.* FROM users WHERE email='"+email+"' AND password='"+password+"'");
while(rs.next()){
result.add(rs.getString("name"));
result.add(rs.getString("email"));
//result.add(rs.getString("location"));
result.add(rs.getString("id"));
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
result.add("Error while getting details :"+insertException.toString());
}
                
        return result;
        
    }

public ArrayList forums(){
     
      ArrayList users=new ArrayList();
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT * FROM forum");
while(rs.next()){
ArrayList result=new ArrayList();
result.add(rs.getString("id"));
result.add(rs.getString("post"));
result.add(rs.getString("username"));
result.add(rs.getString("created"));
users.add(result);
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
                
        return users;
        
    }



public ArrayList clients(){
     
      ArrayList users=new ArrayList();
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT * FROM clients");
while(rs.next()){
ArrayList result=new ArrayList();
result.add(rs.getString("id"));
result.add(rs.getString("name"));
result.add(rs.getString("email"));
result.add(rs.getString("created"));
users.add(result);
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
                
        return users;
        
    }


public ArrayList getclient(String id){
     
      ArrayList users=new ArrayList();
      ArrayList result=new ArrayList();
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT * FROM clients WHERE id='"+id+"'");
while(rs.next()){
result.add(rs.getString("id"));
result.add(rs.getString("name"));
result.add(rs.getString("email"));
result.add(rs.getString("created"));
result.add(rs.getString("password"));
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
                
        return result;
        
    }


public ArrayList admins(){
      ArrayList result=new ArrayList();
      ArrayList users=new ArrayList();
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT * FROM users");
while(rs.next()){
result.add(rs.getString("name"));
result.add(rs.getString("email"));
//result.add(rs.getString("location"));
result.add(rs.getString("created"));
users.add(result);
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
result.add("Error while getting details :"+insertException.toString());
}
                
        return users;
        
    }
    public int getQstn(String qtsn){
     int size=0;
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT questions.* FROM questions WHERE text='"+qtsn+"'");

while(rs.next()){
size++;
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
                
        return size;
        
    }
    
    
    
    
    
     public ArrayList getWebsites(){
     int size=0;
     ArrayList result= new ArrayList();
    
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT websites.* FROM websites");

while(rs.next()){
ArrayList website= new ArrayList();    
website.add(rs.getString("id"));
website.add(rs.getString("url"));
website.add(rs.getString("created"));
result.add(website);
//website.add(rs.getString(""));
    
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
                
        return result;
        
    }   
    

public ArrayList getMinedContent(){
     int size=0;
     ArrayList result= new ArrayList<ArrayList>();
    
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT content.*,websites.* FROM content,websites WHERE content.wid=websites.id");

while(rs.next()){
ArrayList website= new ArrayList<String>();    
website.add(rs.getString("id"));
website.add(rs.getString("page"));
website.add(rs.getString("page_name"));
website.add(rs.getString("description"));
website.add(rs.getString("keywords"));
website.add(rs.getString("url"));
//website.add(rs.getString(""));
result.add(website);
//website.add(rs.getString(""));
    
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
                
        return result;
        
    }
     
     
public String addQuestion(String question){
String result="";
if(this.getQstn(question) == 0){
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO questions VALUES(NULL,NULL,'"+question+"');"
);
result="question was successfuly added.Do not forget possible answer fo this question";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
}        
        return result;
     
    }

public String addWebsite(String url){
String result="";
if(!this.getWebsite(url).equals("0")){
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO websites(url,profile) VALUES('"+url+"','');"
);
result="Url was successfuly added.Do not forget to scrap this link";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
}        
        return result;
     
}

public String updateScrapped(String url,String id){
String result="";
if(!this.getWebsite(url).equals("0")){
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"UPDATE content SET page='"+url+"' WHERE id='"+id+"';"
);
result="Content was successfuly updated.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
}        
        return result;
     
}

public String updateWebsite(String url,String id){
String result="";
if(!this.getWebsite(url).equals("0")){
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"UPDATE websites SET url='"+url+"' WHERE id='"+id+"';"
);
result="Url was successfuly updated.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
}        
        return result;
     
}


public String deleteClient(String id){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"DELETE FROM clients WHERE id='"+id+"';"
);
result="Client was successfuly deleted.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while deleting details :"+insertException.toString();
}
                   
        return result;
     
    }

public String deleteTraining(String id){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"DELETE FROM training WHERE id='"+id+"';"
);
result="Set was successfuly deleted.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
                   
        return result;
     
    }

public String deleteWebsite(String id){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"DELETE FROM websites WHERE id='"+id+"';"
);
result="Url was successfuly deleted.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
                   
        return result;
     
    }

public String getWebPage(String url){
    String result="";
    try{
  UserAgent userAgent = new UserAgent();                       //create new userAgent (headless browser).
  userAgent.visit(url);                        //visit a url  
  result=userAgent.doc.innerHTML();
}
catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
  System.err.println(e);
}
    return result;
}

public String crawl(String id){
 String result="";
 String link="";
 ArrayList website=getWebsiteById(id);//get http url
 //System.out.print(website);
 String url=(String)website.get(0);
 //=new ArrayList(); //get all links on http url
 //System.out.println(url);
 ArrayList linkss=this.links(url);
 linkss.add(url);
 System.out.print(linkss);
 ArrayList content=new ArrayList();
 int c=linkss.size();
 for(int x=0; x< c; x++){
 //addLinks((String)links.get(x),id);
 link=(String)linkss.get(x);
 //if((!link.contains(url)) || (!link.contains("http"))  || (!link.contains("https"))){
 //link =url+"/"+link;
 //}
  addWebContent(getBodyContent(getWebPage(link)),id,link);
 String title=link;
 String description="";
// addWebContent(getWebPage(link),id,link);
 }
 
 //getWebPage(String url)*/
 return "Website crawling done";
}

public ArrayList getCrawled(String id){
    ArrayList result=new ArrayList();
            try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT content.* FROM content WHERE wid='"+id+"'");

while(rs.next()){
ArrayList website= new ArrayList();    
website.add(rs.getString("id"));
website.add(rs.getString("page"));
website.add(rs.getString("page_name"));
result.add(website);
//website.add(rs.getString(""));
    
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
    return result;
}

public ArrayList getScrappedPage(String id){
    ArrayList result=new ArrayList();
    ArrayList website= new ArrayList();  
            try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT content.* FROM content WHERE id='"+id+"'");

while(rs.next()){
  
website.add(rs.getString("id"));
website.add(rs.getString("page"));
website.add(rs.getString("page_name"));
website.add(rs.getString("wid"));
//website.add(rs.getString(""));
    
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
    return website;
}


public ArrayList links(String url){
ArrayList result=new ArrayList();
try{    
UserAgent userAgent = new UserAgent();  
userAgent.visit(url);       //visit website    
Elements links = userAgent.doc.findEvery("<a>");   //find search result links
for(Element link : links){
result.add(link.getAt("href")); 
}
}catch(Exception e){
//}catch(JauntException e){
 System.err.println(e);
}
return result;
}

public String getBodyContent(String code){
String result="";
    try{
  UserAgent userAgent = new UserAgent();   //open HTML from a String.
  userAgent.openContent(code);
  Element body = userAgent.doc.findFirst("<body>");
  Element div = body.findFirst("<div>");
  result= body.innerText();  //join all text within body element
//result=body.get;
    }
catch(JauntException e){                         
  System.err.println(e);         
}
    return result;
}

public String getTitle(String code){
String result="";
    try{
  UserAgent userAgent = new UserAgent();   //open HTML from a String.
  userAgent.openContent(code);
  Element title = userAgent.doc.findFirst("<title>");
  //result= body.innerText();  //join all text within body element
result=title.innerText();
    }
catch(JauntException e){                         
  System.err.println(e);         
}
    return result;
}

public String getDescription(String code){
String result="";
    try{
  UserAgent userAgent = new UserAgent();   //open HTML from a String.
  userAgent.openContent(code);
 Element meta = userAgent.doc.findFirst("<head>").findFirst("<meta>"); 
result=meta.getAt("content");
    }
catch(JauntException e){                         
  System.err.println(e);         
}
    return result;
}

public String addWebContent(String text,String id,String name){
    String result="";
            try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO content(page,page_name,wid) VALUES('"+text+"','"+name+"','"+id+"');"
);
result="content was successfuly added.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
    return result;
}


public void addLinks(String link,String wid){
   String result="";
   String type="internal";
   if(link.contains("http://")){
       type="external";
   }
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO links(url,wid,type) VALUES('"+link+"','"+wid+"','"+type+"');"
);
result="link was successfuly added.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
       
        
 
}

public String sendMessage(String id,String to,String message){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO messages VALUES(NULL,'"+to+"','"+id+"','"+message+"',NULL);"
);
result="question was successfuly added.Do not forget possible answer fo this question";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
       
        return result;
     
    }


public String training(String name,String set){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO training(name,_set) VALUES('"+name+"','"+set+"');"
);
result="training statement was successfuly added.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
       
        return result;
     
    }

public ArrayList getTraining(String id){
    ArrayList result=new ArrayList();
    ArrayList website= new ArrayList();  
            try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT training.* FROM training WHERE id='"+id+"'");

while(rs.next()){  
website.add(rs.getString("id"));
website.add(rs.getString("name"));
website.add(rs.getString("_set"));
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
    return website;
     
    }


     public ArrayList getStopwords(){
     int size=0;
     ArrayList result= new ArrayList();
    
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT stopwords.* FROM stopwords");

while(rs.next()){
ArrayList website= new ArrayList();    
website.add(rs.getString("id"));
website.add(rs.getString("word"));
website.add(rs.getString("created"));
result.add(website);
//website.add(rs.getString(""));
    
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
                
        return result;
        
    }

 
          public ArrayList getTraining(){
     int size=0;
     ArrayList result= new ArrayList();
    
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT training.* FROM training");

while(rs.next()){
ArrayList website= new ArrayList();    
website.add(rs.getString("id"));
website.add(rs.getString("name"));
website.add(rs.getString("_set"));
result.add(website);
//website.add(rs.getString(""));
    
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
                
        return result;
        
    }
     
     
     public String deleteScrapped(String id){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"DELETE FROM content WHERE id='"+id+"';"
);
result="Content was successfuly deleted.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
                   
        return result;
     
    }
     
public String deleteWord(String id){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"DELETE FROM stopwords WHERE id='"+id+"';"
);
result="Word was successfuly deleted.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
                   
        return result;
     
    }


public ArrayList questions(){
      ArrayList result=new ArrayList();
      ArrayList questions=new ArrayList();
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM questions");
while(rs.next()){
result.add(rs.getString("text"));
result.add(rs.getString("id"));
result.add(rs.getString("created"));
}
questions.add(result);
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
result.add("Error while getting details :"+insertException.toString());
}
                
        return questions;
        
}

public String deleteQuetion(String id){
    String result="We failed to delete that item.";  
    try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
statement = conn.createStatement();
statement.execute("DELETE FROM questions WHERE id='"+id+"'");
result="Question was successfully deleted.";
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
result="Error while getting details :"+insertException.toString();
}
return result;
}

public String getWebsite(String id){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM websites WHERE url='"+id+"'");
while(rs.next()){
result =rs.getString("url");
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result="Error while getting details :"+insertException.toString();
result="0";
}
                
return result;
        
}

public ArrayList getWebsiteById(String id){
ArrayList result=new ArrayList();
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM websites WHERE id='"+id+"'");
while(rs.next()){
result.add(rs.getString("url"));
result.add(rs.getString("id"));
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result="Error while getting details :"+insertException.toString();
result=null;
}
                
return result;
        
}

public String getQuestion(String id){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM questions WHERE id='"+id+"'");
while(rs.next()){
result =rs.getString("text");
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
result="Error while getting details :"+insertException.toString();
}
                
return result;
        
}


public ArrayList getQnA(String id){
ArrayList result=new ArrayList();
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM qna WHERE qid='"+id+"'");
while(rs.next()){
result.add(rs.getString("aid"));
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
result.add("Error while getting details :"+insertException.toString());
}
                
return result;
        
}

public String getQnAByID(String id){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM qna WHERE qid='"+id+"'");
while(rs.next()){
result=rs.getString("aid");
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
result="1";
}
                
return result;
        
}

public String getAnswer(String id){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM responses WHERE id='"+id+"'");
while(rs.next()){
result =rs.getString("text");
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
result="Error while getting details :"+insertException.toString();
}
                
return result;
        
}

public String addAnswer(String question,String qid){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
String query="INSERT INTO responses VALUES(NULL,'"+question+"',NULL);";
    Statement statement=conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
    int aid;
    aid = statement.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
ResultSet rs=statement.getGeneratedKeys();
if(rs.next()){
int z =1;
z= statement.executeUpdate(
"INSERT INTO qna VALUES(NULL,'"+qid+"','"+Integer.toString(rs.getInt(1))+"');"
);    
}
result="Answer successfully added.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
        
        return result;
        
    }

public String clientQuestion(String que){
     String id="1";
     ArrayList ids=new ArrayList();
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT text,id,MATCH(text) AGAINST('"+que+"' IN BOOLEAN MODE)AS score FROM questions ORDER BY score DESC LIMIT 1");
//ResultSet rs = statement.executeQuery("SELECT * FROM questions WHERE MATCH(text) AGAINST('"+que+"' IN BOOLEAN MODE) ORDER BY MATCH(text) AGAINST('"+que+"') DESC LIMIT 1");

    while(rs.next()){
id=rs.getString("id");
ids.add(id);
}
//id=(String)ids.get(ids.size()-1);
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
id="1";
}
 
return id;
        
}

public String getIceBreaker(){
String result="Tell me a bit about your self.";
ArrayList ices=new ArrayList();
Random rand=new Random();       
try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM icebreakers");
while(rs.next()){
result =rs.getString("text");
ices.add(result);
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
result="Error while getting details :"+insertException.toString();
}
if(ices.size() > 0){
int x=rand.nextInt((Integer)ices.size());//lets get a rndom ice breaker
result=(String)ices.get(0);
}
return result;
        
}


public String addIce(String question){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO icebreakers VALUES(NULL,'"+question+"',NULL);"
);
result="question was successfuly added.Do not forget possible answer fo this question";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
        
        return result;
        
    }

public String addSuicideWord(String word,String score){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO suicide VALUES(NULL,'"+word+"',NULL,'"+score+"');"
);
result="question was successfuly added.Do not forget possible answer fo this question";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
        
        return result;
        
    }
public ArrayList getSuicideWords(){
ArrayList result=new ArrayList();  
ArrayList sender=new ArrayList();
ArrayList score=new ArrayList();
try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM suicide");
while(rs.next()){
result.add(rs.getString("word"));//add comma delimeted suicidal words
score.add(rs.getString("score"));
sender.add(result);
sender.add(score);
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
result.add("Error while getting details :"+insertException.toString());
}
return sender;
        
}

public ArrayList getAllSuicideWords(){
ArrayList result=new ArrayList();
ArrayList ices=new ArrayList();     
try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM suicide");
while(rs.next()){
result.add(rs.getString("word"));//add comma delimeted suicidal words
result.add(rs.getString("created"));
ices.add(result);
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result="Error while getting details :"+insertException.toString();
}
return ices;        
}

public ArrayList getDrInLocation(String location){
ArrayList result=new ArrayList();
ArrayList ices=new ArrayList();     
try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM counsillor WHERE location='"+location+"'");
while(rs.next()){
result.add(rs.getString("name"));//add comma delimeted suicidal words
result.add(rs.getString("email"));
result.add(rs.getString("id"));
ices.add(result);
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result="Error while getting details :"+insertException.toString();
}
return ices;        
}





    public String setNotification(String text,String id){
String result="";
        /*try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"INSERT INTO notifications VALUES(NULL,'"+id+"',NULL,'"+text+"');"
);
result="User was successfuly added.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while inserting System details :"+insertException.toString();
}
           
        */
        return result;
        
    }
  
    
      public ArrayList getNotifications(String id){
      ArrayList choices=new ArrayList();
   /*     try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

ResultSet rs = statement.executeQuery("SELECT * FROM notifications WHERE cid='"+id+"'");
while(rs.next()){
choices.add(rs.getString("text")+"-"+rs.getString("created"));
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}*/
                
        return choices;
        
    }
      
    public String addAllMessages(ArrayList messages,String id){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
int size=messages.size();
for(int x=0;x<size;x++){
if(messages.get(x).toString().indexOf("You") == -1){    
int i = statement.executeUpdate(
"INSERT INTO messages VALUES(NULL,'"+id+"','system','"+(String)messages.get(x)+"',NULL);"
);    
}else{
int i = statement.executeUpdate(
"INSERT INTO messages VALUES(NULL,'system','"+id+"','"+messages.get(x)+"',NULL);"
);
}
}
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
    
          public ArrayList getMessages(String id){
      ArrayList choices=new ArrayList();      
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM messages WHERE mto='"+id+"' OR mfrom='"+id+"' ORDER BY id DESC");
//ResultSet rs = statement.executeQuery("SELECT * FROM messages ORDER BY id DESC");
    while(rs.next()){
    choices.add(rs.getString("text"));
}
}
} catch(SQLException insertException) {
choices.add("Error while getting users :"+insertException.toString());
}
                
        return choices;
        
    }
          
           public ArrayList getMessage(){
      ArrayList choices=new ArrayList();      
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM messages");
while(rs.next()){
    choices.add(rs.getString("text"));
}
}
} catch(SQLException insertException) {
choices.add("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
                
        return choices;
        
    }
          
public ArrayList getPatient(String id){
ArrayList choices=new ArrayList();
try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM patient WHERE id='"+id+"'");
while(rs.next()){
choices.add(rs.getString("name"));
choices.add(rs.getString("location"));
choices.add(rs.getString("email"));
choices.add(rs.getString("created"));
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
                
        return choices;
        
    }

public ArrayList getSystem(){
ArrayList choices=new ArrayList();
try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM system WHERE id='1'");
while(rs.next()){
choices.add(rs.getString("name"));
choices.add(rs.getString("file_path"));
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
                
        return choices;    
  }    

public ArrayList categories(){
 ArrayList cats=new ArrayList();
try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();
ResultSet rs = statement.executeQuery("SELECT * FROM training GROUP BY name");
while(rs.next()){
cats.add(rs.getString("name"));
}
}
} catch(SQLException insertException) {
System.out.println("Error while getting users :"+insertException.toString());
//result.add("Error while getting details :"+insertException.toString());
}
                
        return cats;     
}

public String deleteScrappedByWeb(String id){
String result="";
        try {
Connector connector=new Connector();
Connection conn=connector.connect();
if(conn != null){
Statement statement;
    statement = conn.createStatement();

int i = statement.executeUpdate(
"DELETE FROM content WHERE wid='"+id+"';"
);
result="Client was successfuly deleted.";
}else{
    result="null";
}
} catch(SQLException insertException) {
System.out.println("Error while inserting System details :"+insertException.toString());
result="Error while deleting details :"+insertException.toString();
}
                   
        return result;
     
    }


}
