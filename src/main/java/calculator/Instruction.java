package calculator;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class Instruction
{
	@Getter
	private String operator;
	
	@Getter
	private BigDecimal number;
	
}
