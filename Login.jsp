

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
          try {
              
            
            String user = request.getParameter("Username");
            String pass = request.getParameter("Password");
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/Medical", "root", "root@123");
      
         
            PreparedStatement pst = con.prepareStatement("select * from Users where username=? and Password=?");
            pst.setString(1, user);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                response.sendRedirect("sample.html");
            } 
            else {
                
                 out.print("Sorry user not valid");
        
            }

        } catch (Exception ex) {
           out.print("ERRor" + ex);
        }
        %>
    </body>
</html>
