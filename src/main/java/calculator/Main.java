package calculator;

import java.io.BufferedReader;
import java.util.List;

public class Main
{

	public static void main(String[] args)
	{

		String path = "C://Users/Admin/Desktop/numbers.txt";

		Reader reader = new Reader();
		
		BufferedReader bufferedReader = reader.checkFile(path);

		List<String> lineList = reader.readLines(bufferedReader);
		List<Instruction> instructions = reader.readInstructions(lineList);

		double number = reader.getStartNumber(lineList);

		Calculator calculator = new Calculator(number);

		instructions = calculator.prepareToCalculate(instructions);

		double result = calculator.calculate(instructions);

		System.out.println(result);

	}



}
