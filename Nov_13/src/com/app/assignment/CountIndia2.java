package com.app.assignment;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CountIndia2 {
	public static void main(String a[]) {
		String filepath = "D:/chubb_workspace/Nov_13/src/com/app/basic/count.txt";
		
		try {
			long cnt = Files.lines(Paths.get(filepath))
					.map(String::toLowerCase).flatMap(line->Arrays.stream(line.split("\\s+")))
					.filter(word -> word.equals("india")).count();
			System.out.println(cnt);
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
}
