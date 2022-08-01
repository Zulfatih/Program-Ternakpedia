import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class tabelternak
{
    public static void main(String[] visual)
    {
        panggil();
    }
    static void panggil()
    {
        JFrame jp = new JFrame("Tabel Jual Beli Ternak");
        JTable tabel = new JTable();
        JScrollPane sp =new JScrollPane(tabel);
        
        Connection konek;
        Statement pernyataan;
        ResultSet hasil;
        
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Ternak");
        tbl.addColumn("Jenis Ternak");
        tbl.addColumn("Berat Ternak");
        tbl.addColumn("Jenkel Ternak");
        tbl.addColumn("Harga PerEkor");
        
        tabel.setModel(tbl);
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            konek = DriverManager.getConnection("jdbc:mysql://localhost/jualbeliternak_db","root","");
            pernyataan = konek.createStatement();
            
            hasil = pernyataan.executeQuery("select * from ternak_tb");
            while(hasil.next())
            {
                tbl.addRow(new Object[]
                {
                    hasil.getString("id_ternak"),
                    hasil.getString("jenis_ternak"),
                    hasil.getString("berat_ternak"),
                    hasil.getString("jenkel_ternak"),
                    hasil.getString("harga_satuan"),
                });
            }
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
        jp.add(sp);
        jp.setLocation(300,200);
        jp.setSize(800,400);
        jp.setVisible(true);
    }
}
