<%-- 
    Document   : View_Data
    Created on : 25 Oct, 2014, 2:45:40 PM
    Author     : SivaKrrish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import = "java.util.*" %>
<%@ page import = "Com.Careercup.*" %>

<jsp:useBean id = "CareerData" scope = "request" 
   class = "Com.Careercup.CareerData" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            td{
                font-family: CALIBRI;
            }
        </style>
     
    </head>
    <body>
        <form action = "View_Data.jsp" onsubmit="return myFunction()">
            <script type="text/javascript">
                function myFunction()
                    {
                
                        var pgn1 = parseInt(document.getElementById("pgn").value);
                         if(isNaN(pgn1)) 
                    {                
                        window.location.href="http://www.careercup.com";    
                        return false;
                    }
                    else
                        {
                              return true;
                        }
                    }
            
            </script>
        <table style="width:100%">
                <tr>
                    <td>
                        <div style="background-color: burlywood;height: 100px;width:100%;text-align: center;padding-top: 5px;padding-bottom: 5px">
                            <i style="font-size: 25px;font-weight: bold" >  Extract Programming Interview Questions from CareerCup </i>
                         <br/>
                        <div style="float:right;padding-right:10px;padding-bottom:15px "><i > 5010 Project 1 <br/> Submitted By : P Siva Rama Krishna </i><br/><i > Student ID : 18137255 </i>
                            </div>
                    </td>
                </tr>
                <tr>
                    <td style="height: 440px">
         <table align = 'center'  cellpadding='6' cellspacing='2' style="width:900px">
                <tbody>
                     <tr>
                            <td style="font-size:20px">Enter CarrerCup Page Number</td>

                            <td> <input id = "pgn" type = "text" name = "pagenumber" /> </td>
                    </tr>
                    <tr>
                            <td colspan = "2" style="text-align: center">
                               <input type = "submit" style="height: 30px;font-size: 15px" onclick="myFunction()" value = "Submit" />
                            </td>
                    </tr>
                 </tbody>
             </table>
              <table align = 'center' border='1' cellpadding='6' cellspacing='2' style="width:900px">
                <thead>
                    <tr>
                        <th>Carrer Cup Page Number </th>
                        <th> Question ID</th>
                        <th> Question </th>
                    </tr>
                </thead>
                    <tbody>
                            <% // start scriptlet'
                                    CareerData.ParseData(request.getParameter("pagenumber"));
                                    List<CareercupBean> List = CareerData.getCareercupBean(request.getParameter("pagenumber"));
                                    Iterator li = List.iterator();
                                    CareercupBean bean;
                                    while ( li.hasNext() ) 
                                        {
                                            bean = ( CareercupBean) li.next();
                            %>
                    <tr>
                        <td><%= bean.getPageNumber()%></td>
                        <td><%= bean.getQuestionID()%></td>
                        <td><%= bean.getQuestion()%></td>
                    </tr>
                  
               
                            <% // continue scriptlet
                                 } // end while
                            %> <%-- end scriptlet --%>
         </tbody>
      </table>
                    </td>
                </tr>
         </table>
                        <div style="background-color: burlywood;height: 30px;width:100%;text-align: center">
                         <i > Copyright  2014 </i>
                        </div>
         </form>
   </body>

</html>

