package ru.firstproject.servlet;


import ru.firstproject.model.UsersDataSet;
import ru.firstproject.model.UsersDataSetDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/allusers")
public class AllUsersServlet extends HttpServlet{
	//private UserService service = UserServiceImpl.getInstance();

	public AllUsersServlet() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<UsersDataSet> users = null;
        try {
            users = new UsersDataSetDaoImpl().getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }


		request.setAttribute("users", users);

		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/allusers.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		String newUserName = request.getParameter("name");
		String newUserLogin = request.getParameter("login");
		String newUserPassword = request.getParameter("password");
		UsersDataSet newUser = new UsersDataSet(-1, newUserName, newUserLogin, newUserPassword);
        System.out.println(newUser.toString());
        try {
            new UsersDataSetDaoImpl().saveUser(newUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/allusers");
	}

}
