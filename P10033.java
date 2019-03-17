import java.util.*;

/**
 * @author Colby McKinley
 * @UVa_ID colby_mckinley
 * @JUDGE_ID: 922619
 * @Problem_ID: 10033 - Interpreter
 *
 */
class Main {
	static String[] ram;
	static int[] reg;
	static int numExecutions = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int numCases = Integer.parseInt(in.nextLine());
		in.nextLine();
		while (numCases-- > 0) {
			reg = new int[10];
			ram = new String[1000];
			Arrays.fill(ram, "000");
			int k = 0;
			while (in.hasNextLine()) {
				String line = in.nextLine();
				if (line.isEmpty())
					break;
				ram[k++] = line;
			}
			execute();
			System.out.println(numExecutions);
			if(numCases > 0) System.out.println();

		}
		in.close();
	}

	static void execute() {
		numExecutions = 0;
		int ramInstruction = 0;
		String instruction;
		while (ramInstruction < ram.length) {
			instruction = ram[ramInstruction];
			int opcode = Character.getNumericValue(instruction.charAt(0));
			int ram1 = Character.getNumericValue(instruction.charAt(1));
			int ram2 = Character.getNumericValue(instruction.charAt(2));

			if (instruction.equals("100")) {
				++numExecutions;
				break;
			}

			switch (opcode) {
			case 2:
				reg[ram1] = ram2;
				++numExecutions;
				break;
			case 3:
				reg[ram1] = (reg[ram1] + ram2) % 1000;
				++numExecutions;
				break;
			case 4:
				reg[ram1] = (reg[ram1] * ram2) % 1000;
				++numExecutions;
				break;
			case 5:
				reg[ram1] = reg[ram2];
				++numExecutions;
				break;
			case 6:
				reg[ram1] = (reg[ram1] + reg[ram2]) % 1000;
				++numExecutions;
				break;
			case 7:
				reg[ram1] = (reg[ram1] * reg[ram2]) % 1000;
				++numExecutions;
				break;
			case 8:
				reg[ram1] = Integer.parseInt(ram[reg[ram2]]);
				++numExecutions;
				break;
			case 9:
				ram[reg[ram2]] = String.valueOf(reg[ram1]);
				++numExecutions;
				break;
			case 0:
				if (reg[ram2] != 0) {
					ramInstruction = reg[ram1];
					++numExecutions;
					continue;
				}
				++numExecutions;
				break;
			}
			++ramInstruction;
		}
	}

}