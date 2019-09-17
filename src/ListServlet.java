import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ListServlet",
        urlPatterns = "/list")
public class ListServlet extends HttpServlet {


    private final String PATH = "/WEB-INF/lib/dbdemo";
    private final String USER = "tyler";
    private final String PW = "tyler";
    private final String DRIVER = "jdbc:derby:";



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        ResultSet rest = null;
        Statement stmt = null;

        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String path = getServletContext().getRealPath(PATH);

            conn = DriverManager.getConnection(DRIVER + path, USER, PW);

            stmt = conn.createStatement();

            rest = stmt.executeQuery("SELECT CardID, Name from Cards");

            StringBuilder html = new StringBuilder("<html><body>");

            while (rest.next()){
                int id = rest.getInt("CardID");
                String name = rest.getString(2);
                html.append("<p>").append(id).append(",").append(name).append("</p>");
            }

            html.append("</body></html>");

            response.getWriter().print(html.toString());

        }catch (SQLException | ClassNotFoundException ex){
            response.getWriter().print(ex.getMessage());
            ex.printStackTrace();
        }
        finally {
            if(rest != null) {
                try {
                    rest.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null) {
                try {
                    stmt.close();
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
