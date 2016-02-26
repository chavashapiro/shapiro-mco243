package shapiro.mco243.microprocessor;

public class Microprocessor {
	
	private String[] memory;
	private String a;
	private String b;
	private int index;

	public Microprocessor(Memory mem) {
		memory = mem.getMemory();
		a = "0";
		b = "0";
		index = 0;
	}

	public void processInstruction() {
		int current = Integer.parseInt(memory[index]);

		while (current != 8) {
			switch (current) {
			case 0: // load
				int address1 = Integer.parseInt(memory[index + 1], 16) * 16;
				int address2 = Integer.parseInt(memory[index + 2], 16);
				int location = address1 + address2;
				a = memory[location];
				index += 3;
				break;
			case 1: // store
				address1 = Integer.parseInt(memory[index + 1], 16) * 16;
				address2 = Integer.parseInt(memory[index + 2], 16);
				location = address1 + address2;
				memory[location] = a;
				index += 3;
				break;
			case 2: // swap
				String temp = a;
				a = b;
				b = temp;
				index++;
				break;
			case 3: // sum
				int num1 = Integer.parseInt(a, 16);
				int num2 = Integer.parseInt(b, 16);
				int sum = num1 + num2;
				String hex = Integer.toHexString(sum).toUpperCase();
				if (hex.length() == 2) {
					a = String.valueOf(hex.charAt(1));
					b = String.valueOf(hex.charAt(0));
				} else {
					a = String.valueOf(hex.charAt(0));
					b = "0";
				}
				index++;
				break;
			case 4: // increment
				if (a.equals("F")) {
					a = "0";
				} else {
					int num = Integer.parseInt(a, 16);
					num++;
					a = Integer.toHexString(num).toUpperCase();
				}
				index++;
				break;
			case 5: // decrement
				if (a.equals("0")) {
					a = "F";
				} else {
					int num = Integer.parseInt(a, 16);
					num--;
					a = Integer.toHexString(num).toUpperCase();
				}
				index++;
				break;
			case 6: // bz: break if zero
				if (a.equals("0")) {
					address1 = Integer.parseInt(memory[index + 1], 16) * 16;
					address2 = Integer.parseInt(memory[index + 2], 16);
					location = address1 + address2;
					index = location;
				} else {
					index += 3;
				}
				break;
			case 7: // break
				address1 = Integer.parseInt(memory[index + 1], 16) * 16;
				address2 = Integer.parseInt(memory[index + 2], 16);
				location = address1 + address2;
				index = location;
				break;
			case 8: // stop
				return;
			}
			current = Integer.parseInt(memory[index]);
		}
	}

	public String[] getMemory() {
		return this.memory;
	}

}
