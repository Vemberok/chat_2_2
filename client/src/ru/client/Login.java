package ru.client;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import javax.swing.*;
import java.awt.*;

import java.util.*;

public class Login {
    public int error=3;
    public  JFrame frame;
    public   JTextField textField;
    public   JTextField textField2;
    public   JTextField textField3;
    public   JOptionPane dialog;
    public JButton okButton;
    public JButton okButton1;
    public  JLabel labe;

    ArrayList<String> list =  new ArrayList<>();
    private String str;
    private String pas;

    public  void  gogin () {


         String [] logins = new String[100];
        String [] password = new String[100];
        logins[0] ="qwe";
        password[1]="123";

        //super("Авторизация");
        frame = new JFrame("Авторизация");
        frame.setBounds(100, 100, 500, 210);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{115, 101, 99, 171, 180, 256, 208, 285, -76, 0};;
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 15, 1, 1, 11, 2, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        frame.getContentPane().setLayout(gridBagLayout);

        textField3 = new JTextField();
        GridBagConstraints gbc_textField33 = new GridBagConstraints();
        gbc_textField33.gridwidth = 2;
        gbc_textField33.insets = new Insets(-1000, 0, 5, 5);
        gbc_textField33.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField33.gridx = 4;
        gbc_textField33.gridy = 4;
        frame.getContentPane().add(textField3, gbc_textField33);
        textField3.setColumns(10);



        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();



        textField = new JTextField(10);
        textField.setText("Логин");



        textField.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {

                textField.setText(null);

            }

            @Override
            public void focusLost(FocusEvent e) {

               // textField.setText("Логин");

            }

        });

        gbc_textField.gridwidth = 2;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 4;
        gbc_textField.gridy = 4;
       frame.getContentPane().add(textField, gbc_textField);
        textField.setColumns(10);
        //String str = textField.getText() ;



        textField2 = new JTextField();

        textField2 = new JTextField(10);
        textField2.setText("Пароль");



        textField2.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {

                textField2.setText(null);

            }

            @Override
            public void focusLost(FocusEvent e) {

               // textField2.setText("Пароль");

            }

        });

        GridBagConstraints gbc_textField1 = new GridBagConstraints();
        gbc_textField1.gridwidth = 2;
        gbc_textField1.insets = new Insets( 70, 0,  5, 5);
        gbc_textField1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField1.gridx = 4;
        gbc_textField1.gridy = 4;
        frame.getContentPane().add(textField2, gbc_textField1);
        textField2.setColumns(10);
        //String str1 = textField2.getText() ;


        okButton = new JButton("Вход");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.BOTH;
        gbc_btnNewButton.gridwidth = 2;
        gbc_btnNewButton.insets = new Insets(0, 30, 0, 270);
        gbc_btnNewButton.gridx = 4;
        gbc_btnNewButton.gridy = 8;
        frame.getContentPane().add(okButton, gbc_btnNewButton);
        frame.setVisible(false);
        //new ClientWindow();

       okButton1 = new JButton("Создать");
       GridBagConstraints gbc_btnNewButton1 = new GridBagConstraints();
       gbc_btnNewButton1.fill = GridBagConstraints.BOTH;
       gbc_btnNewButton1.gridwidth = 2;
       gbc_btnNewButton1.insets = new Insets(0, 270, 0, 30);
       gbc_btnNewButton1.gridx = 4;
       gbc_btnNewButton1.gridy = 8;
       frame.getContentPane().add(okButton1, gbc_btnNewButton1);
    }

     public String gp(){
        // System.out.println("df");
        this.str = textField.getText();

         return str;
    }

    public String pp(){

        this.pas = textField2.getText();

        return pas;
    }

}
