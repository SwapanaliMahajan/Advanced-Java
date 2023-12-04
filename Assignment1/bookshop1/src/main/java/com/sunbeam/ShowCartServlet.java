package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart")
public class ShowCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ArrayList<Integer> cart = (ArrayList<Integer>) session.getAttribute("cart");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cart</title>");
		out.println("</head>");
		out.println("<body>");

		// retrieve name from session and display Hello message
		String userName = (String) session.getAttribute("uname");
		out.printf("Hello, %s <hr/>\n", userName);

		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<th>Name</th>");
		out.println("<th>Author</th>");
		out.println("<th>Subject</th>");
		out.println("<th>Price</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		double totalPrice = 0;
		try (BookDao bookdao = new BookDao()) {
			
			for (int id : cart) {

				Book result = bookdao.findById(id);
				out.println("<tr>");
				// TODO Show full book information
				out.printf("<td>%d</td>\n", id);
				out.printf("<td>%s</td>\n",result.getName());
				out.printf("<td>%s</td>\n",result.getAuthor());
				out.printf("<td>%s</td>\n",result.getSubject());
				out.printf("<td>%.2f</td>\n",result.getPrice());
				out.println("</tr>");
				totalPrice += result.getPrice();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.println("</tbody>");
		out.println("</table>");

		// TODO Show total book price
		out.println("<a href='subjects'>Subjects</a>");
		// TODO Show Checkout hyperlink href='#'
		
		out.printf("<h3>Totalprice:%.2f</h3>",totalPrice);
		out.println("<a href='logout'>Sign Out</a>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}