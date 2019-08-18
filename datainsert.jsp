<%-- 
    Document   : datainsert
    Created on : Apr 6, 2018, 5:39:51 PM
    Author     : Suraj
--%>

<%@page import="java.sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        PreparedStatement pst,pst1;
        ResultSet rs;
        
        try{
                   
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/Medical", "root", "root@123");
      
                   

            String TOD = request.getParameter("td");
            String First_name = request.getParameter("fn");
            String Last_name = request.getParameter("ln");           
            String Gender= request.getParameter("gender");
            String Phone_no=request.getParameter("phno");
            String DOB = request.getParameter("dob");
            String marital= request.getParameter("Mstatus");
            String Address= request.getParameter("address");
            String City= request.getParameter("city");
            String State= request.getParameter("state");
            String Zipcode= request.getParameter("zip");
            String Country= request.getParameter("country");
            String insurance= request.getParameter("insurance");         
            String RFirst_name = request.getParameter("rfn");
            String RLast_name = request.getParameter("rln");
            String RPhone_no=request.getParameter("rphno");
            String RAddress= request.getParameter("raddress");
            
           
           
          
            
            
        
          
            

            
            
            pst = con.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,TOD);
            pst.setString(2 ,First_name);
            pst.setString(3,Last_name);
            pst.setString(4,Gender);
            pst.setString(5,Phone_no);
            pst.setString(6,DOB);
            pst.setString(7,marital);
            pst.setString(8,Address);
            pst.setString(9,City);
            pst.setString(10,State);
            pst.setString(11,Zipcode);
            pst.setString(12,Country);
            pst.setString(13,insurance);
            pst.executeUpdate();
             pst1= con.prepareStatement("insert into rpatients values(?,?,?,?)");
            pst1.setString(1 ,RFirst_name);
            pst1.setString(2,RLast_name);
            pst1.setString(3,RPhone_no);
            pst1.setString(4,RAddress);
            pst1.executeUpdate();
            
            
            
            
            
            
            

              //  pw.print("<h2>Data Insertion Successfully<h2>");
            response.sendRedirect("inserted.html");
  
                    
            
            
           

            
        }
        catch(Exception e)
        {
            out.print("<h2>Error<h2>"+e);
        }
        
        
        
        
        
        
        
        
        
        %>
    </body>
</html>
