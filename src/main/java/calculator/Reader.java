package calculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reader
{

	public Reader()
	{
	}

	public BufferedReader checkFile(String path)
	{
	try
		{
			BufferedReader bufReader = new BufferedReader(new FileReader(path));
			return bufReader;

		} catch (FileNotFoundException e)
		{
			throw new RuntimeException(e.getMessage());
		}

	}

	public List<String> readLines(BufferedReader bufReader)
	{
		return bufReader.lines().collect(Collectors.toList());

	}

	public List<Instruction> readInstructions(List<String> list)
	{
		List<Instruction> instructionlist = new ArrayList<>();

		String sign;
		Double num;

		for (String line : list)
		{
			Instruction instruction = new Instruction();

			sign = line.substring(0, line.indexOf(' '));
			instruction.setOperator(sign);

			num = Double.valueOf(line.substring(line.indexOf(' ')));
			instruction.setNumber(num);

			instructionlist.add(instruction);
		}

		return instructionlist;
	}

	public double getStartNumber(List<String> list)
	{
		String apply = list.get(list.size() - 1);

		apply = apply.substring(6);    // "apply " has 6 chars

		return Double.valueOf(apply);
	}

}
