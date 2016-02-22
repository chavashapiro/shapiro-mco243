package processor;

public class Memory {

	private String[] memory;

	public Memory(String mem) {
		memory = mem.split("");
	}

	public String[] getMemory() {
		return this.memory;
	}

	public void setMemory(String[] memory) {
		this.memory = memory;
	}

}
