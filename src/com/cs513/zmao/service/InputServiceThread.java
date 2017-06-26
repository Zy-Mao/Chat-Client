package com.cs513.zmao.service;

import java.net.Socket;

public class InputServiceThread extends Thread{
	private Socket socket;
	private String userName;

	public InputServiceThread(Socket socket, String userName) {
		this.socket = socket;
		this.userName = userName;
	}
}
