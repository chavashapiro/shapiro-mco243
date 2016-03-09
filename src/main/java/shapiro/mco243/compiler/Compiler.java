package shapiro.mco243.compiler;

public class Compiler {

	private String[] hexOutput;
	private int index;

	public Compiler() {
		hexOutput = new String[256];
		index = 0;
	}

	public void processInstruction(String instruction) {
		String[] insSplit = instruction.split(" ");
		String ins = insSplit[0];
		String dataString = null;
		if (insSplit.length == 2) {
			dataString = insSplit[1];
		}

		switch (ins) {
		case "LD":
			hexOutput[index] = "0";
			index++;
			String hex = Integer.toHexString(Integer.parseInt(dataString)).toUpperCase();
			if (hex.length() == 2) {
				hexOutput[index] = String.valueOf(hex.charAt(0));
				index++;
				hexOutput[index] = String.valueOf(hex.charAt(1));
				index++;
			} else {
				hexOutput[index] = "0";
				index++;
				hexOutput[index] = String.valueOf(hex.charAt(0));
				index++;
			}
			break;
		case "ST":
			hexOutput[index] = "1";
			index++;
			hex = Integer.toHexString(Integer.parseInt(dataString)).toUpperCase();
			if (hex.length() == 2) {
				hexOutput[index] = String.valueOf(hex.charAt(0));
				index++;
				hexOutput[index] = String.valueOf(hex.charAt(1));
				index++;
			} else {
				hexOutput[index] = "0";
				index++;
				hexOutput[index] = String.valueOf(hex.charAt(0));
				index++;
			}
			break;
		case "SWP":
			hexOutput[index] = "2";
			index++;
			break;
		case "ADD":
			hexOutput[index] = "3";
			index++;
			break;
		case "INC":
			hexOutput[index] = "4";
			index++;
			break;
		case "DEC":
			hexOutput[index] = "5";
			index++;
			break;
		case "BZ":
			hexOutput[index] = "6";
			index++;
			hex = Integer.toHexString(Integer.parseInt(dataString)).toUpperCase();
			if (hex.length() == 2) {
				hexOutput[index] = String.valueOf(hex.charAt(0));
				index++;
				hexOutput[index] = String.valueOf(hex.charAt(1));
				index++;
			} else {
				hexOutput[index] = "0";
				index++;
				hexOutput[index] = String.valueOf(hex.charAt(0));
				index++;
			}
			break;
		case "BR":
			hexOutput[index] = "7";
			index++;
			hex = Integer.toHexString(Integer.parseInt(dataString)).toUpperCase();
			if (hex.length() == 2) {
				hexOutput[index] = String.valueOf(hex.charAt(0));
				index++;
				hexOutput[index] = String.valueOf(hex.charAt(1));
				index++;
			} else {
				hexOutput[index] = "0";
				index++;
				hexOutput[index] = String.valueOf(hex.charAt(0));
				index++;
			}
			break;
		case "STP":
			hexOutput[index] = "8";
			index++;
			break;
		case "DATA":
			String[] dataArray = dataString.split("");
			for (String dat : dataArray) {
				hexOutput[index] = dat;
				index++;
			}
			break;
		}

	}

	public void fillInHexOutput() {
		if (index < hexOutput.length) {
			for (int i = index; i < hexOutput.length; i++) {
				hexOutput[index] = "0";
			}
		}

	}

	public String[] getHexOutput() {
		return hexOutput;
	}
}
