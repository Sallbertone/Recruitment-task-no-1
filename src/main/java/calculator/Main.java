package calculator;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.util.List;

public class Main
{

	public static void main(String[] args)
	{

		String path = "C://Users/Admin/Desktop/numbers.txt";

		BufferedReader bufferedReader = Reader.checkFile(path);

		List<String> lineList = Reader.readLines(bufferedReader);
		
		List<Instruction> instructions = InstructionReader.readInstructions(lineList);

		BigDecimal number = InstructionReader.getStartNumber(lineList);

		Calculator calculator = new Calculator(number);

		instructions = calculator.prepareToCalculate(instructions);

		BigDecimal result = calculator.calculate(instructions);

		System.out.println(result);

	}



}
