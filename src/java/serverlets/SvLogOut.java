
package serverlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvLogOut", urlPatterns = {"/SvLogOut"})
public class SvLogOut extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession miSesion=request.getSession(); 
        
        miSesion.setAttribute("user", "");
        miSesion.setAttribute("pass", "");
        
        miSesion.invalidate();
        
        response.sendRedirect("index.jsp");
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
