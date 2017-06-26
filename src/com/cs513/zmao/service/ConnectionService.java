package com.cs513.zmao.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionService {
	public static String readData(Socket inputSocket) {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(inputSocket.getInputStream()));
			String s = bufferedReader.readLine();
			System.out.println("Read input: " + s);
			return s;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean sendData(Socket outputSocket, String message) {
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(outputSocket.getOutputStream(), true);
			printWriter.println(message);
			System.out.println("Write output: " + message);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String initialConnections(Socket inputSocket, Socket outputSocket, String userName) {
		sendData(outputSocket, ConnectionCode.SET_USERNAME + userName);
		return readData(inputSocket);
	}
}
