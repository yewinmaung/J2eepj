package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import model.CourseAccess;
/**
 * Servlet implementation class DeleteCategoryServlet
 */
@WebServlet("/DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  int classid= Integer.parseInt(request.getParameter("classid"));
		  CourseAccess ca=new CourseAccess();
		  try {
		
			ca.DeleteClass(classid);
			System.out.println("Delete Aung");
			RequestDispatcher rd = request.getRequestDispatcher("");
			try {
				List<Category> list = ca.showClass();
	         
				if (list.size() > 0) {
					request.setAttribute("catlist", list);
					//request.setAttribute("catlist", catlist);
					rd = request.getRequestDispatcher("admin/categorylist.jsp");
					rd.forward(request, response);
				} else {
					response.setContentType("text/html");
					rd=request.getRequestDispatcher("admin/categorylist.jsp");
					request.setAttribute("noCourse","error");
					rd.include(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.setContentType("text/html");
			rd = request.getRequestDispatcher("admin/categorylist.jsp");
			rd.forward(request, response);
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
