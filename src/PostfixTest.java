import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.jupiter.api.DisplayName;

public class PostfixTest {
	
	Postfix tester;
	
	@Before
	public void setup() {
		tester = new Postfix();
	}
	
	@Test
	public void testRpnEvaluate() throws StackUnderflowException {
		String rpn = "1 2 * 3 + ";
		assertEquals(5, tester.evaluate(rpn), 0.01);
	}
	
	@Test
	public void rpnEvaluateTest2() throws StackUnderflowException {
		String rpn = "1 2 3 * +";
		assertEquals(7, tester.evaluate(rpn), 0.01);
	}
	
	@Test
	public void rpnEvaluateTest3() throws StackUnderflowException {
		String rpn = "1 2 + 3 4 ^ -";
		assertEquals(-78, tester.evaluate(rpn), 0.01);
	}
	
	@Test
	public void rpnEvaluateTest4() throws StackUnderflowException {
		String rpn = "1 2 ^ 3 4 * -";
		assertEquals(-11, tester.evaluate(rpn), 0.01);
	}
	
	@Test
	public void rpnEvaluateTest5() throws StackUnderflowException {
		String rpn = "1 2 3 * + 4 5 ^ - 6 +";
		assertEquals(-1011, tester.evaluate(rpn), 0.01);
	}
	
	@Test
	public void rpnEvaluateTest6() throws StackUnderflowException {
		String rpn = "12+3*456-^+";
		assertEquals(9.25, tester.evaluate(rpn), 0.01);
	}
	
	@Test
	public void rpnEvaluateTest7() throws StackUnderflowException {
		String rpn = "12+34/+5+678+*+";
		assertEquals(98.75, tester.evaluate(rpn), 0.01);
	}
	
	@Test
	public void rpnEvaluateTest8() throws StackUnderflowException {
		String rpn = "91-2-32*-1-";
		assertEquals(-1, tester.evaluate(rpn), 0.01);
	}
	
}