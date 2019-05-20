package ru.client;


import com.sun.org.apache.regexp.internal.RE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;


public class Reg {

    public  JFrame frame;
    public   JTextField textField;
    public   JTextField textField2;
    public   JTextField textField3;
    public   JTextField textField4;
    public   JOptionPane dialog;
    public JButton okButton;
    public JButton okButton3;

    ArrayList<String> list =  new ArrayList<>();
    private String str;
    private String pas;

    public  void  gogin () {


        String [] logins = new String[100];
        String [] password = new String[100];
        logins[0] ="qwe";
        password[1]="123";


        frame = new JFrame("Регистрация");
        frame.setBounds(100, 100, 500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{115, 101, 99, 171, 180, 256, 208, 285, -76, 0};;
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 15, 1, 1, 11, 2, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        frame.getContentPane().setLayout(gridBagLayout);


        textField4 = new JTextField();
        GridBagConstraints gbc_textField44 = new GridBagConstraints();
        gbc_textField44.gridwidth = 2;
        gbc_textField44.insets = new Insets(-1000, 0, 5, 5);
        gbc_textField44.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField44.gridx = 4;
        gbc_textField44.gridy = 4;
        frame.getContentPane().add(textField4, gbc_textField44);
        textField4.setColumns(10);

        textField = new JTextField();
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

        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.gridwidth = 2;
        gbc_textField.insets = new Insets(-30, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 4;
        gbc_textField.gridy = 4;
        frame.getContentPane().add(textField, gbc_textField);
        textField.setColumns(10);
        //String str = textField.getText() ;

        textField2 = new JTextField();
        textField2.setText("Пароль");
        textField2.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {

                textField2.setText(null);

            }

            @Override
            public void focusLost(FocusEvent e) {

                // textField.setText("Логин");

            }

        });
        GridBagConstraints gbc_textField1 = new GridBagConstraints();
        gbc_textField1.gridwidth = 2;
        gbc_textField1.insets = new Insets( 20, 0,  5, 5);
        gbc_textField1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField1.gridx = 4;
        gbc_textField1.gridy = 4;
        frame.getContentPane().add(textField2, gbc_textField1);
        textField2.setColumns(10);
        //String str1 = textField2.getText() ;

        textField3 = new JTextField();
        textField3.setText("Моб.Телефон");
        textField3.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {

                textField3.setText(null);

            }

            @Override
            public void focusLost(FocusEvent e) {

                // textField.setText("Логин");

            }

        });
        GridBagConstraints gbc_textField2 = new GridBagConstraints();
        gbc_textField2.gridwidth = 2;
        gbc_textField2.insets = new Insets( 70, 0,  5, 5);
        gbc_textField2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField2.gridx = 4;
        gbc_textField2.gridy = 4;
        frame.getContentPane().add(textField3, gbc_textField2);
        textField3.setColumns(10);
        //String str1 = textField2.getText() ;


        okButton3 = new JButton("Зарегистрироваться");
        GridBagConstraints gbc_btnNewButton4 = new GridBagConstraints();
        gbc_btnNewButton4.fill = GridBagConstraints.BOTH;
        gbc_btnNewButton4.gridwidth = 2;
        gbc_btnNewButton4.insets = new Insets(0, 150, 0, 150);
        gbc_btnNewButton4.gridx = 4;
        gbc_btnNewButton4.gridy = 8;
        frame.getContentPane().add(okButton3, gbc_btnNewButton4);
       // frame.setVisible(false);
        //new ClientWindow();


       /* okButton3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                //System.out.println("worok2");
                frame.setVisible(false);

                Login window = new Login();
                //Reg registr = new Reg();
                //window.frame.setVisible(true);




            }
        }); */


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
