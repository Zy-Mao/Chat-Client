package com.cs513.zmao;

import com.cs513.zmao.service.ConnectionCode;
import com.cs513.zmao.service.ConnectionService;
import com.cs513.zmao.service.InputServiceThread;
import com.cs513.zmao.service.OutputServiceThread;

import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
		String serverIP = "127.0.0.1";
		int outputPort = 12345;
		int inputPort = 13456;
		Socket inputSocket;
		Socket outputSocket;

		try {
			inputSocket = new Socket(serverIP, inputPort);
			outputSocket = new Socket(serverIP, outputPort);

			String message = ConnectionService.readData(inputSocket);
			if (!message.startsWith(ConnectionCode.SUCCESS)) {
				//close connection
				System.exit(-1);
			}

			String userName = "default-user";
			while (true) {
				String returnedCode = ConnectionService.initialConnections(inputSocket, outputSocket, userName);
				if (returnedCode.equals(ConnectionCode.SUCCESS)) {
					break;
				} else if (!returnedCode.equals(ConnectionCode.RETRY)) {
					System.exit(-1);
				} else {
					//retry
					System.out.println("Retry...");
				}
			}
			System.out.println("User name set as " + userName);
			OutputServiceThread outputServiceThread = new OutputServiceThread(outputSocket, userName);
			InputServiceThread inputServiceThread = new InputServiceThread(inputSocket, userName);
			outputServiceThread.start();
			inputServiceThread.start();

		} catch (IOException ex) {
			System.out.println("Could not connect to ftp server, please check your network.");
//			System.exit(1);
		}
    }
}
