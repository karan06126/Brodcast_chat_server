package cookieexample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname= request.getParameter("uname");
		String pword=request.getParameter("password");
		PrintWriter out=response.getWriter();
		
		if(pword.equals("abc123")){
			
			Cookie cookie=new Cookie("uname",uname);
			response.addCookie(cookie);
			/*HttpSession session=request.getSession(true);
			session.setAttribute("uname", uname);*/
			RequestDispatcher rs= request.getRequestDispatcher("link.html");
			rs.include(request, response);
			
		}
		else
		{
			out.println("sorry username or password is wrong");
			RequestDispatcher rs= request.getRequestDispatcher("");
			rs.include(request, response);
		}
		
		
	}

}
