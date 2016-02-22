package processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MicroprocessorMain {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader("mach.in"));
			String memString;
			while ((memString = reader.readLine()) != null) {
				if (!String.valueOf(memString.charAt(0)).equals("8")) {
					Memory memory = new Memory(memString);
					Microprocessor processor = new Microprocessor(memory);
					processor.processInstruction();
					memory.setMemory(processor.getMemory());
					for (String s : memory.getMemory()) {
						System.out.print(s);
					}
					System.out.println();
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
