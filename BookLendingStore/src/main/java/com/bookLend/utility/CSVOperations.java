package com.bookLend.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CSVOperations {

	@Value("${filepath.inputFilePath}")
	private static String filePath;
	
	public static List<String> readCsvFile(String name) throws IOException {


		//String path = "C:\\Users\\saman\\Documents\\";
		
		String fullPath = filePath+name;
		//String fullPath = path+name;
		System.out.println("path   :  "+fullPath);
		List<String> demo = Files.readAllLines(Paths.get(fullPath));
		
		System.out.println("1.1.1.1 read done "+ demo.size());
		
		
		
		return demo;
	}
	
	public static List<String> readFileLine(String line){
		
		return Arrays.asList(line.split(","));
	}
}
