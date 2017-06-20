/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.Careercup;
import java.sql.*;
import java.util.*;
import java.net.*;

public class CareerData 
{          
    private Connection connection;
    private PreparedStatement getRecords;
    
    public CareerData() throws Exception 
    {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/careercup","root", "");      
    }
    
    public List<CareercupBean> getCareercupBean(String pagenumber) throws SQLException 
    {
        getRecords = connection.prepareStatement("SELECT PageNumber, Id, Question FROM careercup_questions where PageNumber = "+ pagenumber);
        List<CareercupBean> guestList = new ArrayList<CareercupBean>();
        // obtain list  of Id of Question,Company Name,Question,PageNumber from DataBase
        ResultSet rs = getRecords.executeQuery();
        // get row data
        while (rs.next()) 
        {
            CareercupBean bean = new CareercupBean();
            bean.setPageNumber(rs.getString("PageNumber"));
            bean.setQuestionID(rs.getString("Id"));
            bean.setQuestion(rs.getString("Question"));			
            guestList.add(bean);
        }
        return guestList;
    }
    
    public void ParseData(String PageNo)
    { 
        try
        {         
        String QuestionID ="";
        String CompanyName ="";
        String Question ="";
        String urlName = "http://www.careercup.com/page?n="+PageNo;
        URL url = new URL(urlName);
        URLConnection connection = url.openConnection();
        connection.connect();
        Scanner in = new Scanner(connection.getInputStream());
        while (in.hasNextLine()) 
        {
            Scanner h = in;  
            String str= in.nextLine();
            if(str.contains("alt="))
             {
                 // Extracting Company Name
                if(!str.contains("alt=\"Follow\""))
                  {                     
                    String s = str.substring(str.indexOf("alt"));     
                    try
                    {
                      CompanyName=str.substring(str.indexOf("alt")+5,str.indexOf("alt")+s.indexOf("-"));
                    }
                     catch(Exception ex)
                    {
                        CompanyName = "No Company";// If there is no company name in carrer cup i am returning my own name
                    }
                 }
             }
            if(str.contains("<span class=\"entry\">"))
                { 
                    String line1 = in.nextLine();
                    String line = in.nextLine();

                    // Extracting Questions
                if(line.contains("<a href=\"/question?id="))
                    { 
                        //IN This LOOP EXTRACTING Questions FROM CAREER CUP 
                        QuestionID= (line.substring(line.indexOf("?id=")+4, line.indexOf("?id=")+20));
                        String MultiLineQuestion = "";
                        if(line.contains("</p>"))
                            {                       // Extracting  single Line Questions
                                String singleLineQuestion = line.substring(line.indexOf("<p>")+3,line.indexOf("</p>"));
                                Question=(singleLineQuestion);
                            }
                        else
                            {           // Extracting Questions with Multiple LIne
                                MultiLineQuestion = MultiLineQuestion+   line.substring(line.indexOf("<p>")+3,line.length());
                            }
                        if(!line.contains("</a>"))
                            {                                                          
                                while (in.hasNextLine())
                                    {
                                    String l = in.nextLine();
                                    if(l.contains("</a>"))
                                        {                                                                     
                                            MultiLineQuestion = MultiLineQuestion+ l.substring(0,l.indexOf("</a>"));
                                            Question = (MultiLineQuestion);
                                            MultiLineQuestion="";
                                            break;
                                        }
                                            MultiLineQuestion=  MultiLineQuestion +l;                                           
                                    }
                            }
                    }   
                try
                   {
                        InsertCareerCup(QuestionID,PageNo,Question,CompanyName);
                   }
               catch( SQLException es)
                   {

                   }
                }
        }
        }
        catch(Exception e)
        {

        }
    }
    //DataBase Insertion of Id of Question,Company Name,Question,PageNumber
    public int InsertCareerCup(String QuestionID, String pageNumber, String Question, String CompanyName)  throws SQLException
    {
        PreparedStatement prepStatement = connection.prepareStatement("INSERT INTO  careercup_questions(Id,Company_Name,Question,PageNumber) VALUES(?,?,?,?)");
        String Id = QuestionID;
        String PageNumber = pageNumber;
        String Company_Name = CompanyName;
        prepStatement.setString(1, Id);
        prepStatement.setString(2, Company_Name);
        prepStatement.setString(3, Question);
        prepStatement.setString(4, PageNumber);
        return prepStatement.executeUpdate();
    }
        
}
