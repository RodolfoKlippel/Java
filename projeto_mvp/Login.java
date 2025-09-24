/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_mvp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

/**
 *
 * @author Dono do Computador
 */
public class Login extends JFrame implements ActionListener{
    
    JButton botao;
    JTextField[] texto;
    JPanel panel;
    
    Login(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400, 800);
        this.setLayout(null);
        
//        ImageIcon icon = new ImageIcon("E:\\Pasta Usuário SO\\Downloads\\especialista-ou-generalista.jpg");
//        
//        JLabel label = new JLabel();
//        label.setIcon(icon);
//        label.setBounds(-450, 0, 1250, 800);
        
        
        panel = new JPanel();
//        panel.setPreferredSize(new Dimension(700,700));
        panel.setLayout(null);
        panel.setBackground(Color.white);
        panel.setBounds(700, 100, 700, 700);
        
        texto = new JTextField[2];
        
        for(int i=0; i<2; i++){
            texto[i] = new JTextField();
            
            texto[i].setBounds(200, 200+(85*i), 300, 50);
            texto[i].setBorder(BorderFactory.createLineBorder(Color.black, 2,true));
            texto[i].setFont(new Font("Arial",Font.PLAIN,25));
            
            panel.add(texto[i]);
        }
        
        botao = new JButton("Entrar");
        
        botao.setBounds(300, 370, 100, 50);
        botao.setFont(new Font("Arial",Font.PLAIN,25));
        botao.setBorder(BorderFactory.createLineBorder(Color.black, 2,true));
        botao.addActionListener(this);
        botao.setFocusable(false);
        botao.setBackground(Color.white);
//        botao.setBorder(new RoundedBorder(30));
//        botao.setForeground(Color.lightGray);
        
        panel.add(botao);
        
        this.add(panel);
//        this.add(label);
        this.setLocation(250, 150);
        this.setVisible(true);
    }
    
//    @Override
//    public void paint(Graphics g){
//       
//        Graphics2D g2D = (Graphics2D) g;
//    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (validarLogin(texto[0].getText(), texto[1].getText())) {
            new TelaInicial();
        } else {
            JOptionPane.showMessageDialog(this, "Senha inválida.");
        }
    }
    
       public boolean validarLogin(String user, String pass) {
        String url = "jdbc:mysql://localhost:3306/senhas";
        String usuario = "root";
        String senha = "";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "SELECT * FROM senha WHERE login = ? AND senha = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, user);
                stmt.setString(2, pass);
                try (ResultSet rs = stmt.executeQuery()) {
                    return rs.next(); // true se encontrou registro
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    private static class RoundedBorder implements Border {
//
//        private int radius;
//
//
//        RoundedBorder(int radius) {
//            this.radius = radius;
//        }
//
//
//        public Insets getBorderInsets(Component c) {
//            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
//        }
//
//
//        public boolean isBorderOpaque() {
//            return true;
//        }
//
//
//        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
//            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
//        }
//    }
}

