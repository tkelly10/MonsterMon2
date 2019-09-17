import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")

public class SearchServlet extends javax.servlet.http.HttpServlet {
    private final String USER = "tyler";
    private final String PW = "tyler";
    private final String DRIVER = "jdbc:derby:";
    private final String DB_PATH = "WEB-INF/lib/dbdemo";


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rset = null;

        try{
           Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

           String path = getServletContext().getRealPath(DB_PATH);

           conn = DriverManager.getConnection(DRIVER + path, USER, PW);

           pstmt = conn.prepareStatement("SELECT cardID FROM cards WHERE name = ?");

           String searchTerm = request.getParameter("searchTerm");

           pstmt.setString(1, searchTerm);

           rset = pstmt.executeQuery();

           StringBuilder html = new StringBuilder("<html><body>");

           while(rset.next()){
               int id = rset.getInt("CardID");
               html.append("<p>").append(id).append("</p>");

           }

           html.append("</body></html>");
           response.getWriter().print(html.toString());


       }catch (ClassNotFoundException | SQLException e){
           response.getWriter().print(e.getMessage());
       }
        finally {
            if(rset != null) {
                try {
                    rset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
