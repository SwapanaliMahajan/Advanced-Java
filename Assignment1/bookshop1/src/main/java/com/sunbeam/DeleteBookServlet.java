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

@WebServlet("/deletebook")
public class DeleteBookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String bookId = req.getParameter("id");
		int id = Integer.parseInt(bookId);
		int count = 0;
		try (BookDao bookDao = new BookDao()) {
			count = bookDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("message", "Books Deleted: " + count);
		RequestDispatcher rd = req.getRequestDispatcher("booklist");
		rd.forward(req, resp);
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
