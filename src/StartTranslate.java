import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/start"})
public class StartTranslate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("rusButton") != null) {
            req.getRequestDispatcher("rusToEng.jsp").forward(req, resp);
        } else if (req.getParameter("engButton") != null) {
            req.getRequestDispatcher("engToRus.jsp").forward(req, resp);
        }
    }
}
