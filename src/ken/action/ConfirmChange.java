package ken.action;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ken.model.User;
import ken.model.UserTemp;
import ken.userDAO.userDAO;
/**
 * Servlet implementation class ConfirmChange
 */
@WebServlet("/ConfirmChange")
public class ConfirmChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");System.out.println(email);
		String confirmCode = request.getParameter("confirm");
		String password = request.getParameter("password");
		String code = request.getParameter("code");System.out.println(code);
		if (confirmCode.equals(code)) {System.out.println("trung khop code");
			for (UserTemp user : userDAO.getListTemp()) { {
				if (email.equals(user.getEmail())) {
					if (user.equals(user.getCode())) {
						userDAO.getListUser().add(new User(user.getFname(),user.getLname(),user.getEmail(),user.getNumber(),user.getPassword()));
						userDAO.getListTemp().remove(user);System.out.println(userDAO.getListUser());
						String url="/WEB-INF/jsp/success.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
						dispatcher.forward(request,response);
						break;
					}
			}
		}
		
	}

		}
		}
	}
