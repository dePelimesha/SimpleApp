import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = { "/engToRus"})
public class EngToRus extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        if (req.getParameter("translate") != null) {

            String engWord = "" + req.getParameter("eng");
            req.setAttribute("eng", engWord);
            String rusWord = "";
            Connection connection;

            try {
                connection = MySQLConnect.getMySQLConnection();
                rusWord = FindTranslate.getEngWordTranslate(connection, engWord);
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println(rusWord);

            req.setAttribute("rus", rusWord);
            req.getRequestDispatcher("engToRus.jsp").forward(req, resp);

        } else if (req.getParameter("rusButton") != null) {
            req.getRequestDispatcher("rusToEng.jsp").forward(req, resp);
        }

    }
}