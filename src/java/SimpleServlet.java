import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A simple servlet that forwards to a JSP page with basic information
 */
@WebServlet(name = "SimpleServlet", urlPatterns = {"/SimpleServlet"})
public class SimpleServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get current time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = now.format(formatter);
        
        // Create a simple message
        String message = "Hello from SimpleServlet GET method!";
        
        // Set attributes in the request object
        request.setAttribute("message", message);
        request.setAttribute("currentTime", formattedTime);
        
        // Log to console for debugging
        System.out.println("SimpleServlet: Setting message attribute: " + message);
        System.out.println("SimpleServlet: Setting currentTime attribute: " + formattedTime);
        
        // Forward the request to the JSP page
        request.getRequestDispatcher("/JSP/Simple.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // For this example, simply redirect to the GET method
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Simple Servlet that forwards to a JSP page";
    }
}
