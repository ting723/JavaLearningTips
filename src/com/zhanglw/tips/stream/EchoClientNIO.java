package com.zhanglw.tips.stream;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

import com.zhanglw.tips.base.TestTips;
/**
 * 
 * @author zhanglw
 * �������о�
 */
public class EchoClientNIO implements TestTips {

	@Override
	public void test() {
		try {
			SocketChannel chanel = SocketChannel.open(new InetSocketAddress("localhost", 6799));
			chanel.configureBlocking(false);
			Selector selector = Selector.open();
			chanel.register(selector, SelectionKey.OP_READ);
			new TCPClientReadThread(selector);  
			ByteBuffer buffer = ByteBuffer.wrap("TEST".getBytes("UTF-8"));
			chanel.write(buffer);
			chanel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class TCPClientReadThread implements Runnable {  
    private Selector selector;  
  
    public TCPClientReadThread(Selector selector) {  
        this.selector = selector;  
  
        new Thread(this).start();  
    }  
  
    public void run() {  
        try {  
            while (selector.select() > 0) {//select()����ֻ��ʹ��һ�Σ�����֮��ͻ��Զ�ɾ��,ÿ�����ӵ���������ѡ�������Ƕ�����  
                // ����ÿ���п���IO����Channel��Ӧ��SelectionKey  
                for (SelectionKey sk : selector.selectedKeys()) {  
                    // �����SelectionKey��Ӧ��Channel���пɶ�������  
                    if (sk.isReadable()) {  
                        // ʹ��NIO��ȡChannel�е�����  
                        SocketChannel sc = (SocketChannel) sk.channel();//��ȡͨ����Ϣ  
                        ByteBuffer buffer = ByteBuffer.allocate(1024);//���仺������С  
                        sc.read(buffer);//��ȡͨ����������ݷ��ڻ�������  
                        buffer.flip();// ���ô˷���Ϊһϵ��ͨ��д�����Ի�ȡ ��������׼��  
                        // ���ֽ�ת��ΪΪUTF-16���ַ���  
                        String receivedString = Charset.forName("UTF-16")  
                                .newDecoder().decode(buffer).toString();  
                        // ����̨��ӡ����  
                        System.out.println("���յ����Է�����"  
                                + sc.socket().getRemoteSocketAddress() + "����Ϣ:"  
                                + receivedString);  
                        // Ϊ��һ�ζ�ȡ��׼��  
                        sk.interestOps(SelectionKey.OP_READ);  
                    }  
                    // ɾ�����ڴ����SelectionKey  
                    selector.selectedKeys().remove(sk);  
                }  
            }  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
    }  
}  
