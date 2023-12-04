package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addbook")
public class AddBookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext ctx = req.getServletContext();
		String c = (String) ctx.getInitParameter("color");

		System.out.println(c);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Book</title>");
		out.println("</head>");
		out.printf("<body bgcolor='%s'>", c);

		// get app.title from context param and display it

		// retrieve name from session and display Hello message
		HttpSession session = req.getSession();
		String userName = (String) session.getAttribute("uname");
		out.printf("Hello, %s <hr/>\n", userName);

		out.println("<form method='post' action='addbook'>");
		out.printf("Id: <input type='text' name='id' /> <br/><br/>\n");
		out.printf("Name: <input type='text' name='name' /><br/><br/>\n");
		out.printf("Author: <input type='text' name='author' /><br/><br/>\n");
		out.printf("Subject: <input type='text' name='subject'/><br/><br/>\n");
		out.printf("Price: <input type='text' name='price' /><br/><br/>\n");
		out.println("<input type='submit' value='Add Book'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookId = req.getParameter("id");
		int id = Integer.parseInt(bookId);
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		String subject = req.getParameter("subject");
		String priceStr = req.getParameter("price");
		double price = Double.parseDouble(priceStr);
		Book b = new Book(id, name, author, subject, price);
		int count = 0;
		try (BookDao bookDao = new BookDao()) {
			count = bookDao.save(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("message", "Books Added: " + count);
		RequestDispatcher rd = req.getRequestDispatcher("booklist");
		rd.forward(req, resp);
	}
}