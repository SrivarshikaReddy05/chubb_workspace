package com.app.assignment;

import java.io.BufferedReader;
import java.io.FileReader;

public class CountIndia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filepath = "D:/chubb_workspace/Nov_13/src/com/app/basic/count.txt";
		int cnt = 0;
		
		try( BufferedReader bufferReader = new BufferedReader(new FileReader(filepath))){
				String line;
				while((line = bufferReader.readLine())!=null) {
					line = line.toLowerCase();
					String[] words = line.split("\\s+");
					for(String word : words) {
						if(word.equals("india")) cnt++;
					}
					
				}
				System.out.println(cnt);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
