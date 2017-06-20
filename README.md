# Careercup-Extraction
 Java web application using servlets, JSP and JavaBeans to extract programming interview questions from the CareerCup web site. We will use MySQL as our DBMS, and JDBC to execute the queries. The user interface is similar to the one below,


1.	design a database to store the questions extracted. For each question, you need to store: the content of the question, the unique ID assosiated with the question, and the company name that gives this question.
2.	In the user interface above, when a user enters a page number, say 7, and click the  button, your web application will request the page at URL:
http://www.careercup.com/page?n=7, and process the returned page.
3.	To process the returned HTML content, you need to study the structure of the source page, and use any method you like to extract the information from the page.
4.	It is not required to do page number validation. If a user enters something that is not a valid page number, you will use the URL: http://www.careercup.com/page
5.	Do not write the same question into the table more than once by checking its ID extracted from the page.
6.	After you write the questions into the database, you display the questions of the current page at the lower part of your user interface.
