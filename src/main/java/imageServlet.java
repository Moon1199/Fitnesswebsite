


import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class imageServlet
 */
@WebServlet("/imageServlet")
public class imageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource (lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		try (Connection con = ds.getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT bild FROM übungen WHERE id= ?") ){
		pstmt.setString(1, id);
		try(ResultSet rs=pstmt.executeQuery()){
			if(rs!=null && rs.next()) {
				Blob image= rs.getBlob("bild");
				response.reset();
				long length = image.length();
				response.setHeader("Content-Length", String.valueOf(length));
				
				try(InputStream in= image.getBinaryStream();) {
					final int bufferSize= 256;
					byte[] buffer= new byte[bufferSize];
					
					ServletOutputStream out = response.getOutputStream();
					while ((length = in.read(buffer)) != -1) {
						out.write(buffer,0,(int) length);	
					}	
					out.flush();
				}
			}
		}
		
	} catch (Exception ex) {
		// TODO Auto-generated catch block
		throw new ServletException(ex.getMessage());
	}
	}

}
