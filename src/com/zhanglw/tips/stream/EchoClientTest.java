package com.zhanglw.tips.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.zhanglw.tips.base.TestTips;

public class EchoClientTest implements TestTips {

	@Override
	public void test() {

		try (Socket socket = new Socket("localhost", 6799)) {
			// 发送信息
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入内容:");
			String msg = sc.nextLine();
			sc.close();
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(msg);
			pw.flush();
			// 接收信息
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String s = br.readLine();
			System.out.println(s);
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
