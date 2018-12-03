package calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CalculatorTest
{

	@Test
	public void testPrepareToCalculate()
	{
		Calculator calculator = new Calculator(new BigDecimal("10.0"));

		List<Instruction> instructionList = Arrays.asList(new Instruction("add", new BigDecimal("10.0")),
				new Instruction("subtract", new BigDecimal("8.0")), new Instruction("multiply", new BigDecimal("2.0")),
				new Instruction("divide", new BigDecimal("7.0")), new Instruction("apply", new BigDecimal("10.0")));

		List<Instruction> actualInstructions = calculator.prepareToCalculate(instructionList);
		List<Instruction> expectedInstructions = Arrays.asList(new Instruction("add", new BigDecimal("10.0")),
				new Instruction("subtract", new BigDecimal("8.0")), new Instruction("multiply", new BigDecimal("2.0")),
				new Instruction("divide", new BigDecimal("7.0")));

		assertEquals(expectedInstructions, actualInstructions);
	}

	@Test
	public void testPrepareToCalculate_withOnlyOneInstruction()
	{
		Calculator calculator = new Calculator(new BigDecimal("10"));

		List<Instruction> instructionList = Arrays.asList(new Instruction("apply", BigDecimal.TEN));

		List<Instruction> actualInstructions = calculator.prepareToCalculate(instructionList);
		List<Instruction> expectedInstructions = Arrays.asList();

		assertEquals(expectedInstructions, actualInstructions);
	}

	@Test
	public void testCalculate()
	{
		Calculator calculator = new Calculator(new BigDecimal("5.00"));

		List<Instruction> instructionList = Arrays.asList(new Instruction("add", new BigDecimal("10.00")),
				new Instruction("subtract", new BigDecimal("8.00")),
				new Instruction("multiply", new BigDecimal("2.00")), new Instruction("divide", new BigDecimal("3.50")));

		BigDecimal actual = calculator.calculate(instructionList);

		assertEquals(new BigDecimal("4.00"), actual);
	}

	@Test
	public void testCalculate_shouldThrowException()
	{
		Calculator calculator = new Calculator(BigDecimal.valueOf(5.0));

		List<Instruction> instructionList = Arrays.asList(new Instruction("add", new BigDecimal("10.0")),
				new Instruction("subtract", new BigDecimal("6.0")), new Instruction("multiply", new BigDecimal("5.15")),
				new Instruction("divide", BigDecimal.ZERO));

		try
		{
			calculator.calculate(instructionList);
			fail("Should throw exception - divison by 0!");

		} catch (Exception e)
		{
		}

	}

	@Test
	public void testCalculate_withEmptyInstructionList()
	{
		Calculator calculator = new Calculator(new BigDecimal("5.0"));

		List<Instruction> instructionList = Arrays.asList();

		BigDecimal actual = calculator.calculate(instructionList);

		assertEquals(new BigDecimal("5.0"), actual);
	}
}
