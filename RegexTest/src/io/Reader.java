package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

	private BufferedReader br;
	
	public Reader(String name) {
		try {
			br = new BufferedReader(new FileReader(name));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Missing file!");
		}
	}
	
	public String getLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			return null;
		}
	}
	
}
