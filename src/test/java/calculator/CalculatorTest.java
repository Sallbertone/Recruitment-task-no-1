package calculator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CalculatorTest
{

	@Test
	public void testPrepareToCalculate()
	{
		Calculator calculator = new Calculator(10.0);
		
		List<Instruction> instructionList = Arrays.asList(new Instruction("add", 10.0), new Instruction("substract", 8.0),
				new Instruction("multiply", 2.0), new Instruction("divide", 7.0), new Instruction("apply", 10.0));
		
		List<Instruction> actualInstructions = calculator.prepareToCalculate(instructionList);
		List<Instruction> expectedInstructions = Arrays.asList(new Instruction("add", 10.0), new Instruction("substract", 8.0),
				new Instruction("multiply", 2.0), new Instruction("divide", 7.0));
		
		assertEquals(expectedInstructions, actualInstructions);
	}
	
	@Test
	public void testPrepareToCalculate_withOnlyOneInstruction()
	{
		Calculator calculator = new Calculator(10.0);
		
		List<Instruction> instructionList = Arrays.asList(new Instruction("apply", 10.0));
		
		List<Instruction> actualInstructions = calculator.prepareToCalculate(instructionList);
		List<Instruction> expectedInstructions = Arrays.asList();
		
		assertEquals(expectedInstructions, actualInstructions);
	}
	
	
	@Test
	public void testCalculate()
	{
		Calculator calculator = new Calculator(5.0);
		
		List<Instruction> instructionList = Arrays.asList(new Instruction("add", 10.0), new Instruction("substract", 8.0),
				new Instruction("multiply", 2.0), new Instruction("divide", 7.0));
		
		double actual = calculator.calculate(instructionList);
		
		assertEquals(2.0, actual, 0.00000000000001);
	}
	
	@Test
	public void testCalculate_shouldThrowException()
	{
		Calculator calculator = new Calculator(5.0);
		
		List<Instruction> instructionList = Arrays.asList(new Instruction("add", 10.0), new Instruction("substract", 8.0),
				new Instruction("multiply", 2.0), new Instruction("divide", 0.0));
		
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
		Calculator calculator = new Calculator(5.0);
		
		List<Instruction> instructionList = Arrays.asList();
		
		double actual = calculator.calculate(instructionList);
		
		assertEquals(5.0, actual, 0.00000000000001);
	}
}
