<%-- 
    Document   : done.jsp
    Created on : 19/12/2021, 17:39:06
    Author     : ivanc
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            
            HttpSession miSesion=request.getSession(); 
            //String clienteNombre = (String) miSesion.getAttribute("clienteNombre"); 
            String clienteABorrar = (String) miSesion.getAttribute("clienteABorrar"); 
            
            
  
        %>
        
        <h1>Agregado</h1>
        
        
        <p><%=clienteABorrar%></p>
        

        
        
        
        
        <a href="main.jsp">Volver</a>
    </body>
</html>
