package ru.client;

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



class ListenerAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {


        Login window2 = new Login();
        window2.gogin();
        //window.frame.setVisible(true);
        //System.out.println(window2.gp());

       // new ClientWindow();
    }
}