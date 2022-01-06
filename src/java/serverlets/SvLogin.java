
package serverlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

    
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
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        Controladora control = new Controladora();
        
        boolean autorizado = control.verificarUsuario(user, pass);
        
        if(autorizado == true){
            HttpSession miSession = request.getSession(true);
            miSession.setAttribute("user", user);
            miSession.setAttribute("pass", pass);
            
            response.sendRedirect("main.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
