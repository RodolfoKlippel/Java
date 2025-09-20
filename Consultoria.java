/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dados;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Dono do Computador
 */
public class Consultoria extends JFrame implements ActionListener{
    
    JLabel[] label;
    JPanel panel;
    JTextField[] caixaTexto;
    JButton Enviar;
    
    Consultoria(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setLayout(null);
        
        panel = new JPanel();
        
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(500,500));
        panel.setBackground(Color.lightGray);
        panel.setBounds(150, 100, 500, 500);
        
        label = new JLabel[3];
        
        String[] labels = {"Codigo","Nome","Salario"};
        for(int i=0; i<3; i++){
            label[i] = new JLabel(labels[i]);
            
            label[i].setBounds(50,50+(70*i),120,40);
            label[i].setFont(new Font("Comic Sans MS",Font.PLAIN,25));
            
            panel.add(label[i]);
        }
        
        caixaTexto = new JTextField[3];
        
        for(int i=0; i<3; i++){
            caixaTexto[i] = new JTextField();
            
            caixaTexto[i].setBounds(180,50+(70*i),270,40);
            caixaTexto[i].setFont(new Font("Comic Sans MS",Font.PLAIN,25));
            
            panel.add(caixaTexto[i]);
        }
        
        Enviar = new JButton("Enviar");
        
        Enviar.setFont(new Font("Arial",Font.BOLD,20));
        Enviar.setFocusable(false);
        Enviar.setBounds(180, 340, 120, 40);
        Enviar.addActionListener(this);
        
        
        panel.add(Enviar);
        this.add(panel);
        this.setLocation(500, 200);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Enviar){
            System.out.print("Funcionario:\nCodigo: "+caixaTexto[0].getText()+"\nNome: "+caixaTexto[1].getText()+"\nSalario: R$"+caixaTexto[2].getText()+".00\n\n");
            banco();
        }
    }
    
    public void banco(){
        
        String url = "jdbc:mysql://localhost:3306/";
        String usuario = "root";
        String senha = "";
        
        try{
            
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            
            Statement sqll = conexao.createStatement();
            
            sqll.executeUpdate("INSERT INTO tabela VALUES("+Integer.parseInt(caixaTexto[0].getText())+",'"+caixaTexto[1].getText()+"',"+Double.parseDouble(caixaTexto[2].getText())+",now())");
            
            JOptionPane.showMessageDialog(null, "Dados Coletados.");
            
            sqll.close();
            conexao.close();
            
        }catch(Exception e){
            System.out.print(e);
        }
    }
}

