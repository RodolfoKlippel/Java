/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo_da_velha;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rodolfo.klippel
 */
public class Frame_da_Velha extends JFrame implements ActionListener{
    
    JPanel panel;
    JButton[] botao;
    String Jogador = "X";
    
    Frame_da_Velha(){
        
        this.setSize(500,450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        panel = new JPanel();
        
        panel.setPreferredSize(new Dimension(470,395));
        panel.setBackground(Color.black);
        
        botao = new JButton[9];
        
        String[] vazio = {"", " ", "  ", "   ", "    ","     "," ","  ",""};
        
        for(int i=0; i<9; i++){
            botao[i] = new JButton(vazio[i]);
            
            botao[i].setPreferredSize(new Dimension(150,125));
            botao[i].setFocusable(false);
            botao[i].addActionListener(this);
            botao[i].setBackground(Color.white);
            botao[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 95));
            botao[i].setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
            
            panel.add(botao[i]);
        }
        
        this.add(panel);
        this.setLocation(700, 250);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == botao[0]){
            botao[0].setText(Jogador);
            botao[0].setEnabled(false);
        }
        if(e.getSource() == botao[1]){
            botao[1].setText(Jogador);
            botao[1].setEnabled(false);
        }
        if(e.getSource() == botao[2]){
            botao[2].setText(Jogador);
            botao[2].setEnabled(false);
        }
        if(e.getSource() == botao[3]){
            botao[3].setText(Jogador);
            botao[3].setEnabled(false);
        }
        if(e.getSource() == botao[4]){
            botao[4].setText(Jogador);
            botao[4].setEnabled(false);
        }
        if(e.getSource() == botao[5]){
            botao[5].setText(Jogador);
            botao[5].setEnabled(false);
        }
        if(e.getSource() == botao[6]){
            botao[6].setText(Jogador);
            botao[6].setEnabled(false);
        }
        if(e.getSource() == botao[7]){
            botao[7].setText(Jogador);
            botao[7].setEnabled(false);
        }
        if(e.getSource() == botao[8]){
            botao[8].setText(Jogador);
            botao[8].setEnabled(false);
        }
        
        if(e.getSource() == botao[0] || e.getSource() == botao[1] || e.getSource() == botao[2] || 
           e.getSource() == botao[3] || e.getSource() == botao[4] || e.getSource() == botao[5] ||
           e.getSource() == botao[6] || e.getSource() == botao[7] || e.getSource() == botao[8]){
            
            if(Jogador.equals("X")){
                Jogador = "O";
            }else{
                Jogador = "X";
            }
            
            if((botao[0].getText().equals(botao[1].getText()) && botao[1].getText().equals(botao[2].getText())) ||
               (botao[3].getText().equals(botao[4].getText()) && botao[4].getText().equals(botao[5].getText())) ||
               (botao[6].getText().equals(botao[7].getText()) && botao[7].getText().equals(botao[8].getText())) ||
               (botao[0].getText().equals(botao[3].getText()) && botao[3].getText().equals(botao[6].getText())) ||
               (botao[1].getText().equals(botao[4].getText()) && botao[4].getText().equals(botao[7].getText())) ||
               (botao[2].getText().equals(botao[5].getText()) && botao[5].getText().equals(botao[8].getText())) ||
               (botao[0].getText().equals(botao[4].getText()) && botao[4].getText().equals(botao[8].getText())) ||
               (botao[2].getText().equals(botao[4].getText()) && botao[4].getText().equals(botao[6].getText()))){
                
                System.out.print("Fim de Jogo!");
                botao[0].setEnabled(false);
                botao[1].setEnabled(false);
                botao[2].setEnabled(false);
                botao[3].setEnabled(false);
                botao[4].setEnabled(false);
                botao[5].setEnabled(false);
                botao[6].setEnabled(false);
                botao[7].setEnabled(false);
                botao[8].setEnabled(false);
            }
        }
    }
}
