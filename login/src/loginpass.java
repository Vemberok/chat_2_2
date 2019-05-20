import ru.network.TCPConnection;
import ru.network.TCPConnectionListener;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.sql.*;


public class loginpass {




    public  loginpass () {

        frame = new JFrame();
        frame.setBounds(100, 100, 500, 210);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{115, 101, 99, 171, 180, 256, 208, 285, -76, 0};;
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 15, 1, 1, 11, 2, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        frame.getContentPane().setLayout(gridBagLayout);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.gridwidth = 2;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 4;
        gbc_textField.gridy = 4;
        frame.getContentPane().add(textField, gbc_textField);
        textField.setColumns(10);
        String str = textField.getText() ;

        textField = new JTextField();
        GridBagConstraints gbc_textField1 = new GridBagConstraints();
        gbc_textField1.gridwidth = 2;
        gbc_textField1.insets = new Insets( 70, 0,  5, 5);
        gbc_textField1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField1.gridx = 4;
        gbc_textField1.gridy = 4;
        frame.getContentPane().add(textField, gbc_textField1);
        textField.setColumns(10);
        String str1 = textField.getText() ;


        JButton btnNewButton = new JButton("Вход");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.BOTH;
        gbc_btnNewButton.gridwidth = 2;
        gbc_btnNewButton.insets = new Insets(0, 150, 0, 150);
        gbc_btnNewButton.gridx = 4;
        gbc_btnNewButton.gridy = 8;
        frame.getContentPane().add(btnNewButton, gbc_btnNewButton);


    }

}
