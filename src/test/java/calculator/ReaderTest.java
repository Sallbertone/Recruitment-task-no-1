package calculator;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ReaderTest
{

	@Test
	public void testReadLines()
	{
		BufferedReader bufferedReader = new BufferedReader(new StringReader("line1\nline2\nline3\nline4"));

		List<String> actual = Reader.readLines(bufferedReader);
		List<String> expected = Arrays.asList("line1", "line2", "line3", "line4");

		assertEquals(expected, actual);

	}



}
