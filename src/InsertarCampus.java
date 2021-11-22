import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarCampus extends JFrame implements ActionListener {
    private JLabel titulo;
    private JLabel label1;
    private JTextField nombre;
    private JButton boton;

    public InsertarCampus(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Insertar Campus");
        Color colorF = new Color(55, 70, 91);
        Color colorT = new Color(114, 110, 255);
        Color colorL = new Color(90, 255, 231);
        Color colorB = new Color(46, 204, 113);
        Font fbtn = new Font("Arial", 1, 15);
        Font ftxt = new Font("Roboto", 3, 13);
        Font ftit = new Font("Calibri", 3, 20);
        Font flbl = new Font("Arial", 1, 13);
        this.getContentPane().setBackground(colorF);

        titulo = new JLabel("Insertar Campus");
        titulo.setBounds(130, 5, 500, 50);
        titulo.setFont(ftit);
        titulo.setForeground(colorT);
        add(titulo);

        label1 = new JLabel("Escribe el nombre del Campus a insertar");
        label1.setBounds(15, 65, 400, 30);
        label1.setFont(flbl);
        label1.setForeground(colorL);
        add(label1);

        nombre = new JTextField();
        nombre.setBounds(290, 70, 150,30);
        add(nombre);

        boton = new JButton("Insertar");
        boton.setBounds(120, 150, 130, 30);
        boton.setFont(fbtn);
        boton.setBackground(colorB);
        add(boton);
        boton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton) {
            try {
                InsertarCampuss();
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void InsertarCampuss() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://DESKTOP-NT1UVST\\BDATOS:1433;databaseName=BDminiproyect;user=usuarioSQL;password=fitz;";
        Connection con = DriverManager.getConnection(connectionURL);
        System.out.println("Nos conectamos");

        String ncampus = String.valueOf(nombre.getText());
        Statement ingcamp = con.createStatement();
        ingcamp.execute("exec dbo.campusInsertar" + ncampus + "");
        JOptionPane.showMessageDialog(this, "Campus Agregado");


    }

}
