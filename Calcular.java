package com.mycompany.calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Calcular extends JFrame implements ActionListener{
    
    String leitor = "";
    double conta;
    JLabel label;
    JPanel panel1, panel2;
    JButton[] botao;
    
    Calcular(){
        
        this.setSize(350,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(new FlowLayout());
        
        panel1 = new JPanel();
        
        panel1.setPreferredSize(new Dimension(320,240));
        
        panel2 = new JPanel();
        
        panel2.setPreferredSize(new Dimension(320,100));
        panel2.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        panel2.setLayout(new BorderLayout());
        
        botao = new JButton[16];
        
        String[] texto_botao = {"7", "8", "9", "+",
                                "4", "5", "6", "-",
                                "1", "2", "3", "*",
                                "CE", "0", "=", "/"};
        
        for(int i = 0; i<16; i++){
            botao[i] = new JButton(texto_botao[i]);
            
            botao[i].setPreferredSize(new Dimension(75, 50));
            botao[i].setFocusable(false);
            botao[i].addActionListener(this);
            botao[i].setBackground(Color.gray);
            botao[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
            botao[i].setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
            
            panel1.add(botao[i]);
        }
        
        label = new JLabel();
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        label.setHorizontalAlignment(JLabel.CENTER);      
        
        
        panel2.add(label);
        this.add(panel2);
        this.add(panel1);
        this.setLocation(800, 250);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == botao[0]){
            leitor += "7";
            label.setText(leitor);
        }
        if(e.getSource() == botao[1]){
            leitor += "8";
            label.setText(leitor);
        }
        if(e.getSource() == botao[2]){
            leitor += "9";
            label.setText(leitor);
        }
        if(e.getSource() == botao[3]){
            leitor += " + ";
            label.setText(leitor);
        }
        if(e.getSource() == botao[4]){
            leitor += "4";
            label.setText(leitor);
        }
        if(e.getSource() == botao[5]){
            leitor += "5";
            label.setText(leitor);
        }
        if(e.getSource() == botao[6]){
            leitor += "6";
            label.setText(leitor);
        }
        if(e.getSource() == botao[7]){
            leitor += " - ";
            label.setText(leitor);
        }
        if(e.getSource() == botao[8]){
            leitor += "1";
            label.setText(leitor);
        }
        if(e.getSource() == botao[9]){
            leitor += "2";
            label.setText(leitor);
        }
        if(e.getSource() == botao[10]){
            leitor += "3";
            label.setText(leitor);
        }
        if(e.getSource() == botao[11]){
            leitor += " * ";
            label.setText(leitor);
        }
        if(e.getSource() == botao[12]){
            leitor = "";
            label.setText(leitor);
        }
        if(e.getSource() == botao[13]){
            leitor += "0";
            label.setText(leitor);
        }
        if(e.getSource() == botao[14]){
            try{
                conta = conta(leitor);
                leitor = String.valueOf(conta);
            }catch(Exception a){
                leitor = "ERROR";
            }
            
            System.out.print(leitor.length());
            
            if(leitor.substring(leitor.length()-1,leitor.length()).equals("0")){
                leitor = leitor.substring(0,leitor.length()-2);
            }
            label.setText(leitor);
        }
        if(e.getSource() == botao[15]){
            leitor += " / ";
            label.setText(leitor);
        }
    }
    public double conta(String conta){
        
        String num1 = "", num2 = "", operador = "";
        double resul = 1;
        int trava = 0;
        
        while(conta.length() > 1){
            if(trava == 0){
                num1 = conta.substring(0,conta.indexOf(" "));
                conta = conta.substring(conta.indexOf(" ")+1,conta.length());
            }
            
            operador = conta.substring(0,1);
            conta = conta.substring(2,conta.length());
            
            try {
                num2 = conta.substring(0, conta.indexOf(" "));
                conta = conta.substring(conta.indexOf(" ") + 1, conta.length());

            } catch (Exception e) {
                num2 = conta;
            }
            
            if(trava == 0){
                resul = Double.parseDouble(num1);
                trava = 1;
            }
            
            if(operador.equals("+")){
                resul = resul + Double.parseDouble(num2);
            }else if(operador.equals("-")){
                resul = resul - Double.parseDouble(num2);
            }else if(operador.equals("*")){
                resul = resul * Double.parseDouble(num2);
            }else if(operador.equals("/")){
                resul = resul / Double.parseDouble(num2);
            }
        }
        return resul;
    }
}
