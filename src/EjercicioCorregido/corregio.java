package EjercicioCorregido;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class corregio {
    final static String url ="jdbc:mysql://localhost:3306/mydb?user=root&password=admin";

    public static void ProccesBoakLoan(Map<Integer, Prestamo> prestamoMap){
        try (Connection conn = DriverManager.getConnection(url)){

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
