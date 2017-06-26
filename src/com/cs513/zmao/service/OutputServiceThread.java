package com.cs513.zmao.service;

import java.net.Socket;

public class OutputServiceThread extends Thread{
	private Socket socket;
	private String userName;

	public OutputServiceThread(Socket socket, String userName) {
		this.socket = socket;
		this.userName = userName;
	}
}
