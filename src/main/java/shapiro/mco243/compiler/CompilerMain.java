package shapiro.mco243.compiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompilerMain {

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// BufferedReader reader = new BufferedReader(new
			// FileReader("assemblyLanguage.txt"));
			Compiler compiler = new Compiler();
			String instruction;
			while ((instruction = reader.readLine()) != null) {
				compiler.processInstruction(instruction);
			}
			reader.close();
			compiler.fillInHexOutput();

			for (String s : compiler.getHexOutput()) {
				System.out.print(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
