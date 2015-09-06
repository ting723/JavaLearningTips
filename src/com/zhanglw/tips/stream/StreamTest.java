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
 *	流:
 *	1. 字节流和字符流
 *	2. 字节流: 继承于InputStream,OutputStream
 *	3. 字符流: 继承于Reader,Writer
 *  4. java.io包中还有其他的流,主要是提供性能和使用方便
 *  5. 注意两点: 两种对称性: 输入和输出的对称性,字节和字符的对称性
 *  		        两种设计模式： 适配器模式和装饰模式
 */
public class StreamTest implements TestTips{

	@Override
	public void test() {
		
		 try {
//			this.fileCopy("E:\\Java核心技术读书纪要.md", "E:\\a.md");
//			this.fileNIOCopy("E:\\Java核心技术读书纪要.md", "E:\\a.md");
			int count = this.countWordInFile("E:\\Java核心技术读书纪要.md", "程序设计");
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private void fileCopy(String source,String target) throws IOException {
		//Java 7的TWR 	写法 可以不使用finally
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
