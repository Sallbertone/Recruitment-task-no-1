package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator
{

	private BigDecimal number;
	private Map<String, BiFunction<BigDecimal, BigDecimal, BigDecimal>> calculationMap;

	public Calculator(BigDecimal number)
	{
		this.number = number;

		this.calculationMap = new HashMap<>();

		calculationMap.put("add", (a, b) -> a.add(b));
		calculationMap.put("subtract", (a, b) -> a.subtract(b));
		calculationMap.put("multiply", (a, b) -> a.multiply(b));
		calculationMap.put("divide", (a, b) -> a.divide(b, 2, RoundingMode.HALF_EVEN));
	}

	public List<Instruction> prepareToCalculate(List<Instruction> instructions)
	{
		// instructions.stream().filter(i -> !i.getOperator().equals("apply")).collect(Collectors.toList());
		List<Instruction> instructionsWithoutApply = instructions.subList(0, instructions.size() - 1);

		return instructionsWithoutApply;

	}

	public BigDecimal calculate(List<Instruction> instructionList)
	{
		BigDecimal result = number;

		for (Instruction instruction : instructionList)
		{
			if (instruction.getNumber() == BigDecimal.ZERO && instruction.getOperator().equals("divide"))
				throw new RuntimeException("Division by 0 !!!");

			result = calculationMap.get(instruction.getOperator()).apply(result, instruction.getNumber());

		}

		return result;

	}

}
