/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.Careercup;

/**
 *
 * @author SivaKrrish
 */
public class CareercupBean 
{
    
                private String PageNumber;
                private String Question ;
                private String Company_Name;
                private String QuestionID;
                private String ID;
    public String getPageNumber() 
        {
            return PageNumber;
        }

    public void setPageNumber(String sPageNumber) 
        {
            this.PageNumber = sPageNumber;
        }
    public void setQuestion( String sQuestion )
        {
            this.Question = sQuestion;  
        }
   
   public String getQuestion()
        {
            return Question;  
        }
    public void setCompany_Name(String sCompanyName)
        {
            this.Company_Name = sCompanyName;  
        }
   
    public String getCompany_Name()
        {
           return Company_Name;  
        }
    
    public void setQuestionID( String sQuestionID )
        {
           this.QuestionID = sQuestionID;  
        }
   
    public String getQuestionID()
        {
           return QuestionID;  
        }
    
    public void setID( String sID )
        {
          this.ID = sID;  
        }
   public String ID()
        {
          return ID;  
        }
    
}
