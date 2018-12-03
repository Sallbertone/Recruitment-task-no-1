package calculator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class InstructionReaderTest
{

	@Test
	public void testReadInstructions()
	{

		List<String> lineList = Arrays.asList("add 10", "subtract 8", "multiply 2", "apply 5");
		List<Instruction> actual = InstructionReader.readInstructions(lineList);
		List<Instruction> expected = Arrays.asList(new Instruction("add", new BigDecimal("10")),
				new Instruction("subtract", new BigDecimal("8")), new Instruction("multiply", new BigDecimal("2")),
				new Instruction("apply", new BigDecimal("5")));

		assertEquals(expected, actual);

	}

	@Test
	public void testGetStartNumber()
	{
		List<String> lineList = Arrays.asList("add 10", "subtract 8", "multiply 2", "apply 5");

		assertEquals(new BigDecimal("5"), InstructionReader.getStartNumber(lineList));
	}

	@Test
	public void testGetStartNumber_fileWithOnlyuOneInstruction()
	{
		List<String> lineList = Arrays.asList("apply 5.7");

		assertEquals(new BigDecimal("5.7"), InstructionReader.getStartNumber(lineList));
	}

}
