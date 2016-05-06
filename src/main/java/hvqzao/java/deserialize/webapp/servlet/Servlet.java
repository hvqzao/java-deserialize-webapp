package hvqzao.java.deserialize.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hvqzao.java.deserialize.webapp.api.Serial;

@WebServlet(name = "MyServlet", urlPatterns = { "" })
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = -1251837460515874243L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletOutputStream out = resp.getOutputStream();
		out.write("<!DOCTYPE html>".getBytes());
		out.write("<html>\n".getBytes());
		out.write("<body>\n".getBytes());
		out.write("<p><a href=\"classpath.jsp\">classpath</a></p>\n".getBytes());
		String data = req.getParameter("data");
		if (data == null) {
			data = Serial.toBase64(new String("text"));
		} else {
			out.write("<p>Deserializing...".getBytes());
			try {
				Serial.fromBase64(data);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			out.write("Done!</p>\n".getBytes());
		}
		out.write("<form action=\"/\" method=\"POST\">\n".getBytes());
		out.write(String.valueOf("<p><textarea type=\"text\" name=\"data\">"+data+"</textarea></p>\n").getBytes());
		out.write("<p><input type=\"submit\"></p>\n".getBytes());
		out.write("</form>\n".getBytes());
		out.write("</body>\n".getBytes());
		out.write("</html>\n".getBytes());
		out.flush();
		out.close();
		
	}

}
