import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = { "/rusToEng"})
public class RusToEng extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("translate") != null) {

            String rusWord = "" + req.getParameter("rus");
            req.setAttribute("rus", rusWord);
            String engWord = "";
            Connection connection;

            try {
                connection = MySQLConnect.getMySQLConnection();
                engWord = FindTranslate.getRusWordTranslate(connection, rusWord);
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            req.setAttribute("eng", engWord);
            req.getRequestDispatcher("rusToEng.jsp").forward(req, resp);

        } else if (req.getParameter("engButton") != null) {
            req.getRequestDispatcher("engToRus.jsp").forward(req, resp);
        }
    }
}