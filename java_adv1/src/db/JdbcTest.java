package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
    public static void main(String[] args) {
        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "root";
        String password = "cloud1234";

        try{
            DriverManager.getConnection(url, username, password);

            conn.setAutoCommit(false);

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO accounts (id, balance) VALUES (1, 1000)");
            stmt.executeUpdate("UPDATE accounts SET balance = balance - 100 WHERE id = 1");

            // 작업이 성공하면 커밋
            conn.commit();
        }catch (SQLException e){
            if(conn != null){
                try{
                    conn.rollback();
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if(conn != null){
                try{
                    conn.close();
                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}
