package main;

import java.util.ArrayList;

import io.Reader;
import process.MProcess;

public class Main {
	
	// Modified main source file
	
	public static void main(String[] args) {
		Reader reader = new Reader("file.in");
		MProcess process = new MProcess();
		
		String line;
		ArrayList<String> arr;
		while ((line = reader.getLine()) != null) {
			arr = process.proc(line);
			for (String i : arr)
				System.out.println(process.scrap(i));
		}
	}

}
