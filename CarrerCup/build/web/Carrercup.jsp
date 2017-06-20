<%-- 
    Document   : Carrercup
    Created on : 25 Oct, 2014, 2:35:58 PM
    Author     : SivaKrrish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         
    </head>
    <body>
        <form action="View_Data.jsp" onsubmit="return myFunction()" >
            
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
                    <td style="height: 450px">
                        <table align = 'center' border='1' cellpadding='6' cellspacing='2' style="width:700px;min-height: 700px">
          <tbody>
                <tr>
                <td style="font-size:20px">Enter CarrerCup Page Number</td>

                <td> <input id = "pgn" type = "text"  name = "pagenumber" /> </td>
                </tr>
                <tr>
                        <td colspan = "2" style="text-align: center">
                       <input type = "submit" style="height: 30px;font-size: 15px"  value = "Submit" />
                        </td>
                </tr>
                        </tbody>
             </table>
                </td>
                </tr>
            </table>
             
                        <br/>
             
                        <div style="background-color: burlywood;height: 30px;width:100%;text-align: center">
                            <i > Copyright  2014 </i>
                        </div>
        </form>
    </body>
</html>
