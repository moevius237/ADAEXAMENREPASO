import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    final static String url ="jdbc:mysql://localhost:3306/mydb?user=root&password=admin";

    public static void main(String[] args) {
        Prestamo prestamoi [] = new Prestamo[0];
    }
    public static void metodoDeLaMuerte(Map<Integer, Prestamo[ ]> mapa){
        String existe = "SELECT * FROM libro WHERE id = ?";
        String prestamo = "INSERT INTO prestamo (usuario,fecha_prestamo,fecha_devolucion,ejemplar_id) VALUES(?,?,?,?)";
        String insertarLibro = "UPDATE ejemplar set estado=?  WHERE libro_id =?";
        try (final Connection con = DriverManager.getConnection(url)){
            con.setAutoCommit(false);
            try (PreparedStatement prsele = con.prepareStatement(existe);
                PreparedStatement prins = con.prepareStatement(insertarLibro);
                PreparedStatement prest = con.prepareStatement(prestamo)){
                for(Map.Entry<Integer, Prestamo[ ]> entrada: mapa.entrySet()){
                    prsele.setInt(1,entrada.getKey());
                    ResultSet rs = prsele.executeQuery();
                    if (rs.next()){
                        prins.setString(1,"NUEVO");
                        prins.setInt(2,entrada.getKey());
                        prins.executeQuery();
                        con.commit();
                        Prestamo [] prestamos = entrada.getValue();
                        for (int i = 0; i < prestamos.length; i++) {
                            if (prestamos[i].getFechaPrestamo().isBefore(LocalDateTime.now()) && prestamos[i].getFechaDevolucion().isAfter(LocalDateTime.now())){
                                prest.setString(1,prestamos[i].getUauario());
                                prest.setTimestamp(2,Timestamp.valueOf(String.valueOf(prestamos[i].getFechaPrestamo())));
                                prest.setTimestamp(3,Timestamp.valueOf(String.valueOf(prestamos[i].getFechaDevolucion())));
                                prest.setInt(4,prestamos[i].getEjemplarID());
                                prest.executeQuery();
                            }
                        }
                    }
                }
                con.commit();
            }catch (SQLException e){
                con.rollback();
            }finally {
                con.setAutoCommit(true);
            }
        }catch (SQLException e){
            System.out.println("ERROR EN LA CONEXION");
        }
    }
    public static void printFavoriteBooks(int idLibro){
        try (final Connection con = DriverManager.getConnection(url)){
            String selleeec = "SELECT l.titulo, COUNT(p.titulo)as cantidad_prestada FROM libro l JOIN ejemplar e ON e.libro_id = l.id FULL JOIN Prestamo p ON l.ejemplar_id = p.id WHERE l.id = ? GROUP BY l p.ejemplar_id HAVING COUNT(p.id) >0";
            con.setAutoCommit(false);
                try (PreparedStatement prss = con.prepareStatement(selleeec)){
                    prss.setInt(1,idLibro);
                    ResultSet rs = prss.executeQuery();
                    while (rs.next()){
                        System.out.println(rs.getString("titulo"));
                        System.out.println(rs.getInt("cantidad_prestada"));
                    }
                    con.commit();
                }catch (SQLException e){
                    con.rollback();
                }
            con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("FALLO LA CONEXIOOON");
        }

    }

}