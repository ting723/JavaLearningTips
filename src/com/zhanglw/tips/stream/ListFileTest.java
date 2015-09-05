package com.zhanglw.tips.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import com.zhanglw.tips.base.TestTips;

public class ListFileTest implements TestTips{

	@Override
	public void test() {
		
//		this.listFlie("E:\\");
//		ListAllFiles.listAll("E:\\monitor");
		try {
			this.ShowFileByNIO("E:\\monitor");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void ShowFileByNIO(String initPath) throws IOException{
		
		Path path = Paths.get(initPath);
		Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println(file.toUri()+ file.getFileName().toString());
				return FileVisitResult.CONTINUE;
			}
		});
	}
	private void listFlie(String filePath){
		File file = new File(filePath);
		if(file.isDirectory()){
			for (File temp : file.listFiles()) {
				if(temp.isFile()){
					System.out.println(temp.getName());
				}
			}
		}
	}
}

class ListAllFiles{
	
	private ListAllFiles(){
	}
	
	public static void listAll(String path){
		
		_walkDictory(new File(path),0);
	}

	private static void _walkDictory(File file, int level) {
		
		if(file.isDirectory()){
			for (int i = 0; i < level-1; i++) {
				System.out.print("\t");
			}
			System.out.println(file.getName());
			for (File f : file.listFiles()) {
				_walkDictory(f, level+1);
			}
		}else{
			//确认文件目录级别
			for (int i = 0; i < level-1; i++) {
				System.out.print("\t");
			}
			System.out.println(file.getName());
		}
	}
	
	
	
}