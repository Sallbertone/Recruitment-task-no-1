package calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InstructionReader
{

	public InstructionReader()
	{
	}

	public static List<Instruction> readInstructions(List<String> list)
	{
		List<Instruction> instructionlist = new ArrayList<>();

		for (String line : list)
		{

			String sign = line.substring(0, line.indexOf(' '));
			String num = line.substring(line.indexOf(' ') + 1);
			BigDecimal number = new BigDecimal(num);

			Instruction instruction = new Instruction(sign, number);

			instructionlist.add(instruction);
		}

		return instructionlist;
	}

	public static BigDecimal getStartNumber(List<String> list)
	{
		final int TOKEN_LENGTH = "apply ".length();

		String apply = list.get(list.size() - 1);
		apply = apply.substring(TOKEN_LENGTH);
		BigDecimal num = new BigDecimal(apply);

		return num;
	}

}
