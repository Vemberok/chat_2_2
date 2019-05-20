package ru.server;

import ru.network.TCPConnection;
import ru.network.TCPConnectionListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatServer implements TCPConnectionListener {

    public static void main(String[] args) {
        new ChatServer();
    }

    private final Map<TCPConnection, String> connections = new HashMap<>();

    private ChatServer() {
        System.out.println("Server start");

        try (ServerSocket serverSocket = new ServerSocket(4000)) {
            while (true) {
                try {
                    new TCPConnection(this, serverSocket.accept());
                } catch (IOException e) {
                    System.out.println("TCPconnecction exeption: " + e);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void onConnectionReady(TCPConnection tcpConnection) {
        connections.put(tcpConnection, "");
        System.out.println(" Client connected " + tcpConnection);
    }

    @Override
    public synchronized void onReceivesString(TCPConnection tcpConnection, String value) {
//        sendALLConnections(value);
        processString(tcpConnection, value);
    }

    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {
        connections.remove(tcpConnection);
        System.out.println(" Client disconnected " + tcpConnection);
    }

    @Override
    public synchronized void onException(TCPConnection tcpConnection, Exception e) {
        System.out.println("TCPConnection exception: " + e);
    }

    /*!!! ВЫНЕСТИ В ОБЩИЙ КЛАСС*/
    private final String SYMBOL_LOGIN = "L: ";
    private final String SYMBOL_USERS = "U: ";

    /**
     * Обработчик сообщений от клиентов
     *
     * @param tcpConnection
     * @param value         сообщение
     */
    private void processString(TCPConnection tcpConnection, String value) {
        /* Если прислали логин - обновляем словарь соединений */
        if (value.contains(SYMBOL_LOGIN))
            connections.put(tcpConnection, value.replace(SYMBOL_LOGIN, ""));
            /* Если прислали запрос на список пользователей, отправляем его */
        else if (value.contains(SYMBOL_USERS))
            tcpConnection.sendString(SYMBOL_USERS + connections.values().toString());
        else {
            System.out.println(value);
            for (TCPConnection con : connections.keySet())
                con.sendString(value);
        }
    }

//    private void sendALLConnections(String value) {
//
//        final int N = connections.size();
//        for (int i = 0; i < N; i++)
//            connections.get(i).sendString(value);
//
//    }
}
