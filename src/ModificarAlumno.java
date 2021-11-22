import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ModificarAlumno extends JFrame implements ActionListener {
    private JLabel titulo;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField id;
    private JTextField nombre;
    private JTextField camp;
    private JTextField estat;
    private JButton boton;

    public ModificarAlumno() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Modificar Alumno");
        Color colorF = new Color(55, 70, 91);
        Color colorT = new Color(114, 110, 255);
        Color colorL = new Color(90, 255, 231);
        Color colorB = new Color(46, 204, 113);
        Font fbtn = new Font("Arial", 1, 15);
        Font ftxt = new Font("Roboto", 3, 13);
        Font ftit = new Font("Calibri", 3, 15);
        Font flbl = new Font("Arial", 1, 13);
        this.getContentPane().setBackground(colorF);

        titulo = new JLabel("Modificar Alumno");
        titulo.setBounds(130, 5, 500, 50);
        titulo.setFont(ftit);
        titulo.setForeground(colorT);
        add(titulo);

        label1 = new JLabel("Escribe el ID del alumno a modificar");
        label1.setBounds(15, 65, 400, 30);
        label1.setFont(flbl);
        label1.setForeground(colorL);
        add(label1);

        id = new JTextField();
        id.setBounds(300, 70, 130,30);
        add(id);

        label2 = new JLabel("Escribe el nombre del alumno modificado");
        label2.setBounds(15, 125, 400, 30);
        label2.setFont(flbl);
        label2.setForeground(colorL);
        add(label2);

        nombre = new JTextField();
        nombre.setBounds(300, 130, 130,30);
        add(nombre);


        label3 = new JLabel("Escribe el # del campus");
        label3.setBounds(15, 185, 400, 30);
        label3.setFont(flbl);
        label3.setForeground(colorL);
        add(label3);

        camp = new JTextField();
        camp.setBounds(300, 190, 130,30);
        add(camp);

        label4 = new JLabel("Escribe el estatus con un 0 y 1");
        label4.setBounds(15, 245, 400, 30);
        label4.setFont(flbl);
        label4.setForeground(colorL);
        add(label4);

        estat = new JTextField();
        estat.setBounds(300, 250, 130,30);
        add(estat);

        boton = new JButton("Modificar");
        boton.setBounds(120, 300, 130, 30);
        boton.setFont(fbtn);
        boton.setBackground(colorB);
        add(boton);
        boton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton) {
            try {
                Modificar();
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void Modificar() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://DESKTOP-NT1UVST\\BDATOS:1433;databaseName=BDminiproyect;user=usuarioSQL;password=fitz;";
        Connection con = DriverManager.getConnection(connectionURL);
        System.out.println("Nos conectamos");

        int ID = Integer.parseInt(id.getText());
        String name = String.valueOf(nombre.getText());
        int campus = Integer.parseInt(camp.getText());
        int estatus = Integer.parseInt(estat.getText());
        Statement mod = con.createStatement();
        mod.execute("exec dbo.alumnosModificar " + ID + "," + name + "," + campus + "," + estatus + "");
        JOptionPane.showMessageDialog(this, "Alumno con el ID: " + ID + " modificado");
    }

}
