package com.zhanglw.tips.stream;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

public class EchoServerNIO {

	private static final int ECHO_SERVER_PORT = 6799;
	private static final int ECHO_SERVER_TIMEOUT = 5000;
	private static final int BUFFER_SIZE = 1024;

	private static ServerSocketChannel serverChannel = null;
	private static Selector selector = null;// 多路复用选择器
	private static ByteBuffer buffer = null;// 缓冲区

	public static void main(String[] args) {
		init();
		listen();
	}

	private static void init() {
		try {
			serverChannel = ServerSocketChannel.open();
			buffer = ByteBuffer.allocate(BUFFER_SIZE);
			serverChannel.socket().bind(new InetSocketAddress(ECHO_SERVER_PORT));
			serverChannel.configureBlocking(false);
			selector = Selector.open();
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void listen() {

		while (true) {
			try {
				if (selector.select(ECHO_SERVER_TIMEOUT) != 0) {
					Iterator<SelectionKey> it = selector.selectedKeys().iterator();
					while (it.hasNext()) {
						SelectionKey key = (SelectionKey) it.next();
						it.remove();
						handleKey(key);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("static-access")
	private static void handleKey(SelectionKey key) {

		SocketChannel chanel = null;
		try {
			if (key.isAcceptable()) {
				ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
				chanel = serverChannel.accept();
				chanel.configureBlocking(false);
				chanel.register(selector, SelectionKey.OP_READ);
			}else if(key.isReadable()){
				chanel = (SocketChannel) key.channel();
				buffer.clear();
				if(chanel.read(buffer)>0){
					buffer.flip();
					CharBuffer charBuffer = CharsetHelper.decode(buffer);
					String msg = charBuffer.toString();
					System.out.println("收到"+chanel.getRemoteAddress()+"的消息:"+msg);
					chanel.write(CharsetHelper.encode(charBuffer.wrap(msg)));
				}else{
					chanel.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(chanel!=null){
					chanel.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}

final class CharsetHelper{
	private static final String UTF_8="UTF-8";
	private static CharsetEncoder encoder = Charset.forName(UTF_8).newEncoder();
	private static CharsetDecoder decoder = Charset.forName(UTF_8).newDecoder();
	
	private CharsetHelper() {
	}
	
	public static ByteBuffer encode(CharBuffer in) throws CharacterCodingException{
		return encoder.encode(in);
	}
	
	public static CharBuffer decode(ByteBuffer in) throws CharacterCodingException{
		return decoder.decode(in);
	}
}
