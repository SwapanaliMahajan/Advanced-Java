package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signout")
public class SignoutServlet extends HttpServlet {
protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
resp.setContentType("text/html");
PrintWriter out=resp.getWriter();
out.println("<html>");
out.println("<head>");
out.println("<title>Sign Outr</title>");
out.println("</head>");
out.println("<body>");
// get app.title from context param and display it
ServletContext ctx = req.getServletContext();
String appTitle = ctx.getInitParameter("app.title");
out.println("<h3>" + appTitle + "</h3>");
String color = ctx.getInitParameter("color");
out.printf("<body bgcolor='%s'>\r\n", color);

out.println("<h1>Thank you</h1>");
out.printf("<a href='index.html'>Login again</a>");
out.println("</body>");
out.println("</html>");
}
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
doGet(req, resp);
}
}