package ru.network;

public interface TCPConnectionListener {
    void  onConnectionReady(TCPConnection tcpConnection);
    void  onReceivesString(TCPConnection tcpConnection, String value);
    void  onDisconnect(TCPConnection tcpConnection);
    void  onException(TCPConnection tcpConnection, Exception e);
}
