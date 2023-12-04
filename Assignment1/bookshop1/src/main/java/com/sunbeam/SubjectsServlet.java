package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/subjects")
public class SubjectsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Subjects</title>");
		out.println("</head>");
		out.println("<body>");
		
		// get app.title from context param and display it
		ServletContext ctx = req.getServletContext();
		String appTitle = ctx.getInitParameter("app.title");
		out.println("<h3>" + appTitle + "</h3>");
		
		// retrieve name cookie from client and display Hello message
		String userName = "";
		/*
		Cookie[] arr = req.getCookies();
		if(arr != null) {
			for (Cookie c : arr) {
				if(c.getName().equals("uname")) {
					userName = c.getValue();
					break;
				}
			}
		}
		*/
		// retrieve name from session and display Hello message
		HttpSession session = req.getSession();
		userName = (String) session.getAttribute("uname");
		out.printf("Hello, %s <hr/>\n", userName);
		
		try(BookDao bookDao = new BookDao()) {
			List<String> list = bookDao.getSubjects();
			out.println("<form method='post' action='books'>");
			for (String subject : list) {
				out.printf("<input type='radio' name='subject' value='%s'/> %s<br/>\n", 
						subject, subject);
			}
			out.println("<input type='submit' value='Show Books'/>");
			out.println("<a href='cart'>Show Cart</a>");
			out.println("</form>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}




