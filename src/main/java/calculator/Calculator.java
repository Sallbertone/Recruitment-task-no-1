package calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Calculator
{

	private double number;
	
	public Calculator(double number)
	{
		this.number = number;
	}

	public List<Instruction> prepareToCalculate(List<Instruction> instructions)
	{
		return instructions.stream().filter(i -> !i.getOperator().equals("apply")).collect(Collectors.toList());
	}
	
	public double calculate(List<Instruction> instructionList)
	{
		double result = number;
		
		Map<String, BiFunction<Double, Double, Double>> calculationMap = new HashMap<>();
		
		calculationMap.put("add", (a, b) -> a + b );
		calculationMap.put("substract", (a, b) -> a - b );
		calculationMap.put("multiply", (a, b) -> a * b );
		calculationMap.put("divide", (a, b) -> a / b );
		
		for (Instruction instruction : instructionList)
		{
			if(instruction.getNumber() == 0.0 && instruction.getOperator().equals("divide")) throw new RuntimeException("Division by 0 !!!");
			
			result = calculationMap.get(instruction.getOperator()).apply(result, instruction.getNumber());
	
		}
				
		return result;
		
	}
	
}
