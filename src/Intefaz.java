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

public class Intefaz extends JFrame implements ActionListener {

 private JLabel titulo;
 private JLabel label1;
 private JButton botoninsertar;
 private JButton botonmodificar;
 private JButton botondesactivar;
 private JButton botoninsertarcampus;
 private JButton botonmostraract;
 private JButton botonmostraractcampus;
 private JButton botonsalir;

 public Intefaz(){
  setLayout(null);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  this.setTitle("Menú");
  Color colorF = new Color(55, 70, 91);
  Color colorT = new Color(114, 110, 255);
  Color colorL = new Color(90, 255, 231);
  Color colorB = new Color(46, 204, 113);
  Font fbtn = new Font("Arial", 1, 15);
  Font ftxt = new Font("Roboto", 3, 13);
  Font ftit = new Font("Calibri", 3, 30);
  Font flbl = new Font("Arial", 1, 20);
  this.getContentPane().setBackground(colorF);

  titulo = new JLabel("----Menu----");
  titulo.setBounds(250,5,500,50);
  titulo.setFont(ftit);
  titulo.setForeground(colorT);
  add(titulo);

  label1 = new JLabel("Selecciona la opcion que desees realizar");
  label1.setBounds(150,65,400,30);
  label1.setFont(flbl);
  label1.setForeground(colorL);
  add(label1);

  botoninsertar = new JButton("InsertarAlumno");
  botoninsertar.setBounds(30, 150, 200, 50);
  botoninsertar.setFont(fbtn);
  botoninsertar.setBackground(colorB);
  add(botoninsertar);
  botoninsertar.addActionListener(this);

  botonmodificar = new JButton("ModificarAlumno");
  botonmodificar.setBounds(300, 150, 200, 50);
  botonmodificar.setFont(fbtn);
  botonmodificar.setBackground(colorB);
  add(botonmodificar);
  botonmodificar.addActionListener(this);

  botondesactivar = new JButton("DesactivarAlumno");
  botondesactivar.setBounds(560, 150, 200, 50);
  botondesactivar.setFont(fbtn);
  botondesactivar.setBackground(colorB);
  add(botondesactivar);
  botondesactivar.addActionListener(this);

  botonmostraract = new JButton("MostrarActivos");
  botonmostraract.setBounds(350, 350, 200, 50);
  botonmostraract.setFont(fbtn);
  botonmostraract.setBackground(colorB);
  add(botonmostraract);
  botonmostraract.addActionListener(this);

  botonmostraractcampus = new JButton("MostrarAlumnos");
  botonmostraractcampus.setBounds(600, 350, 200, 50);
  botonmostraractcampus.setFont(fbtn);
  botonmostraractcampus.setBackground(colorB);
  add(botonmostraractcampus);
  botonmostraractcampus.addActionListener(this);

  botoninsertarcampus = new JButton("InsertarCampus");
  botoninsertarcampus.setBounds(100, 350, 200, 50);
  botoninsertarcampus.setFont(fbtn);
  botoninsertarcampus.setBackground(colorB);
  add(botoninsertarcampus);
  botoninsertarcampus.addActionListener(this);

 }

 @Override
 public void actionPerformed(ActionEvent e) {

    if (e.getSource() == botoninsertar) {
     InsertarAlumno interfaz = new InsertarAlumno();
     interfaz.setBounds(0,0,500,500);
     interfaz.setVisible(true);
     interfaz.setLocationRelativeTo(null);
    }
    if (e.getSource() == botonmodificar) {
     ModificarAlumno interfaz = new ModificarAlumno();
     interfaz.setBounds(0,0,500,500);
     interfaz.setVisible(true);
     interfaz.setLocationRelativeTo(null);
    }
    if (e.getSource() == botondesactivar) {
     DesactivarAlumno interfaz = new DesactivarAlumno();
     interfaz.setBounds(0,0,500,500);
     interfaz.setVisible(true);
     interfaz.setLocationRelativeTo(null);
    }
    if (e.getSource() == botonmostraract) {
     MostrarActivos interfaz = new MostrarActivos();
     interfaz.setBounds(0,0,700,500);
     interfaz.setVisible(true);
     interfaz.setLocationRelativeTo(null);
    }
    if (e.getSource() == botonmostraractcampus) {
     MostrarAlumCamp interfaz = new MostrarAlumCamp();
     interfaz.setBounds(0,0,600,800);
     interfaz.setVisible(true);
     interfaz.setLocationRelativeTo(null);
    }
    if (e.getSource() == botoninsertarcampus) {
     InsertarCampus interfaz = new InsertarCampus();
     interfaz.setBounds(0,0,500,500);
     interfaz.setVisible(true);
     interfaz.setLocationRelativeTo(null);
    }

 }

 public static void main(String[] args) {
     Intefaz interfaz = new Intefaz();
     interfaz.setBounds(0,0,1000,1000);
     interfaz.setVisible(true);
     interfaz.setLocationRelativeTo(null);

 }

}

