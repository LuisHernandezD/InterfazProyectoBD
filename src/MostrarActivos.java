import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarActivos extends JFrame implements ActionListener {
    private JLabel titulo;
    private JLabel label1;
    private JButton boton;
    private JTextArea mostrar;
    private final static String newline = "\n";

    public MostrarActivos() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Mostrar Alumnos Activos");
        Color colorF = new Color(55, 70, 91);
        Color colorT = new Color(114, 110, 255);
        Color colorL = new Color(90, 255, 231);
        Color colorB = new Color(46, 204, 113);
        Font fbtn = new Font("Arial", 1, 15);
        Font ftxt = new Font("Roboto", 3, 14);
        Font ftit = new Font("Calibri", 3, 20);
        Font flbl = new Font("Arial", 1, 13);
        this.getContentPane().setBackground(colorF);

        titulo = new JLabel("Mostrar Alumnos Activos");
        titulo.setBounds(130, 5, 500, 50);
        titulo.setFont(ftit);
        titulo.setForeground(colorT);
        add(titulo);

        label1 = new JLabel("Presiona el boton para mostrarlos");
        label1.setBounds(15, 65, 400, 30);
        label1.setFont(flbl);
        label1.setForeground(colorL);
        add(label1);

        boton = new JButton("Mostrar");
        boton.setBounds(120, 105, 130, 30);
        boton.setFont(fbtn);
        boton.setBackground(colorB);
        add(boton);
        boton.addActionListener(this);

        mostrar = new JTextArea();
        mostrar.setEditable(false);
        mostrar.setFont(ftxt);
        mostrar.setBounds(40, 180, 600, 500);
        add(mostrar);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton) {
            try {
                MostrarActivoss();
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void MostrarActivoss() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://DESKTOP-NT1UVST\\BDATOS:1433;databaseName=BDminiproyect;user=usuarioSQL;password=fitz;";
        Connection con = DriverManager.getConnection(connectionURL);
        System.out.println("Nos conectamos");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("exec dbo.alumnosMosAct");

        while (rs.next()) {
            int ID = rs.getInt(1);
            String Nombre = rs.getString(2);
            int campus = rs.getInt(3);
            String fecha = rs.getString(4);
            String estatus = rs.getString(5);
            mostrar.append("  ID= " + ID + " | Nombre: " + Nombre + " | Campus: " + campus + " | Fecha: " + fecha + " | Estatus: " + estatus + newline);

        }
        JOptionPane.showMessageDialog(this, "Mostrado");
    }

}
