package com.zhanglw.tips.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerTest {

	private static final int ECHO_SERVER_PORT = 6799;
	
	public static void main(String[] args) {
		test();
	}
	public static  void test() {

		try(ServerSocket server = new ServerSocket(ECHO_SERVER_PORT)){
			System.out.println("启动服务");
			while(true){
				Socket client = server.accept();
				new Thread(new ClientHandler(client)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class ClientHandler implements Runnable {

		private Socket client;
		
		public ClientHandler(Socket socket) {
			super();
			this.client = socket;
		}


		@Override
		public void run() {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter pw = new PrintWriter(client.getOutputStream())){
				String msg = br.readLine();
				System.out.println("收到"+client.getInetAddress()+"发送的:"+msg);
				pw.println(msg);
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
