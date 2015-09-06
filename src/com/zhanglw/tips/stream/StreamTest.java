package com.zhanglw.tips.stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

import com.zhanglw.tips.base.TestTips;

/**
 * 
 * @author zhanglw
 *
 *	��:
 *	1. �ֽ������ַ���
 *	2. �ֽ���: �̳���InputStream,OutputStream
 *	3. �ַ���: �̳���Reader,Writer
 *  4. java.io���л�����������,��Ҫ���ṩ���ܺ�ʹ�÷���
 *  5. ע������: ���ֶԳ���: ���������ĶԳ���,�ֽں��ַ��ĶԳ���
 *  		        �������ģʽ�� ������ģʽ��װ��ģʽ
 */
public class StreamTest implements TestTips{

	@Override
	public void test() {
		
		 try {
//			this.fileCopy("E:\\Java���ļ��������Ҫ.md", "E:\\a.md");
//			this.fileNIOCopy("E:\\Java���ļ��������Ҫ.md", "E:\\a.md");
			int count = this.countWordInFile("E:\\Java���ļ��������Ҫ.md", "�������");
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private void fileCopy(String source,String target) throws IOException {
		//Java 7��TWR 	д�� ���Բ�ʹ��finally
		System.out.println(System.currentTimeMillis());
		try(InputStream in = new FileInputStream(source)){
			try(OutputStream out =new FileOutputStream(target)){
				byte[] buffer = new byte[4096];
				int byteToRead = 0;
				while((byteToRead=in.read(buffer))!=-1){
					out.write(buffer,0,byteToRead);
				}
			}
		}
		System.out.println(System.currentTimeMillis());
	}

	@SuppressWarnings("unused")
	private void fileNIOCopy(String source,String targe) throws IOException, Exception{
		System.out.println(System.currentTimeMillis());
		try(FileInputStream in = new FileInputStream(source)){
			try(FileOutputStream out = new FileOutputStream(targe)){
				FileChannel inchannel = in.getChannel();
				FileChannel outchannel = out.getChannel();
				java.nio.ByteBuffer buffer = java.nio.ByteBuffer.allocate(4096);
				while((inchannel.read(buffer))!=-1){
					buffer.flip();
					outchannel.write(buffer);
					buffer.clear();
				}
			}
		}
		System.out.println(System.currentTimeMillis());
	}
	
	
	private int countWordInFile(String filename,String words) throws FileNotFoundException, IOException{
		int counter=0;
		try(FileReader reader = new FileReader(filename)){
			try(BufferedReader br = new BufferedReader(reader)){
				String line = null;
				while((line=br.readLine())!=null){
					int index = -1;
					while(line.length()>words.length() && (index=line.indexOf(words))>0){
						counter++;
						line = line.substring(index+words.length());
					}
				}
			}
		}
		return counter;
		
	}
}
