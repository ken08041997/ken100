package ken.action;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ken.model.UserTemp;
import ken.userDAO.userDAO;
import ken.utilities.MailSender;

/**
 * Servlet implementation class Forgot
 * @param <HttpServletResponse>
 */
@WebServlet("/Forgot")
public class Forgot<HttpServletResponse> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		Random rand = new Random();

		// Obtain a number between [0 - 49].
		int n = rand.nextInt(50);
		MailSender.send(email, "code reset pass", String.valueOf(n));
		request.setAttribute("email", email);
		request.setAttribute("code", String.valueOf(n));System.out.println(n);
		String nextJSP = "/jsp/changepass.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,(ServletResponse) response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
