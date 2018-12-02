package calculator;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Instruction
{
	@Getter
	@Setter
	private String operator;
	
	@Getter
	@Setter
	private double number;
	
}
