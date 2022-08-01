import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class koneksiternak
{
    public static Connection con;
    public static Statement stm;
    public static void main(String[] args)
    {
        try
        {
            String url = ("jdbc:mysql://localhost/jualbeliternak_db");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Berhasil");
        }
        catch(Exception e)
        {
            System.out.println("Koneksi Gagal"+e.getMessage()); 
        }
    }
}
