package ru.client;

import ru.network.TCPConnection;
import ru.network.TCPConnectionListener;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.Timer;


public class ClientWindow extends JFrame implements ActionListener, TCPConnectionListener {

    private static final String IP_ADDR = "127.0.0.1";
    private static final int PORT = 4000;
    private static final int WIDTH = 755;
    private static final int HEIGHT = 455;
    private static String loginName;
    private static String Pass;
    private static String loginName2;
    private static String Pass2;
    private static String pop;
    private JFrame frame;
    private JTextField textField;
    private JOptionPane dialog;

    int error = 3;

    public static void main(String[] args) {
        String[] logins = new String[100];
        String[] password = new String[100];
        logins[0] = "qwe";
        password[0] = "123";

//        SwingUtilities.invokeLater(new Runnable() {
//          @Override
//            public void run() {
        try {

            Login window = new Login();
            Reg registr = new Reg();
            //window.frame.setVisible(true);
            window.gogin();
            registr.gogin();

            window.frame.setVisible(true);

            window.okButton.addActionListener(e -> {
                loginName = window.textField.getText();
                Pass = window.textField2.getText();
                //System.out.println(loginName);
                //logins[0] =loginName;
                if (logins[0].equals(loginName)) {
                    if (password[0].equals(Pass)) {
                        // System.out.println(logins[0]);
                        // System.out.println(loginName);
                        ClientWindow w = new ClientWindow();
                        w.fieldNickname.setText(loginName);
                        w.fieldNickname.setEditable(false);
                        //w.fieldNickname.setVisible(true);
                        w.setVisible(true);
                        window.frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "     Не верный пароль - Осталось попыток  " + window.error);
                        if (window.error == 0)
                            System.exit(0);
                        window.error = window.error - 1;
                    }
                } else {
                    //System.exit(0);
                    JOptionPane.showMessageDialog(null, "    Не верный логин - Осталось попыток  " + window.error);
                    if (window.error == 0)
                        System.exit(0);
                    window.error = window.error - 1;



                    
                }

            });

            window.okButton1.addActionListener(e -> {

                registr.frame.setVisible(true);
                window.frame.setVisible(false);

            });

            registr.okButton3.addActionListener(e -> {

                logins[0] = registr.textField.getText();
                password[0] = registr.textField2.getText();

                //System.out.println("kek" );
                registr.frame.setVisible(false);
                window.frame.setVisible(true);


            });




        } catch (
                Exception e) {
            e.printStackTrace();
        }

//          }
//
//        });
    }

    private final String SYMBOL_LOGIN = "L: ";
    private final String SYMBOL_USERS = "U: ";

    private final JTextArea fieldNickname = new JTextArea(1, 43);

    private final JTextArea log = new JTextArea(18, 50);

    private final JTextArea fieldNicknameOnline = new JTextArea(18, 10);

    private final JTextField fieldInput = new JTextField(66);

    private TCPConnection connection;


    public ClientWindow() {
        setTitle("BleakChat_v1.5_bild_36");


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setResizable(false);


        fieldNickname.setForeground(new Color(210, 255, 255));
        log.setForeground(new Color(255, 150, 0));
        fieldNicknameOnline.setForeground(new Color(0, 210, 0));
        fieldInput.setForeground(new Color(210, 255, 255));

        fieldNickname.setLineWrap(true);
        fieldNickname.setBackground(new Color(0, 0, 0));
        fieldNickname.setFont(new Font("TimesRoman", Font.BOLD, 18));

        fieldNickname.setEditable(false);

        add(fieldNickname, BorderLayout.NORTH);


        log.setBackground(new Color(0, 0, 0));
        log.setLineWrap(true);
        log.setFont(new Font("TimesRoman", Font.BOLD, 14));
        log.setEditable(false);
        add(log, BorderLayout.CENTER);



        fieldNicknameOnline.setBackground(new Color(0, 0, 0));
        fieldNicknameOnline.setLineWrap(true);
        fieldNicknameOnline.setFont(new Font("TimesRoman", Font.BOLD, 14));
        fieldNicknameOnline.setEditable(false);
        fieldNicknameOnline.setText("Not users online");
        add(fieldNicknameOnline, BorderLayout.CENTER);

        fieldInput.setBackground(new Color(0, 0, 0));
        fieldInput.addActionListener(this);
        add(fieldInput, BorderLayout.SOUTH);

        JPanel context = new JPanel();

        context.setBackground(Color.black);
        context.add(new JScrollPane(fieldNickname));
        context.add(new JScrollPane(log));
        context.add(new JScrollPane(fieldNicknameOnline));
        context.add(fieldInput);
        setContentPane(context);
        setVisible(true);
        try {
            connection = new TCPConnection(this, IP_ADDR, PORT);
            /* Сразу отправляем серверу свой логин с подписью <L: >*/
            connection.sendString(SYMBOL_LOGIN + loginName);
        } catch (IOException e) {
            printMsg("    " + "Connection exception" + e);
            System.out.println("    " + "TCPConnection exception: ");
        }

        /* Здесь клиент отправляем запросы (<U: >) на список пользователей с задержкой в секунду каждые 10 секунд*/
        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                connection.sendString(SYMBOL_USERS);
            }
        };
        t.scheduleAtFixedRate(task, 1000, 10000);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = fieldInput.getText();
        if (msg.equals("")) return;
        fieldInput.setText(null);
        connection.sendString("    " + fieldNickname.getText() + " :" + msg);
    }

    private synchronized void printMsg(String msg) {
        SwingUtilities.invokeLater(() -> {
            log.append(msg + "\n");
            log.setCaretPosition(log.getDocument().getLength());
        });
    }


    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        printMsg("Connected done ");
    }

    @Override
    public void onReceivesString(TCPConnection tcpConnection, String value) {
        processMessage(value);
    }

    /**
     * Обработка сообщений от сервера
     *
     * @param value сообщение
     */
    private void processMessage(String value) {
        /* Если в сообщении содержится символ <U: > - то список пользователей */
        if (value.contains(SYMBOL_USERS)) {
            String usersOnline = String.join("\n", Arrays.asList((value
                    .replaceAll(SYMBOL_USERS, "")
                    .replace("[", "")
                    .replace("]", "")
                    .trim())
                    .split(",")));
            fieldNicknameOnline.setText(usersOnline);
        } else
            printMsg(value);
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        printMsg("Connection Disconnect ");
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
        printMsg("Connection exception" + e);
    }

}
