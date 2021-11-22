import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DesactivarAlumno extends JFrame implements ActionListener {
    private JLabel titulo;
    private JLabel label1;
    private JTextField text;
    private JButton boton;

    public DesactivarAlumno() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Desactivar Alumno");
        Color colorF = new Color(55, 70, 91);
        Color colorT = new Color(114, 110, 255);
        Color colorL = new Color(90, 255, 231);
        Color colorB = new Color(46, 204, 113);
        Font fbtn = new Font("Arial", 1, 15);
        Font ftxt = new Font("Roboto", 3, 13);
        Font ftit = new Font("Calibri", 3, 20);
        Font flbl = new Font("Arial", 1, 13);
        this.getContentPane().setBackground(colorF);

        titulo = new JLabel("Desactivar Alumno");
        titulo.setBounds(130, 5, 500, 50);
        titulo.setFont(ftit);
        titulo.setForeground(colorT);
        add(titulo);

        label1 = new JLabel("Escribe el ID del Alumno a desactivar");
        label1.setBounds(15, 65, 400, 30);
        label1.setFont(flbl);
        label1.setForeground(colorL);
        add(label1);

        text = new JTextField();
        text.setBounds(270, 70, 50,30);
        add(text);

        boton = new JButton("Desactivar");
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
                DesactivarAlm();
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void DesactivarAlm() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://DESKTOP-NT1UVST\\BDATOS:1433;databaseName=BDminiproyect;user=usuarioSQL;password=fitz;";
        Connection con = DriverManager.getConnection(connectionURL);
        System.out.println("Nos conectamos");

        int id = Integer.parseInt(text.getText());
        Statement des = con.createStatement();
        des.execute("exec dbo.alumnosDesAlum " + id + "");
        JOptionPane.showMessageDialog(this, "Alumno con el ID " + id + " desactivado");
    }


}
