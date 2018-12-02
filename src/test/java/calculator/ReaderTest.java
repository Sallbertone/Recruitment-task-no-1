package calculator;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ReaderTest
{

	Reader reader;

	@Before
	public void setUp() throws Exception
	{
		reader = new Reader();
	}

	@Test
	public void testReadLines()
	{
		BufferedReader bufferedReader = new BufferedReader(new StringReader("line1\nline2\nline3\nline4"));

		List<String> actual = reader.readLines(bufferedReader);
		List<String> expected = Arrays.asList("line1", "line2", "line3", "line4");

		assertEquals(expected, actual);

	}

	@Test
	public void testReadInstructions()
	{

		List<String> lineList = Arrays.asList("add 10", "substract 8", "multiply 2", "apply 5");
		List<Instruction> actual = reader.readInstructions(lineList);
		List<Instruction> expected = Arrays.asList(new Instruction("add", 10.0), new Instruction("substract", 8.0),
				new Instruction("multiply", 2.0), new Instruction("apply", 5.0));

		assertEquals(expected, actual);

	}

	@Test
	public void testGetStartNumber()
	{
		List<String> lineList = Arrays.asList("add 10", "substract 8", "multiply 2", "apply 5");

		assertEquals(5.0, reader.getStartNumber(lineList), 0.000000000000000001);

	}

	@Test
	public void testGetStartNumber_fileWithOnlyuOneInstruction()
	{
		List<String> lineList = Arrays.asList("apply 5.7");

		assertEquals(5.7, reader.getStartNumber(lineList), 0.000000000000000001);

	}

}
