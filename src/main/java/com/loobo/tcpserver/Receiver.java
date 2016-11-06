package com.loobo.tcpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Receiver {

    Socket socket;

    public Receiver(String sendAddress, int port) {
        try {
            socket = new Socket(sendAddress, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readMessage() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int SIZE = 1024;
        char buffer[] = new char[SIZE];

        StringBuilder stringBuilder = new StringBuilder();

        int thunk;
        while ((thunk = br.read(buffer, 0, SIZE)) == 1024) {
            stringBuilder.append(buffer);
        }
        if (thunk != -1) {
            stringBuilder.append(buffer, 0, thunk);
        }

        return stringBuilder.toString();
    }

}
