package com.cs513.zmao;

import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
		String serverIP = "127.0.0.1";
		int inputPort = 12345;
		int outputPort = 13456;
		Socket inputSocket;
		Socket outputSocket;

		try {
			inputSocket = new Socket(serverIP, inputPort);
//			cmd_sckt_in = new BufferedReader(new InputStreamReader(cmd_sckt.getInputStream()));

			outputSocket = new Socket(serverIP, outputPort);
//			msg_sckt_out = new PrintWriter(msg_sckt.getOutputStream(), true);

		} catch (IOException ex) {
			System.out.println("Could not connect to ftp server, please check your network.");
//			System.exit(1);
		}
    }
}
