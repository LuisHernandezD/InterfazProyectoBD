import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarAlumno extends JFrame implements ActionListener {
    private JLabel titulo;
    private JLabel label1;
    private JLabel label2;
    private JTextField nombre;
    private JTextField campusid;
    private JButton boton;

    public InsertarAlumno() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Insertar Alumno");
        Color colorF = new Color(55, 70, 91);
        Color colorT = new Color(114, 110, 255);
        Color colorL = new Color(90, 255, 231);
        Color colorB = new Color(46, 204, 113);
        Font fbtn = new Font("Arial", 1, 15);
        Font ftxt = new Font("Roboto", 3, 13);
        Font ftit = new Font("Calibri", 3, 20);
        Font flbl = new Font("Arial", 1, 13);
        this.getContentPane().setBackground(colorF);

        titulo = new JLabel("Insertar Alumno");
        titulo.setBounds(130, 5, 500, 50);
        titulo.setFont(ftit);
        titulo.setForeground(colorT);
        add(titulo);

        label1 = new JLabel("Escribe el nombre");
        label1.setBounds(15, 65, 400, 30);
        label1.setFont(flbl);
        label1.setForeground(colorL);
        add(label1);

        nombre = new JTextField();
        nombre.setBounds(190, 70, 130,30);
        add(nombre);

        label2 = new JLabel("Escribe el # de campus");
        label2.setBounds(15, 125, 400, 30);
        label2.setFont(flbl);
        label2.setForeground(colorL);
        add(label2);

        campusid = new JTextField();
        campusid.setBounds(190, 130, 130,30);
        add(campusid);

        boton = new JButton("Insertar");
        boton.setBounds(120, 200, 130, 30);
        boton.setFont(fbtn);
        boton.setBackground(colorB);
        add(boton);
        boton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton) {
            try {
                Insertar();
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void Insertar() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://DESKTOP-NT1UVST\\BDATOS:1433;databaseName=BDminiproyect;user=usuarioSQL;password=fitz;";
        Connection con = DriverManager.getConnection(connectionURL);
        System.out.println("Nos conectamos");

        String name = String.valueOf(nombre.getText());
        int camp = Integer.parseInt(campusid.getText());
        Statement instruccion = con.createStatement();
        instruccion.execute("exec dbo.alumnosInsertar" + name + "," + camp + "");
        JOptionPane.showMessageDialog(this, "Alumno Agregado");

    }


}
