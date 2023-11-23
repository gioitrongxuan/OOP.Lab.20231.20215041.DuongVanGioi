package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.stream.events.StartDocument;

public class NoGarbage {
	public static void main(String[] args) throws IOException {
		
		String filename = "D:\\a_learning_code\\java\\OOP.Lab.20231.20215041.DuongVanGioi\\OtherProjects\\src\\hust\\soict\\hedspi\\garbage\\test.exe";
		byte[] inputBytes = {0};
		long startTime, endTime;
		
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b : inputBytes){
			outputStringBuilder.append((char) b);
		}
		outputStringBuilder.toString();
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
}
