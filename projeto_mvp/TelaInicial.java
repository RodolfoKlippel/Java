/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_mvp;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Dono do Computador
 */
public class TelaInicial extends JFrame{
    
    TelaInicial(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setLayout(null);
        
        JLabel label = new JLabel("Login aceito!");
        
        label.setFont(new Font("Comic Sans MS",Font.BOLD,40));
        label.setBounds(200, 200, 400, 50);
        
        this.add(label);
        this.setLocation(250, 150);
        this.setVisible(true);
    }
}
