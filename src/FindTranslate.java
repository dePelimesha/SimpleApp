import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindTranslate {

    public static String getRusWordTranslate (Connection conn, String rusWord)
        throws SQLException {

        String sqlRequest = "Select engWord from Translate where rusWord =?";
        String engWord = "";

        PreparedStatement pstm = conn.prepareStatement(sqlRequest);
        pstm.setString(1, rusWord);

        ResultSet reqResult = pstm.executeQuery();
        while (reqResult.next()) {
            engWord = reqResult.getString(1);
        }
        if (engWord.isEmpty()) {
            engWord = "No such word";
        }

        return engWord;
    }

    public static String getEngWordTranslate (Connection conn, String engWord)
            throws SQLException {

        String rusWord = "";
        String sqlRequest = "Select rusWord from Translate where engWord=?";

        PreparedStatement pstm = conn.prepareStatement(sqlRequest);
        pstm.setString(1, engWord);

        ResultSet reqResult = pstm.executeQuery();
        while (reqResult.next()) {
             rusWord = reqResult.getString(1);
        }
        if (rusWord.isEmpty()) {
            rusWord = "No such word";
        }

        return rusWord;
    }
}
