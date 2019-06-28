package com.test.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileReaderTest {
	
	static Map<String, String> map =new HashMap<>();
	static FileOutputStream fos ;
	public static void main(String[] args) throws IOException {
		fos =new FileOutputStream("D:\\Quesi.txt");
		File F = new File("C:\\Question\\");
		for(File f :F.listFiles()) {
			BufferedReader br  =new BufferedReader(new FileReader(f));
			String s ;
			while((s =br.readLine())!=null) {
				String s1[]= s.trim().split(",");
				if(s1==null || s1.length==0 || s1.length<2 || s1[2]==null )
					continue;
				String ques ;
				if(s1[2].contains("%"))
					ques =s1[1].trim();
				else
				 ques =s1[2].trim();
				if(!map.containsKey(ques)) {
					map.put(ques, ques);
				} 
			}
		}
		
		for(String question :map.keySet()) {
			fos.write(question.getBytes());
			fos.write("\n".getBytes());
		}
	}

}
