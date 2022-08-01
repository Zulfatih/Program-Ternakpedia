import javax.swing.*;
import java.lang.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class menuternak extends JFrame
{

    static JFrame frame = new JFrame();
    static JLabel judul = new JLabel("MENU UTAMA");
    static JButton btninput = new JButton("Input Data");
    static JButton btnLihat = new JButton("Lihat Tabel Ternak");
    
    public static void main(String[]args)
    {
        frame.setTitle("Menu Ternak");
        frame.setSize(300,400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);
        
        frame.add(judul);
        frame.add(btninput);
        frame.add(btnLihat);
        judul.setBounds(0,10,300,10);
        btninput.setBounds(83,40,120,40);
        btnLihat.setBounds(83,90,120,40);
        
        
        btninput.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                pembayaranternak.panggil_pembayaran();
            }
        });
        btnLihat.addActionListener(new ActionListener()
        
        {
            public void actionPerformed(ActionEvent e)
            {
                tabelternak.panggil();
            }
        });
        
    }
}

