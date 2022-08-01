import javax.swing.*;
import java.lang.*;
import java.sql.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pembayaranternak
{
    static JFrame frame = new JFrame();
    static JLabel id_ternak = new JLabel("ID Ternak");
    static JLabel jenis_ternak = new JLabel("Jenis Ternak");
    static JLabel berat_ternak = new JLabel("Berat Ternak");
    static JLabel jenkel_ternak = new JLabel("JenKel Ternak");
    static JLabel harga_satuan = new JLabel("Harga Satuan");
    static JLabel banyak_ternak = new JLabel("Banyak Ternak");
    static JLabel harga_total = new JLabel("Harga Total");
    static JLabel kg = new JLabel("KG");
    static JLabel rp = new JLabel("Rp.");
    static JLabel rp2 = new JLabel("Rp.");
    
    static JTextField txtid_ternak = new JTextField();
    static JTextField txtjenis_ternak = new JTextField();
    static JTextField txtberat_ternak = new JTextField();
    static JTextField txtjenkel_ternak = new JTextField();
    static JTextField txtharga_satuan = new JTextField();
    static JTextField txtbanyak_ternak = new JTextField();
    static JTextField txtharga_total = new JTextField();
    
    static JButton btnhitung = new JButton("Hitung Harga Total");
    static JButton btnsimpan = new JButton("Simpan");
    static JButton btnreset = new JButton("Reset");
    
    static int count = 0;
    
    public static void main(String[] args)
    {
        panggil_pembayaran();
    }
    static void panggil_pembayaran()
    {
        Menu();
        Handler();
        Tampil();
        reset();
    }
    static void Tampil()
    {
        try
        {
            Connection koneksi = DriveManager.getConnection("jdbc:mysql://localhost/jualbeliternak_db","root","");
            ResultSet rs = koneksi.createStatement().executeQuery("select * from ternak_tb");
            while (rs.next())
            {
                int a = rs.getInt(1);
                txtid_ternak.setText(Integer.ToString(a+1));
                txtid_ternak.setEnabled(false);
            }
        }
        catch(SQLException ex)
        {
            
        }
    }
    static void reset()
    {
        txtjenis_ternak.setText("");
        txtberat_ternak.setText("");
        txtjenkel_ternak.setText("");
        txtharga_satuan.setText("");
        txtjenis_ternak.setText("");
        txtbanyak_ternak.setText("");
        txtharga_total.setText("");
    }
    static void Menu()
    {
        frame.setTitle("Program Pembayaran");
        frame.setSize(300,400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        txtharga_total.setEnabled(false);
        
        frame.add(id_ternak);
        frame.add(jenis_ternak);
        frame.add(berat_ternak);
        frame.add(jenkel_ternak);
        frame.add(harga_satuan);
        frame.add(banyak_ternak);
        frame.add(harga_total);
        frame.add(kg);
        frame.add(rp);
        frame.add(rp2);
        
        frame.add(txtid_ternak);
        frame.add(txtjenis_ternak);
        frame.add(txtberat_ternak);
        frame.add(txtjenkel_ternak);
        frame.add(txtharga_satuan);
        frame.add(txtbanyak_ternak);
        frame.add(txtharga_total);
        
        frame.add(btnhitung);
        frame.add(btnsimpan);
        frame.add(btnreset);
        
        id_ternak.setBounds(20,20,130,20);
        jenis_ternak.setBounds(20,50,130,20);
        berat_ternak.setBounds(20,80,130,20);
        jenkel_ternak.setBounds(20,110,130,20);
        harga_satuan.setBounds(20,140,130,20);
        banyak_ternak.setBounds(20,170,130,20);
        harga_total.setBounds(20,230,130,20);
        kg.setBounds(250,80,110,20);
        rp.setBounds(116,140,105,20);
        rp2.setBounds(116,230,105,20);
        
        txtid_ternak.setBounds(140,20,105,20);
        txtjenis_ternak.setBounds(140,50,105,20);
        txtberat_ternak.setBounds(140,80,105,20);
        txtjenkel_ternak.setBounds(140,110,105,20);
        txtharga_satuan.setBounds(140,140,105,20);
        txtbanyak_ternak.setBounds(140,170,105,20);
        txtharga_total.setBounds(140,230,105,20);
        
        btnhitung.setBounds(60,200,170,20);
        btnsimpan.setBounds(60,260,80,20);
        btnreset.setBounds(150,260,80,20);
    }
    static void Handler()
    {
        btnsimpan.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(txtid_ternak.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"ID Ternak masih kosong! \n"+"Silahkan diisi terlebih dahulu! \n");
                    txtid_ternak.requestFocus();
                }
                else if(txtjenis_ternak.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Jenis Ternak masih kosong! \n"+"Silahkan diisi terlebih dahulu! \n");
                    txtjenis_ternak.requestFocus();
                }
                else if(txtberat_ternak.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Berat Ternak masih kosong! \n"+"Silahkan diisi terlebih dahulu! \n");
                    txtberat_ternak.requestFocus();
                }
                else if(txtjenkel_ternak.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Jenis Kelamin Ternak masih kosong! \n"+"Silahkan diisi terlebih dahulu! \n");
                    txtjenkel_ternak.requestFocus();
                }
                else if(txtharga_satuan.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Harga Satuan masih kosong! \n"+"Silahkan diisi terlebih dahulu! \n");
                    txtharga_satuan.requestFocus();
                }
                else if(txtbanyak_ternak.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Banyak Ternak masih kosong! \n"+"Silahkan diisi terlebih dahulu! \n");
                    txtbanyak_ternak.requestFocus();
                }
                else if(txtharga_total.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Harga Total masih kosong! \n"+"Silahkan HITUNG terlebih dahulu! \n");
                    txtharga_total.requestFocus();
                }
                else
                {
                    try
                    {
                        Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/jualbeliternak_db","root","");
                        koneksi.createStatement().executeUpdate("Insert ternak_tb values "+"('"+txtid_ternak.getText()+"','"+txtjenis_ternak.getText()+"','"+txtberat_ternak.getText()+"','"+txtjenkel_ternak.getText()+"','"+txtharga_satuan.getText()+"')");
                        JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
                        reset();
                        Tampil();
                        txtjenis_ternak.requestFocus();
                    }
                    catch(SQLException ex)
                    {
                        System.out.println("Data Gagal Disimpan"+ex.getMessage());
                    }
                }
            }
        });
        btnreset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/jualbeliternak_db","root","");
                    koneksi.createStatement().executeUpdate("Delete from ternak_tb where "+"('"+txtid_ternak.getText()+"')");
                    JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
                    reset();
                    Tampil();
                    txtjenis_ternak.requestFocus();
                }
                catch(Exception ez)
                {
                    System.out.println("Data Gagal Dihapus"+ez.getMessage());
                }
            }
        });
        btnhitung.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                double a = Double.parseDouble(txtharga_satuan.getText());
                double b = Double.parseDouble(txtbanyak_ternak.getText());
                
                double hasil = (a+b);
                String total =Double.toString(hasil);
                txtharga_total.setText(total);
            }
        });
    }
}