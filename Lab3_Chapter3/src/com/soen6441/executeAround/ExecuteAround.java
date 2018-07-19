package com.soen6441.executeAround;

import java.io.*;

public class ExecuteAround {

	public static void main(String... args) throws IOException {

		// method we want to refactor to make more flexible
		String result = processFileLimited();
		System.out.println(result);

		System.out.println("***");

		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);

		String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
		System.out.println(twoLines);

		String numLines = processFile((BufferedReader b) -> Long.toString(b.lines().count()));
		System.out.println(numLines);
	}

	// Without using execute around pattern->
	public static String processFileLimited() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
			return br.readLine();
		}
	}

	// Using execute around pattern->
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
			return p.process(br);
		}
	}

	public interface BufferedReaderProcessor {
		public String process(BufferedReader b) throws IOException;
	}
}
