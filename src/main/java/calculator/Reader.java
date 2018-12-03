package calculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Reader
{

	public Reader()
	{
	}

	public static BufferedReader checkFile(String path)
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

	public static List<String> readLines(BufferedReader bufReader)
	{
		return bufReader.lines().collect(Collectors.toList());

	}

}
